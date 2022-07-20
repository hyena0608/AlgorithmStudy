package 백준.자바_특강.DAY2.피보나치수2;

import java.io.*;

public class Main {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2;i<=N;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
        br.close();
    }
}
