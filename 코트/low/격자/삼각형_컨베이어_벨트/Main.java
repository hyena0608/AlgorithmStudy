package 삼각형_컨베이어_벨트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int EDGES_COUNT = 3;

    private static int N;
    private static int T;
    private static int arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[EDGES_COUNT][N];

        for (int edge = 0; edge < EDGES_COUNT; edge++) {
            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < N; index++) {
                arr[edge][index] = Integer.parseInt(st.nextToken());
            }
        }

        for (int time = 1; time <= T; time++) {
            final int firstLayerLastIndexNumber = arr[0][N - 1];
            final int secondLayerLastIndexNumber = arr[1][N - 1];
            final int thirdLayerLastIndexNumber = arr[2][N - 1];

            for (int index = N - 1; index > 0; index--) {
                arr[0][index] = arr[0][index - 1];
            }
            arr[0][0] = thirdLayerLastIndexNumber;

            for (int index = N - 1; index > 0; index--) {
                arr[1][index] = arr[1][index - 1];
            }
            arr[1][0] = firstLayerLastIndexNumber;

            for (int index = N - 1; index > 0; index--) {
                arr[2][index] = arr[2][index - 1];
            }
            arr[2][0] = secondLayerLastIndexNumber;
        }

        StringBuilder sb = new StringBuilder();
        for (int edge = 0; edge < EDGES_COUNT; edge++) {
            for (int index = 0; index < N; index++) {
                sb.append(arr[edge][index]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
