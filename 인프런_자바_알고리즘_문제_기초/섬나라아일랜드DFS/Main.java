package 인프런_자바_알고리즘_문제_기초.섬나라아일랜드DFS;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
public class Main {
    static int n, answer;
    static int[] dx = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[][] islandMap;

    public void dfs(int x, int y) {
        islandMap[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && islandMap[nx][ny] == 1) dfs(nx, ny);
        }
    }

    public void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (islandMap[i][j] == 1) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        islandMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                islandMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.solution();
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
