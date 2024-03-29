package 백준.자바.도로네트워크_3176;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int A, B, W;
    static int D;
    static List<Route> adj[];
    static int[][] parentLCA;
    static int[][] MAX_ROAD, MIN_ROAD;
    static int[] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (; (1 << D) < N; D++) ;

        parentLCA = new int[D][N + 1];
        MAX_ROAD = new int[D][N + 1];
        MIN_ROAD = new int[D][N + 1];
        depth = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            adj[A].add(new Route(B, W));
            adj[B].add(new Route(A, W));
        }

        init();
        makeParent();

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int[] answer = lca(u, v);

            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    static int[] lca(int u, int v) {

        int minRoad = Integer.MAX_VALUE;
        int maxRoad = Integer.MIN_VALUE;

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int gap = depth[u] - depth[v];

        for (int i = 0; i <= D; i++) {
            if (((gap & (1 << i)) > 0)) {
                minRoad = Math.min(minRoad, MIN_ROAD[i][u]);
                maxRoad = Math.max(maxRoad, MAX_ROAD[i][u]);
                u = parentLCA[i][u];
            }
        }

        if (u != v) {
            for (int i = D - 1; i >= 0; i--) {
                int findU = parentLCA[i][u];
                int findV = parentLCA[i][v];
                if (findU != findV) {
                    minRoad = Math.min(minRoad, Math.min(MIN_ROAD[i][u], MIN_ROAD[i][v]));
                    maxRoad = Math.max(maxRoad, Math.max(MAX_ROAD[i][u], MAX_ROAD[i][v]));
                    u = findU;
                    v = findV;
                }
            }

            minRoad = Math.min(minRoad, Math.min(MIN_ROAD[0][u], MIN_ROAD[0][v]));
            maxRoad = Math.max(maxRoad, Math.max(MAX_ROAD[0][u], MAX_ROAD[0][v]));
        }
        return new int[]{minRoad, maxRoad};
    }

    static void makeParent() {
        for (int i = 1; i < D; i++) {
            for (int j = 1; j <= N; j++) {
                parentLCA[i][j] = parentLCA[i - 1][parentLCA[i - 1][j]];
                MIN_ROAD[i][j] = Math.min(MIN_ROAD[i - 1][j], MIN_ROAD[i - 1][parentLCA[i - 1][j]]);
                MAX_ROAD[i][j] = Math.max(MAX_ROAD[i - 1][j], MAX_ROAD[i - 1][parentLCA[i - 1][j]]);
            }
        }
    }

    static void init() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        depth[1] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Route next : adj[curr]) {
                if (depth[next.b] > 0) continue;
                MAX_ROAD[0][next.b] = next.w;
                MIN_ROAD[0][next.b] = next.w;
                depth[next.b] = depth[curr] + 1;
                parentLCA[0][next.b] = curr;
                queue.add(next.b);
            }
        }
    }

}

class Route {
    int b, w;

    public Route(int b, int w) {
        this.b = b;
        this.w = w;
    }
}