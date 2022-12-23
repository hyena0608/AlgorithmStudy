package 코트.시뮬.금채굴.case01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int ARR_MAX_SIZE = 40;

    private static int n, m;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[ARR_MAX_SIZE][ARR_MAX_SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int optimizedMaxGoldCount = 0;
        for (int k = 0; k <= 20; k++) {
            int maxGoldCount = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    maxGoldCount = Math.max(maxGoldCount, mineGold(y, x, k));
                }
            }
            if (calculateTotalCost(k) <= m * maxGoldCount) {
                optimizedMaxGoldCount = Math.max(maxGoldCount, optimizedMaxGoldCount);
            }
        }

        System.out.println(optimizedMaxGoldCount);
    }

    private static int calculateTotalCost(int k) {
        return k * k + (k + 1) * (k + 1);
    }

    private static int mineGold(int currY, int currX, int availableDistance) {
        int count = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (arr[y][x] != 1) {
                    continue;
                }
                if (Math.abs(currY - y) + Math.abs(currX - x) <= availableDistance) {
                    count++;
                }
            }
        }
        return count;
    }
}
