package 백준.자바.계단오르기_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] stairs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stairs = new int[300 + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[3][300 + 1];

        dp[1][1] = stairs[1];
        dp[1][2] = dp[1][1] + stairs[2];
        dp[2][2] = stairs[2];
        for (int i = 1; i < N; i++) {
            // 1 -> 2
            if (i + 2 <= N) dp[2][i + 2] = Math.max(dp[2][i + 2], dp[1][i] + stairs[i + 2]);
            // 2 -> 1
            if (i + 1 <= N) dp[1][i + 1] = Math.max(dp[1][i + 1], dp[2][i] + stairs[i + 1]);
            // 2 -> 2
            if (i + 2 <= N) dp[2][i + 2] = Math.max(dp[2][i + 2], dp[2][i] + stairs[i + 2]);
        }
        System.out.println(Math.max(dp[1][N], dp[2][N]));
    }
}