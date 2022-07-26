package 백준.자바_특강.DAY7.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E, K;
    static boolean[] visited;
    static int[] value;
    static List<Vertex>[] adj;
    static int MAX = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stVE = new StringTokenizer(br.readLine());

        V = Integer.parseInt(stVE.nextToken());
        E = Integer.parseInt(stVE.nextToken());
        K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[V + 1];
        value = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            value[i] = MAX;
        }
        value[K] = 0;

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Vertex(u, v, w));
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(Vertex::getValue));
        for (Vertex next : adj[K]) {
            queue.add(next);
        }
        visited[K] = true;

        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            if (!visited[poll.v]) {
                visited[poll.v] = true;
                value[poll.v] = poll.value;
                for (Vertex next : adj[poll.v]) {
                    queue.add(new Vertex(next.u, next.v, value[poll.v] + next.value));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (i == K) {
                System.out.println("0");
            } else if (value[i] != MAX) {
                System.out.println(value[i]);
            } else {
                System.out.println("INF");
            }
        }
    }


}

class Vertex {
    int u, v;
    int value;

    public Vertex(int u, int v, int value) {
        this.u = u;
        this.v = v;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
