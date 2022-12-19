package 코트.시뮬.트로미노.case01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_ARR_SIZE = 200;
    private static int n, m;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[MAX_ARR_SIZE][MAX_ARR_SIZE];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int blockOneMaxValue = 0;
        int blockTwoMaxValue = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (y + 1 < n && x + 1 < m) {
                    // ㄱ
                    blockOneMaxValue = Math.max(blockOneMaxValue, arr[y][x] + arr[y][x + 1] + arr[y + 1][x + 1]);
                }
                if (y + 1 < n && x - 1 >= 0) {
                    // !ㄴ
                    blockOneMaxValue = Math.max(blockOneMaxValue, arr[y][x] + arr[y + 1][x] + arr[y + 1][x - 1]);
                }
                if (y - 1 >= 0 && x - 1 >= 0) {
                    // ㄴ
                    blockOneMaxValue = Math.max(blockOneMaxValue, arr[y][x] + arr[y][x - 1] + arr[y - 1][x - 1]);
                }
                if (y + 1 < n && x + 1 < m) {
                    // !ㄱ
                    blockOneMaxValue = Math.max(blockOneMaxValue, arr[y][x] + arr[y][x + 1] + arr[y + 1][x]);
                }

                if (x + 2 < m) {
                    blockTwoMaxValue = Math.max((blockTwoMaxValue), arr[y][x] + arr[y][x + 1] + arr[y][x + 2]);
                }
                if (y + 2 < n) {
                    blockTwoMaxValue = Math.max((blockTwoMaxValue), arr[y][x] + arr[y + 1][x] + arr[y + 2][x]);
                }
            }
        }

        int answer = Math.max(blockOneMaxValue, blockTwoMaxValue);
        System.out.println(answer);
    }
}
