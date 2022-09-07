package 코트.완전탐색.물체단위.삼각형;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAN_N = 100;
    final static int gap = 10000;

    static int N;
    static int[] Y, X;

    public static void main(String[] args) throws Exception {
        Y = new int[MAN_N];
        X = new int[MAN_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken()) + gap;
            Y[i] = Integer.parseInt(st.nextToken()) + gap;
        }

        int maxWidth = Integer.MIN_VALUE;
        for (int p1 = 0; p1 < N - 2; p1++) {
            for (int p2 = p1 + 1; p2 < N - 1; p2++) {
                for (int p3 = p2 + 1; p3 < N; p3++) {
                    if ((isParallelToX(p1, p2) || isParallelToX(p1, p3) || isParallelToX(p2, p3)) &&
                            (isParallelToY(p1, p2) || isParallelToY(p1, p3) || isParallelToY(p2, p3))) {
                        int width =
                                Math.abs(Math.abs(X[p1] * Y[p2] + X[p2] * Y[p3] + X[p3] * Y[p1]) -
                                        Math.abs(X[p2] * Y[p1] + X[p3] * Y[p2] + X[p1] * Y[p3]));

                        maxWidth = Math.max(maxWidth, width);
                    }


                }
            }
        }

        System.out.print(maxWidth);
    }

    static boolean isParallelToX(int p1, int p2) {
        return Y[p1] == Y[p2] ? true : false;
    }

    static boolean isParallelToY(int p1, int p2) {
        return X[p1] == X[p2] ? true : false;
    }
}