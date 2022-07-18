package 백준.자바_특강.DAY1.탈출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int y, x;
    char type;

    public Point (int y, int x, char type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }
}
public class Main2 {

    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    static int N, M;
    static char[][] map;
    static int[][] turnCount;
    static Queue<Point> Q;
    static boolean foundAnswer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        turnCount = new int[N][M];
        Q = new LinkedList<>();

        Point st = null;
        for (int y = 0; y < N; y++) {
            String line = sc.next();
            for (int x = 0; x < M; x++) {
                map[y][x] = line.charAt(x);
                if (map[y][x] == '*') {
                    Q.add(new Point(y, x, '*'));
                } else if (map[y][x] == 'S') {
                    st = new Point(y, x, 'S');
                }
            }
        }
        Q.add(st);

        while (!Q.isEmpty()) {
            // 1. 큐에서 꺼내옴
            Point point = Q.poll();

            // 2. 목적지 인가 ? -> D
            if (point.type == 'D') {
                System.out.println(turnCount[point.y][point.x]);
                foundAnswer = true;
                break;
            }

            // 3. 연결된 곳 순회
            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];

                // 4. 갈 수 있는가 ?
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (point.type == 'S' || point.type == '.') {
                        // 4. 고슴도치 : D, 방문하지 않은 곳(.)
                        if ((map[ny][nx] == '.' || map[ny][nx] == 'D') && turnCount[ny][nx] == 0) {
                            // 5. 체크인
                            turnCount[ny][nx] = turnCount[point.y][point.x] + 1;
                            // 6. 큐에 넣음
                            Q.add(new Point(ny, nx, map[ny][nx]));
                        }
                    } else if (point.type == '*') {
                        // 4. 물 : ., S
                        if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
                            // 5. 체크인
                            map[ny][nx] = '*';
                            // 6. 큐에 넣음
                            Q.add(new Point(ny, nx, '*'));
                        }
                    }
                }
            }

        }

        if (!foundAnswer) {
            System.out.println("KAKTUS");
        }
    }

}
