//package 백준.자바_특강.DAY8.도로네트워크;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static int N, M;
//    static List<Route>[] adj;
//    static int[][] parent;
//    static int[] depth;
//    static int[][] min;
//    static int[][] max;
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("백준/자바_특강/DAY8/도로네트워크/input.txt"));
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        adj = new ArrayList[N + 1];
//        for (int i = 1; i <= N; i++) {
//            adj[i] = new ArrayList<>();
//        }
//
//        parent = new int[18][N + 1];
//        depth = new int[N + 1];
//        min = new int[N + 1][N + 1];
//        max = new int[N + 1][N + 1];
//
//        for (int i = 1; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//
//            // 간선 추가
//            adj[a].add(new Route(a, b, c));
//            adj[b].add(new Route(b, a, c));
//        }
//
//        // 깊이, parent 만들기
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        boolean[] visited = new boolean[N + 1];
//        while (!queue.isEmpty()) {
//            int curr = queue.poll();
//            for (int i = 1; i <= N; i++) {
//                Route next = adj[curr].get(i);
//                if (visited[next.b] == false) {
//                    // 자식 정점의 깊이 설정해주기
//                    depth[next.b] = depth[curr] + 1;
//                    // 자식 정점의 2^0번째 조상 정점 설정해주기
//                    parent[0][next.b] = curr;
//                    // 자식 정점의 2^0번째 조상의 최대 최소 설정
//                    min[0][next.b] = Math.min(next.b, );
//                    // 자식 정점에 이어진 자식 노드 큐에 추가
//                    queue.add(next.b);
//                }
//            }
//        }
//
//
//        // parent[][] 구성
//        for (int i = 1; i < 18; i++) {
//            for (int j = 1; j <= N; j++) {
//                parent[i][j] = parent[i - 1][parent[i - 1][j]];
//            }
//        }
//
//
//        M = Integer.parseInt(br.readLine());
//        for (int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//        }
//    }
//
//
//}
//
//class Route {
//    int a, b, c;
//
//    public Route(int a, int b, int c) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//    }
//}