package 프로그래머스.카카오2017예선.카카오프렌즈컬러링북;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();

            if (visited[poll.y][poll.x]) continue;

            Queue<Point> innerQ = new LinkedList<>();
            innerQ.add(new Point(poll.y, poll.x));
            int currColor = picture[poll.y][poll.x];
            visited[poll.y][poll.x] = true;
            int count = 0;

            while (!innerQ.isEmpty()) {
                Point innerPoll = innerQ.poll();
                count++;

                for (int i = 0; i < 4; i++) {
                    int ny = innerPoll.y + dy[i];
                    int nx = innerPoll.x + dx[i];

                    if (0 > ny || ny >= m || 0 > nx || nx >= n) continue;
                    if (visited[ny][nx]) continue;

                    if (picture[ny][nx] == currColor) {
                        visited[ny][nx] = true;
                        innerQ.add(new Point(ny, nx));
                    } else q.add(new Point(ny, nx));
                }
            }

            if (currColor != 0) {
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
            }

        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
