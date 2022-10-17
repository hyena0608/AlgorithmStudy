package 코트.구현력.완전탐색.기준새로설정.언덕깎기;

import java.io.*;

public class Main {

    private static final int MAX_GAP = 17;
    private static final int MAX_N = 1000;
    private static final int MAX_H = 100;
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // baseHeight ~ baseHeight + MAX_GAP 구간이라고 가정하고 진행한다.
        int answer = Integer.MAX_VALUE;
        for (int baseHeight = 0; baseHeight <= MAX_H; baseHeight++) {
            int cost = 0;
            for (int idx = 0; idx < N; idx++) {
                if (arr[idx] < baseHeight) {
                    cost += Math.pow((arr[idx] - baseHeight), 2);
                }
                if (arr[idx] > baseHeight + MAX_GAP) {
                    cost += Math.pow((arr[idx] - MAX_GAP - baseHeight), 2);
                }
            }

            answer = Math.min(answer, cost);
        }

        System.out.print(answer);
    }

}
