package 코트.구현력.완전탐색.기준새로설정.훌륭한점프;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 100;

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        arr = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int limit = Math.max(arr[0], arr[N - 1]); limit <= MAX_N; limit++) {
            if (isPossible(limit)) {
                System.out.println(limit);
                break;
            }
        }
    }

    private static boolean isPossible(int limit) {
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] <= limit) {
                if (i - idx > K) return false;
                idx = i;
            }
        }
        return true;
    }
}
