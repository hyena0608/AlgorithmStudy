package 백준.자바.바이러스;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] network = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            network[num1][num2] = 1;
            network[num2][num1] = 1;
        }


        int answer = T.bfs(network, visited, n, 0);


        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int[][] network, boolean[] visited, int n, int answer) {

        Queue<Integer> infectedQ = new LinkedList<>();
        infectedQ.add(1);
        visited[1] = true;

        while (!infectedQ.isEmpty()) {
            Integer infectedComputer = infectedQ.poll();
            for (int i = 1; i <= n; i++) {
                if (network[infectedComputer][i] == 1 && !visited[i]) {
                    infectedQ.add(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }
        return answer;
    }
}
