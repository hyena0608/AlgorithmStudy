import java.io.*;
import java.util.*;

public class Main2 {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static String[][] map;
    static int N;
    static int M;
    static boolean isFind;
    static int startS;

    static int answer;

    public static void main(String[] args) throws IOException {
        class Point {
            int y, x;

            public Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());

        Map<String, Point> pointMap = new HashMap<>();

        for (int c = 0; c < caseCount; c++) {
            StringTokenizer stNMYX = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stNMYX.nextToken());
            M = Integer.parseInt(stNMYX.nextToken());
            int R = Integer.parseInt(stNMYX.nextToken());
            int K = Integer.parseInt(stNMYX.nextToken());

            map = new String[N][M];
            isFind = false;
            answer = 0;
            startS = Integer.MAX_VALUE;

            for (int y = 0; y < N; y++) {
                String[] line = br.readLine().split("");
                for (int x = 0; x < M; x++) {
                    if (line[x].equals("A")) {
                        pointMap.put("A", new Point(y, x));
                    } else if (line[x].equals("B")) {
                        pointMap.put("B", new Point(y, x));
                    } else if (line[x].equals("C")) {
                        pointMap.put("C", new Point(y, x));
                    } else if (line[x].equals("S")) {
                        pointMap.put("S", new Point(y, x));
                    }
                    map[y][x] = line[x];
                }
            }

//            for (String loc : pointMap.keySet()) {
//                Point point = pointMap.get(loc);
//                findSwordDfs(0, currentPoint.y, currentPoint.x, point.y, point.x, new boolean[N][M]);
//                currentPoint = point;
//                isFind = false;
//            }

            Point A = pointMap.get("A");
            Point B = pointMap.get("B");
            Point C = pointMap.get("C");
            Point currentPoint = new Point(R, K);
            Point S = pointMap.get("S");

            findSwordDfs(0, B.y, B.x, A.y, A.x, new boolean[N][M]);
            findSwordDfs(0, B.y, B.x, C.y, C.x, new boolean[N][M]);
            System.out.println("startS = " + startS);


            answer = 0;
            startS = Integer.MAX_VALUE;
            System.out.println("================================");
        }
    }

    private static void findSwordDfs(int L, int currentY, int currentX, int targetY, int targetX, boolean[][] visited) {
        if (currentX == targetX && currentY == targetY && !isFind) {
            isFind = true;
            visited[currentY][currentX] = true;
            startS = Math.min(startS, L);
            System.out.println("answer = " + answer);
        }

        if (!isFind) {
            for (int i = 0; i < 4; i++) {
                int ny = currentY + dy[i];
                int nx = currentX + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && !isFind) {
                    visited[ny][nx] = true;
                    findSwordDfs(L + 1, ny, nx, targetY, targetX, visited);
                    visited[ny][nx] = false;
                }
            }
        }
    }


    private static void dfs(int L, int currentX, int currentY, String[][] map, int N, int M, boolean[][] visited, List<String> swordPieceList) {
        if (map[currentY][currentX].equals("S") && isSwordPrepared(swordPieceList)) {
            answer = L;
            System.out.println("answer = " + answer);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = currentY + dy[i];
            int nx = currentX + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (isSwordPrepared(swordPieceList)) {
                    dfs(L + 1, nx, ny, map, N, M, visited, swordPieceList);
                }

                if (!isSwordPrepared(swordPieceList)) {
                    if (!map[ny][nx].equals("X")) {
                        if (map[ny][nx].equals("A")) {
                            swordPieceList.add("A");
                            map[ny][nx] = ".";
                        }
                        if (map[ny][nx].equals("B")) {
                            swordPieceList.add("B");
                            map[ny][nx] = ".";
                        }
                        if (map[ny][nx].equals("C")) {
                            swordPieceList.add("C");
                            map[ny][nx] = ".";
                        }
                        dfs(L + 1, nx, ny, map, N, M, visited, swordPieceList);
                    }
                }
            }
        }
    }

    private static boolean isSwordPrepared(List<String> swordPieceList) {
        return swordPieceList.contains("A") && swordPieceList.contains("B") && swordPieceList.contains("C");
    }
}
