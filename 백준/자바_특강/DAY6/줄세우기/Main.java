package 백준.자바_특강.DAY6.줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] indegree;
    static List<Integer>[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNM = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stNM.nextToken());
        M = Integer.parseInt(stNM.nextToken());

        indegree = new int[N + 1];
        parent = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            parent[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            parent[vertex].forEach(child -> {
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.add(child);
                }
            });
        }

    }

}
