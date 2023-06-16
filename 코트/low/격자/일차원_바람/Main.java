package 일차원_바람;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final String LEFT_SIDE = "L";
    private static final String RIGHT_SIDE = "R";
    private static final int FROM_NO_WHERE = 0;
    private static final int UP = -1;
    private static final int DOWN = 1;

    private static int N, M, Q;
    private static int arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int col = 0; col < N; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 0; row < M; row++) {
                arr[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        for (int windCount = 0; windCount < Q; windCount++) {
            st = new StringTokenizer(br.readLine());
            final int START_LAYER = Integer.parseInt(st.nextToken());
            final String START_SIDE = st.nextToken();

            moveWind(START_LAYER - 1, START_SIDE, FROM_NO_WHERE);
        }

        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < M; row++) {
                sb.append(arr[col][row]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void moveWind(final int currentLayer, final String currentSide, int fromWhere) {
        if (isLeftSide(currentSide)) {
            moveLayerLeftSide(currentLayer);
            if (isFromDownOrNoWhere(fromWhere) && isUpLayerMatchAnyBlock(currentLayer)) {
                moveWind(currentLayer + UP, RIGHT_SIDE, DOWN);
            }
            if (isFromUpOrNoWhere(fromWhere) && isDownLayerMatchAnyBlock(currentLayer)) {
                moveWind(currentLayer + DOWN, RIGHT_SIDE, UP);
            }
        } else if (isRightSide(currentSide)) {
            moveLayerRightSide(currentLayer);
            if (isFromDownOrNoWhere(fromWhere) && isUpLayerMatchAnyBlock(currentLayer)) {
                moveWind(currentLayer + UP, LEFT_SIDE, DOWN);
            }
            if (isFromUpOrNoWhere(fromWhere) && isDownLayerMatchAnyBlock(currentLayer)) {
                moveWind(currentLayer + DOWN, LEFT_SIDE, UP);
            }
        }
    }

    private static boolean isLeftSide(String currentSide) {
        return currentSide.equals(LEFT_SIDE);
    }

    private static void moveLayerLeftSide(final int currentLayer) {
        final int layerLastIndexNumber = arr[currentLayer][M - 1];
        for (int row = M - 1; row > 0; row--) {
            arr[currentLayer][row] = arr[currentLayer][row - 1];
        }
        arr[currentLayer][0] = layerLastIndexNumber;
    }

    private static boolean isFromDownOrNoWhere(int fromWhere) {
        return fromWhere == DOWN || fromWhere == FROM_NO_WHERE;
    }

    private static boolean isUpLayerMatchAnyBlock(final int currentLayer) {
        if (currentLayer == 0) {
            return false;
        }

        for (int row = 0; row < M; row++) {
            if (arr[currentLayer][row] == arr[currentLayer - 1][row]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isFromUpOrNoWhere(int fromWhere) {
        return fromWhere == UP || fromWhere == FROM_NO_WHERE;
    }

    private static boolean isDownLayerMatchAnyBlock(final int currentLayer) {
        if (currentLayer == N - 1) {
            return false;
        }

        for (int row = 0; row < M; row++) {
            if (arr[currentLayer][row] == arr[currentLayer + 1][row]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRightSide(String currentSide) {
        return currentSide.equals(RIGHT_SIDE);
    }

    private static void moveLayerRightSide(final int currentLayer) {
        final int layerFirstIndexNumber = arr[currentLayer][0];
        for (int row = 0; row < M - 1; row++) {
            arr[currentLayer][row] = arr[currentLayer][row + 1];
        }
        arr[currentLayer][M - 1] = layerFirstIndexNumber;
    }
}
