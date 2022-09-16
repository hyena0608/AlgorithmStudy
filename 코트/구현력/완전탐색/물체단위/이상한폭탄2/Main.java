package 코트.구현력.완전탐색.물체단위.이상한폭탄2;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 100;

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxBomb = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (Math.abs(i - j) > K) continue;

                if (arr[i] == arr[j])
                    maxBomb = Math.max(maxBomb, arr[i]);
            }
        }

        System.out.print(maxBomb);
    }
}
