package 코트.구현력.완전탐색.기준새로설정.가장작은x;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 10;
    final static int NUM_MIN = 1;
    final static int NUM_MAX = 10000;

    static int N;
    static int[][] range;

    public static void main(String[] args) throws Exception {
        range = new int[MAX_N][2];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            range[i][0] = Integer.parseInt(st.nextToken());
            range[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = NUM_MAX;
        for (int x = NUM_MIN; x <= NUM_MAX; x++) {
            boolean isOK = true;

            for (int idx = 0; idx < N; idx++) {
                int currX = x * (int) Math.pow(2, idx + 1);
                if (range[idx][0] > currX || currX > range[idx][1]) {
                    isOK = false;
                    break;
                }
            }

            if (isOK) {
                answer = x;
                break;
            }
        }

        System.out.println(answer);
    }
}
