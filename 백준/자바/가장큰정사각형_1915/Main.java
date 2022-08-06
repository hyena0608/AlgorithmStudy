package 백준.자바.가장큰정사각형_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                dp[i][j] = c[j - 1] - '0';
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (dp[i][j] != 1) continue;
                int left = dp[i][j - 1];
                int leftUp = dp[i - 1][j - 1];
                int up = dp[i - 1][j];

                int min = Math.min(left, Math.min(leftUp, up));
                dp[i][j] = min + 1;
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer * answer);
    }
}