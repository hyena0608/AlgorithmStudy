package 백준.자바_특강.DAY5.사전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp = new int[201][201];
    static int N, M;
    static long K;
    static int Z;
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        query(N, M, K);

        if (combi(N + M, M) < K) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    // target = k
    static void query(int n, int m, long k) {

        if (n + m == 0) {
            return;
        } else if (n == 0) {
            answer += "z";
            query(n, m - 1, k);
        } else if (m == 0) {
            answer += "a";
            query(n - 1, m, k);
        } else {
            int up = combi(n + m - 1, m);
            if (up >= k) {
                answer += "a";
                query(n - 1, m, k);
            } else {
                answer += "z";
                query(n, m - 1, k - up);
            }
        }

    }

    static int combi(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else if (dp[n][r] != 0) {
            return dp[n][r];
        } else {
            return dp[n][r] = Math.min((int) 1e9, combi(n - 1, r - 1) + combi(n - 1, r));
        }

    }
}
