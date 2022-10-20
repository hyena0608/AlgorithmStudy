package 코트.구현력.완전탐색.기준새로설정.최대H점수2;

import java.io.*;
import java.util.*;

public class Main {

    static final int MIN_N = 1;
    static final int MAX_N = 100;
    static int[] arr;
    static int N, L;

    public static void main(String[] args) throws IOException {
        arr = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int h = MIN_N; h <= N; h++) {
            int plusOneCount = 0;
            int overThanHCount = 0;
            for (int idx = 0; idx < N; idx++) {
                if (arr[idx] >= h) {
                    overThanHCount++;
                }
                if (arr[idx] == h - 1) {
                    if (plusOneCount < L) {
                        overThanHCount++;
                        plusOneCount++;
                    }
                }
            }

            if (overThanHCount >= h) {
                answer = h;
            }
        }

        System.out.println(answer);
    }
}
