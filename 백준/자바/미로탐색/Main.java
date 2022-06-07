package 백준.자바.미로탐색;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);

        String[] nmStr = sc.nextLine().split(" ");
        int n = Integer.parseInt(nmStr[0]);
        int m = Integer.parseInt(nmStr[1]);

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];

        for (int y = 0; y < n; y++) {
            String[] lines = sc.nextLine().split("");
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(lines[x]);
            }
        }

        T.bfs(n, m, map, visited);
    }

    private void bfs(int n, int m, int[][] map, int[][] visited) throws IOException {
        Queue<Point> pointQ = new LinkedList<>();

        pointQ.offer(new Point(0, 0));
        visited[0][0] = 1;

        while (!pointQ.isEmpty()) {
            Point polledPoint = pointQ.poll();

            for (int idx = 0; idx < 4; idx++) {
                int ny = polledPoint.y + dy[idx];
                int nx = polledPoint.x + dx[idx];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && visited[ny][nx] == 0 && map[ny][nx] == 1) {
                    pointQ.offer(new Point(ny, nx));
                    visited[ny][nx] = visited[polledPoint.y][polledPoint.x] + 1;
                    map[ny][nx] = 0;
                }

                if (n - 1 == ny && m - 1 == nx) {
                    bw.write(visited[ny][nx] + "");
                    bw.flush();
                    bw.close();
                    System.exit(0);
                }
            }
        }
    }
}
