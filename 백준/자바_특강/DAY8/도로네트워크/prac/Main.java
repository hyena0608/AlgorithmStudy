//package 백준.자바_특강.DAY8.도로네트워크.prac;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static int N, M;
//    static int depthMAX = 18;
//    static long DMAX = Long.MAX_VALUE;
//    static int[][] parent, max, min;
//    static int[] depth;
//    static boolean[] visited;
//    static long[] D;
//    static List<int[]>[] adj;
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("백준/자바_특강/DAY8/도로네트워크/input.txt"));
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        adj = new ArrayList[N + 1];
//
//        for (int i = 1; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//
//            adj[a].add(new int[] {b, c});
//            adj[b].add(a);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        parent = new int[depthMAX][N + 1];
//        depth = new int[N + 1];
//        visited = new boolean[N + 1];
//
//        queue.add(1);
//        visited[1] = true;
//        while (!queue.isEmpty()) {
//            int vertex = queue.poll();
//            for (int i = 0; i < edges[vertex].size(); i++) {
//                int next = edges[vertex].get(i);
//                if (!visited[next]) {
//                    visited[next] = true;
//                    depth[next] += depth[vertex] + 1;
//                    parent[0][next] = vertex;
//                    queue.add(next);
//                }
//            }
//        }
//
////        for (int i = 1; i <= N; i++) {
////            List<Route> routes = adj[i];
////            for (Route route : routes) {
////                System.out.println(route.a + " : " + route.b);
////            }
////        }
//
//
////        for (int[] ints : parent) {
////            for (int anInt : ints) {
////                System.out.print(anInt + " ");
////            }
////            System.out.println();
////        }
////        System.out.println();
//
//        for (int i = 1; i < depthMAX; i++) {
//            for (int j = 1; j <= N; j++) {
//                parent[i][j] = parent[i - 1][parent[i - 1][j]];
//            }
//        }
//
//
//        D = new long[N + 1];
//        Arrays.fill(D, DMAX);
//        D[1] = 0;
//        shortestD = new long[N + 1];
//        Arrays.fill(shortestD, DMAX);
//        shortestD[1] = 0;
//        longestD = new long[N + 1];
//        Arrays.fill(longestD, DMAX);
//        longestD[1] = 0;
////        visitiedCount = new long[N + 1];
//        visited = new boolean[N + 1];
//        // 정점 a에서 정점 b의 최소 경로와 최대 경로를 찾는다. // 다익스트라 ?
//        dijkstra();
//
//        // a, b의 lca를 찾는다.
//        StringBuffer sb = new StringBuffer();
//        M = Integer.parseInt(br.readLine());
//        for (int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int parent = lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
////            System.out.println("parent = " + parent);
//            sb.append(shortestD[parent + 1]).append(" ").append(longestD[parent + 1]).append("\n");
//        }
//
//        System.out.print(sb.toString());
//    }
//
//    static void dijkstra() {
//        PriorityQueue<Route> queue = new PriorityQueue<>(Comparator.comparingLong(Route::getC));
////        List<Route> afterShortest = new ArrayList<>();
//        queue.add(new Route(0, 1, 0));
////        boolean finishedShortest = false;
//
//        int shortestCount = 0;
//        while (!queue.isEmpty()) {
//            Route poll = queue.poll();
//            if (poll.c == DMAX) continue;
//
////            if (visited[poll.b] == false) {
////                visited[poll.b] = true;
//            shortestCount++;
////            System.out.println("shortestCount = " + shortestCount);
////            System.out.println(poll.a + " " + poll.b + " " + poll.c);
//            D[poll.b] = poll.c;
//
//            if (shortestCount == N) {
//                shortestD = Arrays.copyOf(D, D.length);
//            }
//
//            for (Route next : adj[poll.b]) {
//                queue.add(new Route(next.a, next.b, poll.c + next.c));
//            }
////            }
//        }
//        longestD = Arrays.copyOf(D, D.length);
//    }
//
//    static int lca(int a, int b) {
//        if (depth[a] < depth[b]) {
//            int temp = b;
//            b = a;
//            a = temp;
//        }
//
//        // 두 깊이의 차이
//        int gap = depth[a] - depth[b];
//
//        // 깊이 맞춰주기
//        for (int i = 1; i <= depthMAX; i++) {
//            if ((gap & (1 << i)) > 0) {
//                a = parent[i][a];
//            }
//        }
//
//        // 최소 조상 찾기
//        for (int i = depthMAX - 1; i >= 0; i--) {
//            if (parent[i][a] != parent[i][b]) {
//                a = parent[i][a];
//                b = parent[i][b];
//            }
//        }
//
//        return parent[0][a];
//    }
//}
//
//class Route {
//    int a, b;
//    long c;
//
//    public Route(int a, int b, long c) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//    }
//
//    public long getC() {
//        return c;
//    }
//}