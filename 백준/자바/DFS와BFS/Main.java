package 백준.자바.DFS와BFS;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] graphArr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graphArr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int idx = 0; idx < m; idx++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int startV = Integer.parseInt(stringTokenizer.nextToken());
            int endV = Integer.parseInt(stringTokenizer.nextToken());

            graphArr[startV][endV] = 1;
            graphArr[endV][startV] = 1;
        }

        dfs(0, n, v);
        bw.write("\n");
        visited = new boolean[n + 1];
        bfs(n, v);


        bw.flush();
        bw.close();
        br.close();

    }

    private static void bfs(int n, int v) throws IOException {
        Queue<Integer> Q = new LinkedList<>();

        Q.offer(v);
        visited[v] = true;
        bw.write(v + " ");
        while (!Q.isEmpty()) {
            Integer polledV = Q.poll();

            for (int i = 1; i <= n; i++) {
                if (graphArr[polledV][i] == 1 && !visited[i]) {
                    Q.offer(i);
                    bw.write(i + " ");
                    visited[i] = true;
                }
            }
        }

    }

    private static void dfs(int L, int n, int v) throws IOException {
        visited[v] = true;
        bw.write(v + " ");
        if (L == n) {
            return;
        }

        for (int idx = 1; idx <= n; idx++) {
            if (graphArr[v][idx] == 1 && !visited[idx]) {
                dfs(L + 1, n, idx);
            }
        }
    }
}
