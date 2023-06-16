package 기울어진_직사각형의_회전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_N = 100;
    private static final int OPPOSITE_CLOCK_DIRECTION_TYPE = 0;
    private static final int CLOCK_DIRECTION_TYPE = 1;
    private static final int[] OPPOSITE_CLOCK_ROWS = new int[]{-1, -1, 1, 1};
    private static final int[] OPPOSITE_CLOCK_COLS = new int[]{1, -1, -1, 1};
    private static final int[] CLOCK_ROWS = new int[]{-1, -1, 1, 1};
    private static final int[] CLOCK_COLS = new int[]{-1, 1, 1, -1};
    private static final int FIRST_DIRECTION = 0;
    private static final int SECOND_DIRECTION = 1;
    private static final int THIRD_DIRECTION = 2;
    private static final int FOURTH_DIRECTION = 3;

    private static int[][] arr;
    private static int N;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1][MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        final int startRow = Integer.parseInt(st.nextToken());
        final int startCol = Integer.parseInt(st.nextToken());
        final int firstMoveCount = Integer.parseInt(st.nextToken());
        final int secondMoveCount = Integer.parseInt(st.nextToken());
        final int thirdMoveCount = Integer.parseInt(st.nextToken());
        final int fourthMoveCount = Integer.parseInt(st.nextToken());
        final int direction = Integer.parseInt(st.nextToken());

        int[] directionRows;
        int[] directionCols;
        if (direction == OPPOSITE_CLOCK_DIRECTION_TYPE) {
            directionRows = OPPOSITE_CLOCK_ROWS;
            directionCols = OPPOSITE_CLOCK_COLS;
        } else if (direction == CLOCK_DIRECTION_TYPE) {
            directionRows = CLOCK_ROWS;
            directionCols = CLOCK_COLS;
        } else {
            throw new IllegalStateException("존재하지 않는 방향입니다.");
        }

        printResult();
        final int firstDirectionLastRowIndex = startRow + directionRows[FIRST_DIRECTION] * firstMoveCount;
        final int firstDirectionLastColIndex = startCol + directionCols[FIRST_DIRECTION] * firstMoveCount;
        final int firstDirectionLastNumber = arr[firstDirectionLastRowIndex][firstDirectionLastColIndex];
        for (int moveCount = 0; moveCount < firstMoveCount; moveCount++) {
            arr[firstDirectionLastRowIndex][firstDirectionLastColIndex]
                    = arr[firstDirectionLastRowIndex - directionRows[FIRST_DIRECTION]][firstDirectionLastColIndex - directionCols[FIRST_DIRECTION]];
        }
        printResult();

        final int secondDirectionLastRowIndex = firstDirectionLastRowIndex + directionRows[SECOND_DIRECTION] * secondMoveCount;
        final int secondDirectionLastColIndex = firstDirectionLastColIndex + directionCols[SECOND_DIRECTION] * secondMoveCount;
        final int secondDirectionLastNumber = arr[secondDirectionLastRowIndex][secondDirectionLastColIndex];
        for (int moveCount = 0; moveCount < secondMoveCount - 1; moveCount++) {
            arr[secondDirectionLastRowIndex][secondDirectionLastColIndex]
                    = arr[secondDirectionLastRowIndex - directionRows[SECOND_DIRECTION]][secondDirectionLastColIndex - directionCols[SECOND_DIRECTION]];
        }
        arr[firstDirectionLastRowIndex + directionRows[SECOND_DIRECTION]][firstDirectionLastColIndex + directionCols[SECOND_DIRECTION]]
                = firstDirectionLastNumber;
        printResult();

        final int thirdDirectionLastRowIndex = secondDirectionLastRowIndex + directionRows[THIRD_DIRECTION] * thirdMoveCount;
        final int thirdDirectionLastColIndex = secondDirectionLastColIndex + directionCols[THIRD_DIRECTION] * thirdMoveCount;
        final int thirdDirectionLastNumber = arr[thirdDirectionLastRowIndex][thirdDirectionLastColIndex];
        for (int moveCount = 0; moveCount < thirdMoveCount - 1; moveCount++) {
            arr[thirdDirectionLastRowIndex][thirdDirectionLastColIndex]
                    = arr[thirdDirectionLastRowIndex - directionRows[THIRD_DIRECTION]][thirdDirectionLastColIndex - directionCols[THIRD_DIRECTION]];
        }
        arr[secondDirectionLastRowIndex + directionRows[THIRD_DIRECTION]][secondDirectionLastColIndex + directionCols[THIRD_DIRECTION]]
                = secondDirectionLastNumber;
        printResult();

        final int fourthDirectionLastRowIndex = thirdDirectionLastRowIndex + directionRows[FOURTH_DIRECTION] * fourthMoveCount;
        final int fourthDirectionLastColIndex = thirdDirectionLastColIndex + directionCols[FOURTH_DIRECTION] * fourthMoveCount;
        for (int moveCount = 0; moveCount < fourthMoveCount - 1; moveCount++) {
            arr[fourthDirectionLastRowIndex][fourthDirectionLastColIndex]
                    = arr[fourthDirectionLastRowIndex - directionRows[FOURTH_DIRECTION]][fourthDirectionLastColIndex - directionCols[FOURTH_DIRECTION]];
        }
        arr[thirdDirectionLastRowIndex + directionRows[FOURTH_DIRECTION]][thirdDirectionLastColIndex + directionCols[FOURTH_DIRECTION]]
                = thirdDirectionLastNumber;


        printResult();
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                sb.append(arr[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}

/*
1 2 2 2 2
1 3 4 4 4
1 2 3 3 3
1 2 3 3 3
1 2 3 3 3


 */
