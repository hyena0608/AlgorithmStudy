package 코트.시뮬.기울어진_직사각형.case01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_N = 20;
    private static final int[] DY = {-1, -1, 1, 1};
    private static final int[] DX = {1, -1, -1, 1};

    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[MAX_N][MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;
        for (int startY = 0; startY < n; startY++) {
            for (int startX = 0; startX < n; startX++) {
                for (int width = 1; width < n; width++) {
                    for (int height = 1; height < n; height++) {
                        maxSum = Math.max(maxSum, getMaxSum(startY, startX, width, height));
                    }
                }
            }
        }

        System.out.println(maxSum);
    }

    private static int getMaxSum(int y, int x, int width, int height) {
        int currSum = 0;

        for (int direction = 0; direction < 4; direction++) {
            if (direction == 0 || direction == 2) {
                for (int count = 0; count < width; count++) {
                    if (!isRangeOk(y + DY[direction], x + DX[direction])) {
                        return 0;
                    }
                    y += DY[direction];
                    x += DX[direction];
                    currSum += arr[y][x];
                }
            }
            if (direction == 1 || direction == 3) {
                for (int count = 0; count < height; count++) {
                    if (!isRangeOk(y + DY[direction], x + DX[direction])) {
                        return 0;
                    }
                    y += DY[direction];
                    x += DX[direction];
                    currSum += arr[y][x];
                }
            }
        }
        return currSum;
    }

    private static boolean isRangeOk(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
