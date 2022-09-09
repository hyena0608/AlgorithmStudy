package 코트.완전탐색.물체단위.개발자의순위;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_K = 10;
    final static int MAX_N = 20;

    static int K, N;
    static boolean[] hasChanged;
    static int[][] matchArr;

    public static void main(String[] args) throws Exception {
        matchArr = new int[MAX_K + 1][MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hasChanged = new boolean[MAX_N + 1];
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matchArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int devOne = 1; devOne <= N; devOne++) {
            for (int devTwo = 1; devTwo <= N; devTwo++) {
                if (devOne == devTwo) continue;

                boolean isAnswer = true;

                for (int round = 0; round < K; round++) {
                    int devOneIdx = 0;
                    int devTwoIdx = 0;

                    for (int tempDev = 0; tempDev < N; tempDev++) {
                        if (matchArr[round][tempDev] == devOne) devOneIdx = tempDev;
                        if (matchArr[round][tempDev] == devTwo) devTwoIdx = tempDev;
                    }

                    if (devOneIdx > devTwoIdx) isAnswer = false;
                    if (!isAnswer) break;
                }

                if (isAnswer) count++;
            }
        }

        System.out.print(count);
    }
}
