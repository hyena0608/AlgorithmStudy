package 백준.자바_특강.DAY7.K번째최단경로찾기.prac;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MAX = Integer.MAX_VALUE;
    static int N, M, K;
    static List<Edge>[] adj;
    static long[] value;
    static int[] visitedCount;
//    static int[] secondValue;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY7/K번째최단경로찾기/input.txt"));
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
        Arrays.fill(value, MAX);
        value[1] = 0;
        visitedCount = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getC));

        // 루트 노드에서 시작한다.
        queue.add(new Edge(1, 0));
        while (!queue.isEmpty()) {
            // 최소 가중치를 가져온다.
            Edge poll = queue.poll();

            if (visitedCount[poll.b] < K) {
                // 뽑은 최소 가중치를 가진 정점이 K번 미만 뽑혔을 때
                // 해당 정점 뽑힌 횟수 증가
                visitedCount[poll.b]++;
                // 뽑힌 정점의 가중치 최신화
//                secondValue[poll.b] = poll.c;

                // 뽑힌 정점의 기존 가중치 변경
                value[poll.b] = poll.c;

                for (Edge next : adj[poll.b]) {
                    if (visitedCount[next.b] < K) {
                        // 연결된 정점이 K번 미만 뽑혔을 때
                        // 뽑힌 정점에서 갈 수 있는 정점과 가중치 최신화 등록
                        queue.add(new Edge(next.b, poll.c + next.c));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (visitedCount[i] != K) {
                sb.append("-1").append("\n");
            } else {
                sb.append(value[i]).append("\n");
            }
        }
        System.out.print(sb.toString());


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
