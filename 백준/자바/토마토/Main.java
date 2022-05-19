package 백준.자바.토마토;

import java.io.*;
import java.util.*;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {


    static int[][] box, day;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int n;
    static int m;
    static int lastDay = 0;
    static List<Point> startPointList = new ArrayList<>();
    static Queue<Point> Q = new LinkedList<>();

    public static void bfs() {

        while (!Q.isEmpty()) {
            Point point = Q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n
                        && box[ny][nx] == 0) {
                    Q.add(new Point(ny, nx));
                    box[ny][nx] = 1;
                    day[ny][nx] = day[point.y][point.x] + 1;
                    if (lastDay < day[ny][nx]) lastDay = day[ny][nx];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stNM.nextToken());
        m = Integer.parseInt(stNM.nextToken());
        box = new int[m][n];
        day = new int[m][n];

        boolean isAlreadyExit = true;
        for (int y = 0; y < m; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 0) isAlreadyExit = false;
                if (value == 1) startPointList.add(new Point(y, x));
                box[y][x] = value;
            }
        }

        if (isAlreadyExit) {
            bw.write( 0 + "");
            bw.flush();
            bw.close();
            br.close();
            System.exit(0);
        }

        for (Point point : startPointList) {
            Q.add(point);
        }
        bfs();

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (box[y][x] == 0) {
                    bw.write(-1 + "");
                    bw.flush();
                    bw.close();
                    br.close();
                    System.exit(0);
                }
            }
        }

        bw.write(lastDay + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
