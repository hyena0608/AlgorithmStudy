package 코트.완전탐색.물체단위.겹치지않는선분2;

import java.io.*;
import java.util.*;

public class Main {

    final static int GAP = 1000000;
    final static int MAX_N = 100;

    static int N;
    static int[] X1, X2;

    public static void main(String[] args) throws Exception {
        X1 = new int[MAX_N + 1];
        X2 = new int[MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            X1[i] = Integer.parseInt(st.nextToken()) + GAP;
            X2[i] = Integer.parseInt(st.nextToken()) + GAP;
        }

        int count = 0;
        for (int curr = 1; curr <= N; curr++) {
            boolean isCrossed = false;
            for (int next = 1; next <= N; next++) {
                if (curr == next) continue;
                if (X1[curr] <= X1[next] && X2[next] <= X2[curr]) isCrossed = true;
                if (X1[next] <= X1[curr] && X2[curr] <= X2[next]) isCrossed = true;
                if (isCrossed) break;
            }
            if (!isCrossed) count++;
        }

        System.out.println(count);
    }
}
