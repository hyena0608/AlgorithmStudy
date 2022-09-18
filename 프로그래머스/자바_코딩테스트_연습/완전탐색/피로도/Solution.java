package 프로그래머스.자바_코딩테스트_연습.완전탐색.피로도;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int answerForDFS = 0;

    public int solution(int k, int[][] dungeons) {

        // dfs
//        findBestDFS(0, k, new boolean[dungeons.length], dungeons);
//        return answerForDFS;

        // bfs
        return findBestBFS(k, dungeons);
    }

    private void findBestDFS(int count, int tired, boolean[] visited, int[][] dungeons) {
        answerForDFS = Math.max(answerForDFS, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (tired < dungeons[i][0]) continue;
            if (tired - dungeons[i][1] < 0) continue;

            visited[i] = true;
            findBestDFS(count + 1, tired - dungeons[i][1], visited, dungeons);
            visited[i] = false;
        }
    }

    private int findBestBFS(int tired, int[][] dungeons) {

        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(tired, 0, new boolean[8]));

        int maxCount = 0;
        while (!Q.isEmpty()) {
            Point poll = Q.poll();

            maxCount = Math.max(maxCount, poll.count);

            for (int i = 0; i < dungeons.length; i++) {
                if (poll.visited[i]) continue;
                if (poll.leftTired < dungeons[i][0]) continue;
                if (poll.leftTired - dungeons[i][1] < 0) continue;

                poll.visited[i] = true;
                Q.add(new Point(
                        poll.leftTired - dungeons[i][1],
                        poll.count + 1,
                        poll.visited.clone()
                ));
                poll.visited[i] = false;
            }
        }

        return maxCount;
    }

    static class Point {

        int leftTired, count;
        boolean[] visited;

        public Point(int leftTired, int count, boolean[] visited) {
            this.leftTired = leftTired;
            this.count = count;
            this.visited = visited;
        }
    }
}
