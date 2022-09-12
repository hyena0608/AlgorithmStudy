package 코트.완전탐색.상황가정.야바위;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_GAME = 100;

    static int N;
    static int[] A, B, C;

    public static void main(String[] args) throws IOException {
        A = new int[MAX_GAME];
        B = new int[MAX_GAME];
        C = new int[MAX_GAME];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        int maxPoint = 0;
        for (int cup = 1; cup <= 3; cup++) {
            int[] cups = {0, 0, 0, 0};
            cups[cup] = 1;

            int point = 0;
            for (int curr = 0; curr < N; curr++) {
                int temp = cups[A[curr]];
                cups[A[curr]] = cups[B[curr]];
                cups[B[curr]] = temp;
                if (cups[C[curr]] == 1) {
                    point++;
                }
            }

            maxPoint = Math.max(maxPoint, point);
        }

        System.out.println(maxPoint);
    }
}
