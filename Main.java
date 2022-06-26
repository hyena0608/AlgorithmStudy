import java.io.*;
import java.util.*;

class Point {
    int y, x;
    int count;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;3
        this.count = 0;
    }

    public Point(int y, int x, int count) {
        this.y = y;33
        this.x = x;
        this.count = count;
    }

}

public class Main {


    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static String[][] map;
    static int N;
    static int M;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int c = 1; c <= caseCount; c++) {
            StringTokenizer stNMYX = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stNMYX.nextToken());
            M = Integer.parseInt(stNMYX.nextToken());
            int R = Integer.parseInt(stNMYX.nextToken());
            int K = Integer.parseInt(stNMYX.nextToken());

            map = new String[N][M];
            answer = Integer.MAX_VALUE;

            Point A = null;
            Point B = null;
            Point C = null;
            Point S = null;
            Point currentPoint = new Point(R - 1, K - 1);

            for (int y = 0; y < N; y++) {
                String[] line = br.readLine().split("");
                for (int x = 0; x < M; x++) {
                    switch (line[x]) {
                        case "A":
                            A = new Point(y, x);
                            break;
                        case "B":
                            B = new Point(y, x);
                            break;
                        case "C":
                            C = new Point(y, x);
                            break;
                        case "S":
                            S = new Point(y, x);
                            break;
                    }
                    map[y][x] = line[x];
                }
            }

            int RA = bfs(currentPoint, A);
            int RB = bfs(currentPoint, B);
            int RC = bfs(currentPoint, C);

            int AB = bfs(A, B);
            int AC = bfs(A, C);
            int BC = bfs(B, C);

            int AS = Math.abs(A.y - S.y) + Math.abs(A.x - S.x);
            int BS = Math.abs(B.y - S.y) + Math.abs(B.x - S.x);
            int CS = Math.abs(C.y - S.y) + Math.abs(C.x - S.x);

            int caseOne = RA + AB + BC + CS;
            int caseTwo = RC + AB + BC + AS;
            int caseThree = RB + AB + AC + CS;
            int caseFour = RC + AB + AC + BS;
            int caseFive = RB + BC + AC + AS;
            int caseSix = RA + BC + AC + BS;

            answer = Math.min(caseOne, caseTwo);
            answer = Math.min(answer, caseThree);
            answer = Math.min(answer, caseFour);
            answer = Math.min(answer, caseFive);
            answer = Math.min(answer, caseSix);

            stringBuilder
                    .append("#")
                    .append(c)
                    .append(" ")
                    .append(answer)
                    .append("\n");
        }
        bw.write(stringBuilder.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(Point start, Point end) {
        Queue<Point> pointQueue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        pointQueue.offer(start);
        while (!pointQueue.isEmpty()) {
            Point point = pointQueue.poll();
            visited[point.y][point.x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && !map[ny][nx].equals("X")) {
                    if (ny == end.y && nx == end.x) {
                        return point.count + 1;
                    }
                    pointQueue.offer(new Point(ny, nx, point.count + 1));
                }
            }
        }
        return -1;
    }

}