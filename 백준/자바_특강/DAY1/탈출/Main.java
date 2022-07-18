package 백준.자바_특강.DAY1.탈출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2 {
    int y, x;
    char type;

    public Point2(int y, int x, char type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }
}

public class Main {

    static int N, M;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static char[][] zido;
    static int[][] count;
    static Point2 S;
    static Point2 D;
    static Point2 W;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nm = sc.nextLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        zido = new char[N][M];
        count = new int[N][M];

        for (int y = 0; y < N; y++) {
            char[] split = sc.nextLine().toCharArray();
            for (int x = 0; x < M; x++) {
                zido[y][x] = split[x];
                if (zido[y][x] == 'S') {
                    S = new Point2(y, x, 'S');
                } else if (zido[y][x] == 'D') {
                    D = new Point2(y, x, 'D');
                } else if (zido[y][x] == '*') {
                    W = new Point2(y, x, '*');
                }
            }
        }

        bfs();
        if (count[D.y][D.x] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(count[D.y][D.x]);
        }

    }

    static void bfs() {
        Queue<Point2> Q = new LinkedList<>();

        if (W != null) {
            Q.add(W);
        }
        Q.add(S);
        while (!Q.isEmpty()) {
            // 1. 큐에서 꺼내옴
            Point2 point = Q.poll();

            // 2. 목적지인가
            if (point.type == 'D') {
                break;
            }

            // 3. 연결된 순회
            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];

                // 2. 목적지인가
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (point.type == '*') {
                        if (zido[ny][nx] == '.' || zido[ny][nx] == 'S') {
                            zido[ny][nx] = '*';
                            Q.add(new Point2(ny, nx, '*'));
                        }
                    } else if ((point.type == '.' || point.type == 'S') && count[ny][nx] == 0) {
                        if (zido[ny][nx] == '.') {
                            Q.add(new Point2(ny, nx, '.'));
                            count[ny][nx] = count[point.y][point.x] + 1;
                        } else if (zido[ny][nx] == 'D') {
                            Q.add(new Point2(ny, nx, 'D'));
                            count[ny][nx] = count[point.y][point.x] + 1;
                        }
                    }
                }
            }

        }
    }

}
