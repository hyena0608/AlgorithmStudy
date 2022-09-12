package 코트.완전탐색.값기준.빙산의일각;

import java.io.*;

public class Main {

    final static int MAX_ICE_HEIGHT = 1000;
    final static int MAX_ICE_COUNTS = 100;

    static int N;
    static int[] ice;

    public static void main(String[] args) throws IOException {
        ice = new int[MAX_ICE_COUNTS + 1];
        ice[MAX_ICE_COUNTS] = Integer.MIN_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            ice[i] = Integer.parseInt(br.readLine());
        }

        int maxCount = 0;
        for (int height = 1; height <= MAX_ICE_HEIGHT; height++) {
            int count = 0;
            if (ice[0] > height) count++;
            for (int iceIdx = 1; iceIdx < N; iceIdx++) {
                if (ice[iceIdx] > height && ice[iceIdx - 1] <=  height) count++;
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
