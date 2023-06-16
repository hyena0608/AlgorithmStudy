package 이차원_바람;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_N = 100;
    private static final int MAX_M = 100;
    private static final int RIGHT_COL = 1;
    private static final int LEFT_COL = -1;
    private static final int UP_ROW = -1;
    private static final int DOWN_ROW = 1;
    private static final int START_COL = 1;
    private static final int START_ROW = 1;

    private static int[][] arr;
    private static int[][] tempArr;
    private static int END_ROW, END_COL, Q;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1][MAX_M + 1];
        tempArr = new int[MAX_N + 1][MAX_M + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        END_ROW = Integer.parseInt(st.nextToken());
        END_COL = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (int row = START_ROW; row <= END_ROW; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = START_COL; col <= END_COL; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int windCount = 0; windCount < Q; windCount++) {
            st = new StringTokenizer(br.readLine());
            final int startRow = Integer.parseInt(st.nextToken());
            final int startCol = Integer.parseInt(st.nextToken());
            final int endRow = Integer.parseInt(st.nextToken());
            final int endCol = Integer.parseInt(st.nextToken());

            moveBlocks(startRow, startCol, endRow, endCol);
            calculateBlocksAverage(startRow, startCol, endRow, endCol);
            reflectCalculatedAverageBlocks(startRow, startCol, endRow, endCol);
            cleanTempArr(startRow, endRow);
        }

        printResult();
    }

    private static void moveBlocks(int startRow, int startCol, int endRow, int endCol) {
        final int firstLayerLastNumber = arr[startRow][endCol];
        final int lastLayerLastNumber = arr[endRow][endCol];
        final int lastLayerFirstNumber = arr[endRow][startCol];

        for (int currentCol = endCol; currentCol > startCol; currentCol--) {
            arr[startRow][currentCol] = arr[startRow][currentCol + LEFT_COL];
        }

        for (int currentRow = endRow; currentRow > startRow + DOWN_ROW; currentRow--) {
            arr[currentRow][endCol] = arr[currentRow + UP_ROW][endCol];
        }
        arr[startRow + DOWN_ROW][endCol] = firstLayerLastNumber;

        for (int currentCol = startCol; currentCol < endCol + LEFT_COL; currentCol++) {
            arr[endRow][currentCol] = arr[endRow][currentCol + RIGHT_COL];
        }
        arr[endRow][endCol + LEFT_COL] = lastLayerLastNumber;

        for (int currentRow = startRow; currentRow < endRow + UP_ROW; currentRow++) {
            arr[currentRow][startCol] = arr[currentRow + DOWN_ROW][startCol];
        }
        arr[endRow + UP_ROW][startCol] = lastLayerFirstNumber;
    }

    private static void calculateBlocksAverage(int startRow, int startCol, int endRow, int endCol) {
        for (int currentRow = startRow; currentRow <= endRow; currentRow++) {
            for (int currentCol = startCol; currentCol <= endCol; currentCol++) {

                int count = 1;
                int sum = arr[currentRow][currentCol];

                if (isUpBlockExists(currentRow)) {
                    count++;
                    sum += arr[currentRow + UP_ROW][currentCol];
                }
                if (isDownBlockExists(currentRow)) {
                    count++;
                    sum += arr[currentRow + DOWN_ROW][currentCol];
                }
                if (isLeftBlockExists(currentCol)) {
                    count++;
                    sum += arr[currentRow][currentCol + LEFT_COL];
                }
                if (isRightBlockExists(currentCol)) {
                    count++;
                    sum += arr[currentRow][currentCol + RIGHT_COL];
                }

                tempArr[currentRow][currentCol] = Math.floorDiv(sum, count);
            }
        }
    }

    private static void reflectCalculatedAverageBlocks(int startRow, int startCol, int endRow, int endCol) {
        for (int currentRow = startRow; currentRow <= endRow; currentRow++) {
            for (int currentCol = startCol; currentCol <= endCol; currentCol++) {
                arr[currentRow][currentCol] = tempArr[currentRow][currentCol];
            }
        }
    }

    private static void cleanTempArr(int startRow, int endRow) {
        tempArr = new int[MAX_N + 1][MAX_M + 1];
    }

    private static boolean isUpBlockExists(int currentRow) {
        return currentRow != START_ROW;
    }

    private static boolean isDownBlockExists(int currentRow) {
        return currentRow != END_ROW;
    }

    private static boolean isLeftBlockExists(int currentCol) {
        return currentCol != START_COL;
    }

    private static boolean isRightBlockExists(int currentCol) {
        return currentCol != END_COL;
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int currentRow = START_ROW; currentRow <= END_ROW; currentRow++) {
            for (int currentCol = START_COL; currentCol <= END_COL; currentCol++) {
                sb.append(arr[currentRow][currentCol]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
