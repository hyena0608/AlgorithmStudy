package 백준.자바.부분수열의합;

import java.io.*;
import java.util.*;

public class Main {
    static int n, s, answer;
    static int[] arr;

    public void dfs(int L, int[] visited) {
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 1) sum += arr[i];
            }
            if (sum == s) answer++;
        } else {
            visited[L] = 1;
            dfs(L + 1, visited);
            visited[L] = 0;
            dfs(L + 1, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNS = new StringTokenizer(br.readLine());
        StringTokenizer stArr = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stNS.nextToken());
        s = Integer.parseInt(stNS.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }
        int[] visited = new int[n];
        T.dfs(0, visited);

        if (s == 0) answer--;
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
