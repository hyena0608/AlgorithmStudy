package 백준.자바_특강.DAY8.도로네트워크;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Route>[] adj;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY8/도로네트워크/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        parent = new int[N + 1];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Route route = new Route(a, b, c);
            route.max = c;
            route.min = c;
            adj[a].add(new Route(a, b, c));
            union(a, b, c);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

        }
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        else {
            return find(parent[a]);
        }
    }

    static void union(int a, int b, int c) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;

        for (Route route : adj[a]) {
            route.min = Math.min(route.min, c);
            route.max = Math.max(route.max, c);
        }
    }

}

class Route {
    int a, b, c;
    int min, max;

    public Route(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}