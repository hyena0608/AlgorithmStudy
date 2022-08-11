package 백준.자바.PuyoPuyo_11559;

import java.io.*;
import java.util.*;

public class Main {

    static int Y_MAX = 12;
    static int X_MAX = 6;
    static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    static char[][] fields;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바/PuyoPuyo_11559/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[Y_MAX][X_MAX];
        fields = new char[Y_MAX][X_MAX];

        for (int i = 0; i < Y_MAX; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < X_MAX; j++) {
                fields[i][j] = chars[j];
            }
        }

        int pang = 0;
        while (true) {
            boolean isPang = false;
            for (int i = 0; i < Y_MAX; i++) Arrays.fill(visited[i], false);

            for (int j = 0; j < X_MAX; j++) {
                if (fields[Y_MAX - 1][j] == '.') continue;
                if (visited[Y_MAX - 1][j]) continue;

                Queue<Point> repo = new LinkedList<>();
                repo.add(new Point(Y_MAX - 1, j));

                while (!repo.isEmpty()) {
                    Point poll = repo.poll();
                    if (visited[poll.y][poll.x]) continue;

                    List<Point> deletedList = new ArrayList<>();
                    Queue<Point> selectedRepo = new LinkedList<>();
                    selectedRepo.add(poll);
                    char selectedColor = fields[poll.y][poll.x];
                    int count = 0;

                    while (!selectedRepo.isEmpty()) {
                        Point selectedPoll = selectedRepo.poll();
                        if (visited[selectedPoll.y][selectedPoll.x]) continue;

                        deletedList.add(selectedPoll);
                        visited[selectedPoll.y][selectedPoll.x] = true;
                        count++;

                        for (int k = 0; k < 4; k++) {
                            int ny = selectedPoll.y + dy[k];
                            int nx = selectedPoll.x + dx[k];

                            if (0 > nx || nx >= X_MAX || 0 > ny || ny >= Y_MAX) continue;
                            if (visited[ny][nx]) continue;

                            if (fields[ny][nx] == selectedColor) {
                                selectedRepo.add(new Point(ny, nx));
                            } else if (fields[ny][nx] != '.') {
                                repo.add(new Point(ny, nx));
                            }
                        }
                    }

                    if (count >= 4) {
                        isPang = true;
                        for (Point deleted : deletedList) fields[deleted.y][deleted.x] = '.';
                    }
                }
            }

            // 중력
            for (int i = 0; i < X_MAX; i++) {
                for (int k = Y_MAX - 1; k >= 0; k--) {
                    if (fields[k][i] == '.') {
                        for (int l = k - 1; l >= 0; l--) {
                            if (fields[l][i] != '.') {
                                fields[k][i] = fields[l][i];
                                fields[l][i] = '.';
                                break;
                            }
                        }
                    }
                }
            }
            if (isPang) pang++;
            if (!isPang) break;
        }
        System.out.println(pang);
    }
}


class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}