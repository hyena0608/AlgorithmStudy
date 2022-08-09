package 백준.자바.RGB거리_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] houses;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        houses = new int[N][3 + 1];
        dp = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 1; j <= 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) dp[0][j] = houses[0][j];
            }
        }


        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (k != j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + houses[i][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            answer = Math.min(dp[N - 1][i], answer);
        }
        System.out.println(answer);
    }
}
