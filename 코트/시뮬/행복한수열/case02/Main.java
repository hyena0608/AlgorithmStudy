package 코트.시뮬.행복한수열.case02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] arr;
    private static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        line = new int[n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int happyCount = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                line[x] = arr[y][x];
            }
            if (isHappySequence()) {
                happyCount++;
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                line[y] = arr[y][x];
            }
            if (isHappySequence()) {
                happyCount++;
            }
        }

        System.out.println(happyCount);
    }

    private static boolean isHappySequence() {
        int consecutiveCount = 1, maxCount = 1;
        for (int current = 1; current < n; current++) {
            if (line[current - 1] == line[current]) {
                consecutiveCount++;
            }
            if (line[current - 1] != line[current]) {
                consecutiveCount = 1;
            }
            maxCount = Math.max(maxCount, consecutiveCount);
        }
        return maxCount >= m;
    }
}
