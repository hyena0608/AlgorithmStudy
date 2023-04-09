package 백준.자바.평벙한배낭_12865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_K = 100_000;
    private static final int MAX_N = 100;

    private static int[] Ws, Vs;
    private static int[][] dp;
    private static int N, K;

    public static void main(String[] args) throws Exception {
        Ws = new int[MAX_N + 1];
        Vs = new int[MAX_N + 1];
        dp = new int[MAX_N + 1][MAX_K + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int current = 1; current <= N; current++) {
            st = new StringTokenizer(br.readLine());
            Ws[current] = Integer.parseInt(st.nextToken());
            Vs[current] = Integer.parseInt(st.nextToken());
        }

        for (int item = 1; item <= N; item++) {
            for (int weight = 1; weight <= K; weight++) {
                dp[item][weight] = dp[item - 1][weight];
                if (weight - Ws[item] >= 0) {
                    dp[item][weight] = Math.max(dp[item][weight], dp[item - 1][weight - Ws[item]] + Vs[item]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
