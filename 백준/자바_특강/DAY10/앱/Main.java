package 백준.자바_특강.DAY10.앱;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, totalCost;
    static int[] dp;
    static int[] memory;
    static int[] cost;


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("백준/자바_특강/DAY10/앱/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNM = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stNM.nextToken());
        M = Integer.parseInt(stNM.nextToken());

        memory = new int[N];
        cost = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            memory[j] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer stCost = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(stCost.nextToken());
            totalCost += cost[i];
        }

        // cost에 대한 메모리 값 저장
        dp = new int[totalCost + 1];

        for (int i = 0; i < N; i++) {
            // 0 ~ N - 1 번 반복
            for (int j = totalCost; j >= cost[i]; j--) {
                // j = 낼 수 있 최대 비용
                // i번째 메모리 사용 -> (낼 수 있는 최대 비용 -= i번째 비용)때의 최대 메모리 + 지금 i 메모리
                // i번째 메모리 안사용 -> 기존
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }

    }

}
