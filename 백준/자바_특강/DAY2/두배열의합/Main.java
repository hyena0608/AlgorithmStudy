package 백준.자바_특강.DAY2.두배열의합;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N, M;
    static long answer;
    static long[] A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        A = new long[N];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(stA.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new long[M];
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Long.parseLong(stB.nextToken());
        }

        // A를 부분 배열로 만든다.
        long[] subA = new long[(N * (N + 1)) / 2];
        int aIndex = 0;
        for (int i = 0; i < N; i++) {
            int value = 0;
            for (int j = i; j < N; j++) {
                value += A[j];
                subA[aIndex++] = value;
            }
        }

        // B를 부분 배열로 만든다.
        long[] subB = new long[(M * (M + 1)) / 2];
        int bIndex = 0;
        for (int i = 0; i < M; i++) {
            int value = 0;
            for (int j = i; j < M; j++) {
                value += B[j];
                subB[bIndex++] = value;
            }
        }

        // 부분 배열을 정렬한다.
        Arrays.sort(subA);
        Arrays.sort(subB);
        long[] tempB = new long[subB.length];
        for (int i = subB.length - 1; i >= 0; i--) {
            tempB[i] = subB[subB.length - i - 1];
        }
        subB = tempB;


        // 투 포인터
        int pA = 0;
        int pB = 0;
        while (true) {
            long value = subA[pA] + subB[pB];

            if (value == T) {

                // 동률 처리
                long sameA = 1;
                while (true) {
                    if (pA + 1 >= subA.length) {
                        break;
                    }
                    if (subA[pA + 1] == subA[pA]) {
                        pA++;
                        sameA++;
                    } else {
                        break;
                    }
                }
                long sameB = 1;
                while (true) {
                    if (pB + 1 >= subB.length) {
                        break;
                    }
                    if (subB[pB + 1] == subB[pB]) {
                        pB++;
                        sameB++;
                    } else {
                        break;
                    }
                }

                answer += sameA * sameB;
                pB++;
            } else if (value > T) {
                pB++;
            } else if (value < T) {
                pA++;
            }

            if (pB >= subB.length || pA >= subA.length) {
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
