package 코트.시뮬.금채굴.case02;

import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 20;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];

    // 주어진 k에 대하여 마름모의 넓이를 반환합니다.
    public static int getArea(int k) {
        return k * k + (k + 1) * (k + 1);
    }

    // 주어진 좌표가 격자에 포함되는지 여부를 반환합니다.
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // 주어진 k에 대하여 채굴 가능한 금의 개수를 반환합니다.
    public static int getNumOfGold(int row, int col, int k) {
        int numOfGold = 0;
        int[] dx = new int[]{1, 1, -1, -1};
        int[] dy = new int[]{-1, 1, 1, -1}; // 방향에 따라 바뀌는 x와 y의 변화량을 정의합니다.

        numOfGold += grid[row][col]; // k=0 일 때 처리

        for (int currK = 1; currK <= k; currK++) {
            int currX = row - currK, currY = col; // 순회 시작점 설정

            for (int currDir = 0; currDir < 4; currDir++) {
                for (int step = 0; step < currK; step++) {
                    if (inRange(currX, currY)) {
                        numOfGold += grid[currX][currY];
                    }
                    currX = currX + dx[currDir];
                    currY = currY + dy[currDir];
                }
            }
        }

        return numOfGold;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxGold = 0;

        n = sc.nextInt();
        m = sc.nextInt();
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                grid[row][col] = sc.nextInt();


        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                for (int k = 0; k <= 2 * (n - 1); k++) {
                    int numOfGold = getNumOfGold(row, col, k);

                    if (numOfGold * m >= getArea(k))
                        maxGold = Math.max(maxGold, numOfGold);
                }
            }
        }

        System.out.print(maxGold);
    }
}