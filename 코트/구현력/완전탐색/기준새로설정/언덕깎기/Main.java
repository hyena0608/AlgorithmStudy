package 코트.구현력.완전탐색.기준새로설정.언덕깎기;

import java.io.*;

public class Main {

    public static final int MAX_H = 100;
    public static final int MAX_N = 1000;
    public static final int K = 17;

    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= MAX_H; i++) {
            int cost = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] < i)
                    cost += (arr[j] - i) * (arr[j] - i);
                if (arr[j] > i + K)
                    cost += (arr[j] - i - K) * (arr[j] - i - K);
            }
            minCost = Math.min(minCost, cost);
        }

        System.out.print(minCost);
    }
}
