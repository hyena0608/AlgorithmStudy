package 인프런_자바_알고리즘_문제_기초.미로의최단거리통로;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
class Point {
    int x;
    int y;

    Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {1, -1 ,0 ,0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] miro, dis;

    public void bfs(int col, int row) {

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(col, row));
        miro[col][row] = 1;

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7) {
                    if (miro[ny][nx] == 0) {
                        miro[ny][nx] = 1;
                        Q.offer(new Point(ny, nx));
                        dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        miro = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.bfs(1, 1);
        if (dis[7][7] == 0) {
            bw.write("-1");
        }
        else {
            bw.write(dis[7][7] + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
