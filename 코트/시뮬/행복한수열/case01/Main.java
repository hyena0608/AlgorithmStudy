package 코트.시뮬.행복한수열.case01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int happyCount = 0;
        for (int y = 0; y < n; y++) {
            int count = 1;
            for (int x = 0; x < n - 1; x++) {
                if (arr[y][x] == arr[y][x + 1]) {
                    count++;
                }
                if (count >= m) {
                    happyCount++;
                    break;
                }
                if (arr[y][x] != arr[y][x + 1]) {
                    count = 1;
                }
            }
        }

        for (int x = 0; x < n; x++) {
            int count = 1;
            for (int y = 0; y < n - 1; y++) {
                if (arr[y][x] == arr[y + 1][x]) {
                    count++;
                }
                if (count >= m) {
                    happyCount++;
                    break;
                }
                if (arr[y][x] != arr[y + 1][x]) {
                    count = 1;
                }
            }
        }

        if (n == 1 && m == 1) {
            happyCount = 2;
        }

        System.out.println(happyCount);
    }
}
