package 백준.자바.미로만들기_2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    final static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    static int N;
    static int[][] rooms, distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        rooms = new int[N][N];
        distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                rooms[i][j] = chars[j] - '0';
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> Q = new LinkedList<Point>();
        Q.add(new Point(0, 0));
        distance[0][0] = 0;

        while (!Q.isEmpty()) {
            Point poll = Q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;

                if (distance[ny][nx] > distance[poll.y][poll.x]) {
                    if (rooms[ny][nx] == 1) {
                        distance[ny][nx] = distance[poll.y][poll.x];
                    } else if (rooms[ny][nx] == 0) {
                        distance[ny][nx] = distance[poll.y][poll.x] + 1;
                    }
                    Q.add(new Point(ny, nx));
                }
            }
        }

        System.out.println(distance[N - 1][N - 1]);
    }

}

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}