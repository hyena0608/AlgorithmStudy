package 백준.자바.가장큰정사각형_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, 1};
    static int[] dy = {0, -1, -1};
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                dp[i][j] = c[j] - '0';
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[i][j] == 0 || dp[i][j] == -1) continue;
                if (dp[i][j] == 1) {
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));

                    int squareLineSize = 1;
                    outer:
                    while (!q.isEmpty()) {
                        Point poll = q.poll();
                        for (int k = 0; k < 3; k++) {
                            int ny = poll.y + dy[k];
                            int nx = poll.x + dx[k];

                            if (0 > ny || ny >= N || 0 > nx || nx >= M) break outer;

                            if (dp[ny][nx] == 1) {
                                q.add(new Point(ny, nx));
                                squareLineSize++;
                            } else if (dp[ny][nx] == -1) {
                                continue;
                            } else {
                                break outer;
                            }
                        }
                        dp[poll.y][poll.x] = -1;
                    }
                    int a = (int) Math.sqrt(squareLineSize);
                    answer = Math.max(answer, a *a);
                }
            }
        }

        System.out.println(answer);
    }
}

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}