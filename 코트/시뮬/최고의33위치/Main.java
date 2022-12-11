package 코트.시뮬.최고의33위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int LINE_SIZE = 3;
    private static final int MAX_N = 20;

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[MAX_N][MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int findMaxCount = 0;
        for (int y = 0; y <= n - LINE_SIZE; y++) {
            for (int x = 0; x <= n - LINE_SIZE; x++) {
                int count = arr[y][x] + arr[y][x + 1] + arr[y][x + 2] +
                        arr[y + 1][x] + arr[y + 1][x + 1] + arr[y + 1][x + 2] +
                        arr[y + 2][x] + arr[y + 2][x + 1] + arr[y + 2][x + 2];
                findMaxCount = Math.max(findMaxCount, count);
            }
        }

        System.out.println(findMaxCount);
    }
}
