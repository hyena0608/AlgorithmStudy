package 인프런_자바_알고리즘_문제_기초.토마토;

import java.io.*;
import java.util.*;

/**
 * @author hyena
 */
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, answer = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] box, dis;
    static Queue<Point> redTomato = new LinkedList<>();

    public void bfs(int x, int y) {
        redTomato.offer(new Point(x, y));
        while (!redTomato.isEmpty()) {
            Point tmp = redTomato.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < m
                        && ny >= 0 && ny < n
                        && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    if (answer < dis[nx][ny]) answer = dis[nx][ny];
                    redTomato.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stNM.nextToken());
        m = Integer.parseInt(stNM.nextToken());

        box = new int[m][n];
        dis = new int[m][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                box[i][j] = tmp;
                if (tmp == 1) redTomato.offer(new Point(i, j));

            }
        }

        boolean isGreen = false;
        T.bfs(0, 0);
        if (answer == 0) {
            bw.write("0");
        } else {
            for (int[] boxRow : box) {
                for (int tomatoType : boxRow) {
                    if (tomatoType == 0) {
                        isGreen = true;
                        break;
                    }
                }
            }
            if (isGreen) bw.write("-1");
            else bw.write(answer + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
