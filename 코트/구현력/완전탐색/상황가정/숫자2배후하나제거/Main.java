package 코트.구현력.완전탐색.상황가정.숫자2배후하나제거;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 100;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minGapSum = Integer.MAX_VALUE;
        for (int doubleIdx = 0; doubleIdx < N; doubleIdx++) {
            arr[doubleIdx] *= 2;
            for (int exceptIdx = 0; exceptIdx < N; exceptIdx++) {
                int gapSum = 0;
                int beforeSelectedIdx = -1;
                for (int selectFirstIdx = 0; selectFirstIdx < N; selectFirstIdx++) {
                    if (exceptIdx == selectFirstIdx) continue;
                    if (beforeSelectedIdx != -1) {
                        gapSum += Math.abs(arr[beforeSelectedIdx] - arr[selectFirstIdx]);
                    }
                    beforeSelectedIdx = selectFirstIdx;
                }
                minGapSum = Math.min(minGapSum, gapSum);
            }
            arr[doubleIdx] /= 2;
        }

        System.out.println(minGapSum);
    }
}
