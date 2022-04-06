package 인프런_자바_알고리즘_문제_기초.섬나라아일랜드BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, answer = 0;
    static int[] dx = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[][] islandMap, dis;

    public void bfs(int x, int y) {
        Queue<Point> Q = new LinkedList<>();

        Q.offer(new Point(x, y));
        while (!Q.isEmpty()) {
            Point island = Q.poll();
            islandMap[island.x][island.y] = 0;
            dis[island.x][island.y] = answer + 1;

            for (int i = 0; i < 8; i++) {
                int nx = island.x + dx[i];
                int ny = island.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && islandMap[nx][ny] == 1) {
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[island.x][island.y];
                }
            }
        }
    }

    public void solution() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (islandMap[x][y] == 1) {
                    bfs(x, y);
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
        dis = new int[n][n];

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
