//package 백준.자바.적록색약_10026;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Main {
//
//    static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
//    static int N;
//    static char[][] board;
//    static boolean[][] visited;
//    static int[][] red_green;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        board = new char[N][];
//        for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
//
//        int count1 = 0;
//        Queue<Point> Q;
//        Q = new LinkedList<>();
//        Q.add(new Point(0, 0));
//        visited = new boolean[N][N];
//        while (!Q.isEmpty()) {
//            // 전체 담당
//            Point poll = Q.poll();
//            if (visited[poll.y][poll.x]) continue;
//
//            Queue<Point> innerQ = new LinkedList<>();
//            innerQ.add(poll);
//            char selectedColor = board[poll.y][poll.x];
//
//            while (!innerQ.isEmpty()) {
//                // 현재 색상 담당
//                Point pollInnerQ = innerQ.poll();
//
//                visited[pollInnerQ.y][pollInnerQ.x] = true;
//
//
//                for (int i = 0; i < 4; i++) {
//                    int ny = pollInnerQ.y + dy[i];
//                    int nx = pollInnerQ.x + dx[i];
//
//                    if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;
//                    if (visited[ny][nx]) continue;
//
//                    if (board[ny][nx] == selectedColor) innerQ.add(new Point(ny, nx));
//                    else Q.add(new Point(ny, nx));
//
//                    if ((selectedColor == 'R' && board[ny][nx] == 'G')
//                            || (selectedColor == 'G' && board[ny][nx] == 'R')
//                    ) {
//                        innerQ.add(new Point(ny, nx));
//                    } else {
//                        Q.add(new Point(ny, nx));
//                    }
//                }
//
//                Queue<Point> redGreenQ = new LinkedList<>();
//                if (red_green[poll.y][poll.x] == 0 && (selectedColor == 'R' || selectedColor == 'G')) redGreenQ.add(pollInnerQ);
//                for (int i = 0; i < 4; i++) {
//                    int ny = pollInnerQ.y + dy[i];
//                    int nx = pollInnerQ.x + dx[i];
//
//                    if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;
//                    if (visited[ny][nx]) continue;
//
//                }
//            }
//            count1++;
//        }
//
////        int count2 = 0;
////        Q.clear();
////        for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);
////        Q.add(new Point(0, 0));
////        visited = new boolean[N][N];
////        while (!Q.isEmpty()) {
////            // 전체 담당
////            Point poll = Q.poll();
////            if (visited[poll.y][poll.x]) continue;
////
////            Queue<Point> innerQ = new LinkedList<>();
////            innerQ.add(poll);
////            char selectedColor = board[poll.y][poll.x];
////            while (!innerQ.isEmpty()) {
////                // 현재 색상 담당
////                Point pollInnerQ = innerQ.poll();
////
////                visited[pollInnerQ.y][pollInnerQ.x] = true;
////
////                for (int i = 0; i < 4; i++) {
////                    int ny = pollInnerQ.y + dy[i];
////                    int nx = pollInnerQ.x + dx[i];
////
////                    if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;
////                    if (visited[ny][nx]) continue;
////
////
////                    if (board[ny][nx] == selectedColor
////                            || (selectedColor == 'R' && board[ny][nx] == 'G')
////                            || (selectedColor == 'G' && board[ny][nx] == 'R')
////                    ) {
////                        innerQ.add(new Point(ny, nx));
////                    } else {
////                        Q.add(new Point(ny, nx));
////                    }
////                }
////            }
////            count2++;
////        }
//        System.out.println(count1 + " " + count2);
//    }
//}
//
//class Point {
//    int y, x;
//
//    public Point(int y, int x) {
//        this.y = y;
//        this.x = x;
//    }
//}
