package 백준.자바_특강.DAY8.거의최단경로;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, S, D;
    static int[][] adj;
    static int[] value;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("백준/자바_특강/DAY8/거의최단경로/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            adj = new int[N][N];
            value = new int[N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                adj[a][b] = c;
            }

            dijkstra();
            deleteShortestRoute();
            dijkstra();

            if (value[D] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(value[D]);
            }
        }
    }

    // 최단 경로 삭제
    static void deleteShortestRoute() {
        Queue<Integer> queue = new LinkedList<>();
        // 역으로 시작할 D를 넣는다.
        queue.add(D);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < N; i++) {
                //
                if (adj[i][current] != 0 && value[current] == value[i] + adj[i][current]) {
                    adj[i][current] = 0;
                    queue.add(i);
                }
            }
        }
    }

    static void dijkstra() {
        Arrays.fill(value, Integer.MAX_VALUE);
        value[S] = 0;
        PriorityQueue<Route> queue = new PriorityQueue<>(Comparator.comparingInt(Route::getC));
        // 시작점 S
        queue.add(new Route(0, S, 0));
        while (!queue.isEmpty()) {
            Route poll = queue.poll();
            // 정점 b까지의 가중치를 설정한다.
            for (int i = 0; i < N; i++) {
                //  현재 정점 b에 대해서 연결된 정점을 찾는다.
                if (adj[poll.b][i] != 0) {
                    // 정점 b와 연결될 정점 i 이 있다면
                    if (value[i] > poll.c + adj[poll.b][i]) {
                        // 발견된 정점 i까지 기존 가중치가
                        // 정점 b까지의 가중치 + 정점 b에서 i까지의 가중치를 더했을 떄 보다 클 때
                        // 큐에 i와 연결된 정점들과 그에 대한 가중치를 최신화하여 넣는다.
                        value[i] = poll.c + adj[poll.b][i];
                        queue.add(new Route(poll.b, i, poll.c + adj[poll.b][i]));
                    }
                }
            }
        }
    }
}

class Route {
    int a, b, c;

    public Route(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getC() {
        return c;
    }
}