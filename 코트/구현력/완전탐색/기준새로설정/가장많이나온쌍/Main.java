package 코트.구현력.완전탐색.기준새로설정.가장많이나온쌍;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 10;

    static int N, M;
    static int[][] appeared;

    public static void main(String[] args) throws Exception {
        appeared = new int[MAX_N + 1][MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            appeared[x][y]++;
            appeared[y][x]++;
        }

        int max = 0;
        for (int idx = 1; idx <= N; idx++) {
            max = Math.max(max, Arrays.stream(appeared[idx]).max().getAsInt());
        }
        System.out.println(max);
    }
}
