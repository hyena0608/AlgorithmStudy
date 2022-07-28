package 백준.자바_특강.DAY9.정수삼각형;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY9/정수삼각형/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = arr[i][j] + dp[i - 1][j];
                else dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int answer = 0;
        for (int i : dp[N - 1]) {
            answer = Math.max(i, answer);
        }
        System.out.println(answer);
    }
}
