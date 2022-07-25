package 백준.자바_특강.DAY6.네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Edge> edgeList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edgeList = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(a, b, c));
        }

        Collections.sort(edgeList, Comparator.comparingInt(Edge::getC));

        int answer = 0;
        int edgeCount = 0;
        for (int i = 0; i < M; i++) {
            if (edgeCount == N - 1) {
                break;
            }
            Edge edge = edgeList.get(i);
            if (find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                answer += edge.c;
                edgeCount++;
            }
        }

        System.out.println(answer);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

}

class Edge {
    int a, b, c;

    public Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getC() {
        return c;
    }
}
