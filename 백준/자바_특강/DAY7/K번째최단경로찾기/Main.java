package 백준.자바_특강.DAY7.K번째최단경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MAX = Integer.MAX_VALUE;
    static int N, M, K;
    static List<Edge>[] adj;
    static long[] value;
    static int[] visitedCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNMK = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNMK.nextToken());
        M = Integer.parseInt(stNMK.nextToken());
        K = Integer.parseInt(stNMK.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        value = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            value[i] = MAX;
        }
        visitedCount = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getC));

        for (Edge edge : adj[1]) {
            queue.add(edge);
        }

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();

            if (visitedCount[poll.b] < K) {
                visitedCount[poll.b]++;

                value[poll.b] = poll.c;
                for (Edge next : adj[poll.b]) {
                    queue.add(new Edge(next.b, poll.c + next.c));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (value[i] == MAX) {
                sb.append("-1").append("\n");
            } else {
                if (visitedCount[i] != K) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(value[i]).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}

class Edge {
    int b, c;

    public Edge(int b, int c) {
        this.b = b;
        this.c = c;
    }

    public int getC() {
        return c;
    }
}
