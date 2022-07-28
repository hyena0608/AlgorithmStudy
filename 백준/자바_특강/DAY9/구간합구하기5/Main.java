package 백준.자바_특강.DAY9.구간합구하기5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, arr[][], dp[][];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY9/구간합구하기5/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st2.nextToken());
                arr[i][j] = value;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st3.nextToken());
            int startX = Integer.parseInt(st3.nextToken());
            int endY = Integer.parseInt(st3.nextToken());
            int endX = Integer.parseInt(st3.nextToken());

            int sum = dp[endY][endX] - dp[endY][startX - 1] - dp[startY - 1][endX] + dp[startY - 1][startX - 1];

            System.out.println(sum);
        }
    }
}
