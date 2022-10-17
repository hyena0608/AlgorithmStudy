package 코트.구현력.완전탐색.기준새로설정.구간잘나누기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_ARR_SIZE = 100;

    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_ARR_SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for (int findMax = 1; findMax <= 10000; findMax++) {

            boolean isPossible = true;
            int subCount = 1;
            int currValue = 0;
            for (int curr = 0; curr < N; curr++) {
                if (arr[curr] > findMax) {
                    isPossible = false;
                    break;
                }

                if (currValue + arr[curr] > findMax) {
                    currValue = 0;
                    subCount++;
                }

                currValue += arr[curr];
            }

            if (isPossible && subCount <= M) {
                answer = Math.min(answer, findMax);
            }
        }

        System.out.print(answer);
    }
}
