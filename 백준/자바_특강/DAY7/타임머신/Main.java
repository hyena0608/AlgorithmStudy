package 백준.자바_특강.DAY7.타임머신;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY7/타임머신/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNM = new StringTokenizer(br.readLine());

        long MAX = Long.MAX_VALUE;
        int N = Integer.parseInt(stNM.nextToken());
        int M = Integer.parseInt(stNM.nextToken());
        long[] value = new long[N + 1];
        int[][] edgeList = new int[M][3];
        Arrays.fill(value, MAX);
        value[1] = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[i][0] = a;
            edgeList[i][1] = b;
            edgeList[i][2] = c;
        }

        int a, b, c;
        boolean checkINF = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                a = edgeList[j][0];
                b = edgeList[j][1];
                c = edgeList[j][2];
                if (value[a] == MAX) continue;
                if (value[b] > value[a] + c) {
                    value[b] = value[a] + c;
                    if (i == N) {
                        checkINF = true;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        if (checkINF) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                sb.append((value[i] == MAX ? -1 : value[i]) + "\n");
            }
        }
        System.out.print(sb);
    }
}