package 백준.자바.정수삼각형;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] triangle;
    static int[][] sumArr;
    static int n;

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        sumArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = n - 1; y >= 0; y--) {
            for (int x = 0; x < y + 1; x++){
                sumArr[y][x] = T.dfs(y, x);
            }
        }

        bw.write(sumArr[0][0] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private int dfs(int depth, int beforeIdx) {
        if (depth == n - 1) {
            return triangle[depth][beforeIdx];
        }

        if (sumArr[depth][beforeIdx] == 0) {
            sumArr[depth][beforeIdx] = Math.max(
                    sumArr[depth + 1][beforeIdx],
                    sumArr[depth + 1][beforeIdx + 1]
            ) + triangle[depth][beforeIdx];
        }

        return sumArr[depth][beforeIdx];
    }

}
