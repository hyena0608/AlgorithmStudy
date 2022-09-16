package 코트.구현력.완전탐색.물체단위.가장가까운두점사이;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 100;

    static int N;
    static int[] X;
    static int[] Y;

    public static void main(String[] args) throws Exception {
        X = new int[MAX_N];
        Y = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int distance = Math.abs((X[i] - X[j]) * (X[i] - X[j]));
                distance += Math.abs((Y[i] - Y[j]) * (Y[i] - Y[j]));
                minDistance = Math.min(minDistance, distance);
            }
        }

        System.out.print(minDistance);
    }
}