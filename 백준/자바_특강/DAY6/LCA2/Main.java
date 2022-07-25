package 백준.자바_특강.DAY6.LCA2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] depth;
    static int[][] parent;
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("백준/자바_특강/DAY6/LCA2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        edges = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }


        // 깊이 구하기
        Queue<Integer> queue = new LinkedList<>();
        depth = new int[N + 1];
        parent = new int[18][N + 1];
        boolean[] visited = new boolean[N + 1];

        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int i = 0; i < edges[vertex].size(); i++) {
                int next = edges[vertex].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] += depth[vertex] + 1;
                    parent[0][next] = vertex;
                    queue.add(next);
                }
            }
        }

        // V정점의 2^k번째 조상 번호 구하기
        for (int i = 1; i < 18; i++) {
            for (int j = 1; j < N + 1; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }

        // 두 개의 정점 받기
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a, b));
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int diff = depth[a] - depth[b];

        for (int i = 0; i <= 17; i++) {
            if ((diff & (1 << i)) > 0) {
                a = parent[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = 17; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        return parent[0][a];
    }

}
