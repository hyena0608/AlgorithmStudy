package 프로그래머스.카카오2020.블록이동하기;

import java.util.*;

public class Solution {
    final static int[] dy = {1, -1, 0, 0};
    final static int[] dx = {0, 0, 1, -1};
    final static String LEFT_UP = "LEFT_UP";
    final static String LEFT_DOWN = "LEFT_DOWN";
    final static String RIGHT_UP = "RIGHT_UP";
    final static String RIGHT_DOWN = "RIGHT_DOWN";
    final static String UP_LEFT = "UP_LEFT";
    final static String UP_RIGHT = "UP_RIGHT";
    final static String DOWN_LEFT = "DOWN_LEFT";
    final static String DOWN_RIGHT = "DOWN_RIGHT";
    static int size;
    static int[][] map;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}});
        System.out.println(answer);
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        map = board;

        size = map[0].length;
        System.out.println("size = " + size);

        Body body = new Body(
                new Part(0, 0),
                new Part(0, 1),
                0);

        Queue<Body> Q = new LinkedList<>();
        Q.add(body);

        while (!Q.isEmpty()) {
            Body curr = Q.poll();

            if (curr.partOne.x == size - 1 && curr.partOne.y == size - 1)
                answer = Math.min(answer, curr.count);
            if (curr.partTwo.x == size - 1 && curr.partTwo.y == size - 1)
                answer = Math.min(answer, curr.count);

            for (int i = 0; i < 4; i++) {
                int partOneY = curr.partOne.y + dy[i];
                int partOneX = curr.partOne.x + dx[i];
                int partTwoY = curr.partTwo.y + dy[i];
                int partTwoX = curr.partTwo.x + dx[i];

                if (0 > partOneY || partOneY >= size || 0 > partOneX || partOneX >= size) continue;
                if (0 > partTwoY || partTwoY >= size || 0 > partTwoX || partTwoX >= size) continue;
                if (board[partOneY][partOneX] == 1 || board[partTwoY][partTwoX] == 1) continue;

                // 회전이 가능하고 부딪히지 않을 때 큐에 추가한다.
                if (isGaro(curr)) {
                    // 가로 ㅡ
                    curr.setLeftAsPartOne();

                    if (isTurnOk(LEFT_UP, partOneX, partOneY, partTwoX, partTwoY)) {
                        // UP
                        Q.add(new Body(
                                new Part(partOneY, partOneX),
                                new Part(partTwoY - 1, partTwoX - 1),
                                curr.count + 1));
                    }

                    if (isTurnOk(LEFT_DOWN, partOneX, partOneY, partTwoX, partTwoY)) {
                        // DOWN
                        Q.add(new Body(
                                new Part(partOneY, partOneX),
                                new Part(partTwoY + 1, partTwoX - 1),
                                curr.count + 1));
                    }

                    if (isTurnOk(RIGHT_UP, partOneX, partOneY, partTwoX, partTwoY)) {
                        // UP
                        Q.add(new Body(
                                new Part(partOneY - 1, partOneX + 1),
                                new Part(partTwoY, partTwoX),
                                curr.count + 1));
                    }

                    if (isTurnOk(RIGHT_DOWN, partOneX, partOneY, partTwoX, partTwoY)) {
                        // DOWN
                        Q.add(new Body(
                                new Part(partOneY + 1, partOneX + 1),
                                new Part(partTwoY, partTwoX),
                                curr.count + 1));
                    }
                } else {
                    // 세로 |
                    curr.setUpAsPartOne();

                    // static UP
                    if (isTurnOk(UP_LEFT, partOneX, partOneY, partTwoX, partTwoY)) {
                        // LEFT
                        Q.add(new Body(
                                new Part(partOneY, partOneX),
                                new Part(partTwoY - 1, partTwoX - 1),
                                curr.count + 1));
                    }

                    if (isTurnOk(UP_RIGHT, partOneX, partOneY, partTwoX, partTwoY)) {
                        // RIGHT
                        Q.add(new Body(
                                new Part(partOneY, partOneX),
                                new Part(partTwoY - 1, partTwoX + 1),
                                curr.count + 1));
                    }

                    // static DOWN
                    if (isTurnOk(DOWN_LEFT, partOneX, partOneY, partTwoX, partTwoY)) {
                        // LEFT
                        Q.add(new Body(
                                new Part(partOneY + 1, partOneX - 1),
                                new Part(partTwoY, partTwoX),
                                curr.count + 1));
                    }

                    if (isTurnOk(DOWN_RIGHT, partOneX, partOneY, partTwoX, partTwoY)) {
                        // RIGHT
                        Q.add(new Body(
                                new Part(partOneY + 1, partOneX + 1),
                                new Part(partTwoY, partTwoX),
                                curr.count + 1));
                    }
                }

            }
        }


        return answer;
    }

    static boolean isGaro(Body body) {
        return body.partOne.y - body.partTwo.y == 0;
    }

    static boolean isTurnOk(String type, int partOneX, int partOneY, int partTwoX, int partTwoY) {
        boolean isOK = false;
        boolean isCornerOk = false;
        if (type.equals(LEFT_UP)) {
            isOK = isRangeOverOrStuck(partOneX, partOneY, partTwoX - 1, partTwoY - 1);
            isCornerOk = isCornerStuck(partOneX + 1, partOneY - 1);
        } else if (type.equals(LEFT_DOWN)) {
            isOK = isRangeOverOrStuck(partOneX, partOneY, partTwoX - 1, partTwoY + 1);
            isCornerOk = isCornerStuck(partOneX + 1, partOneY + 1);
        } else if (type.equals(RIGHT_UP)) {
            isOK = isRangeOverOrStuck(partOneX + 1, partOneY - 1, partTwoX, partTwoY);
            isCornerOk = isCornerStuck(partTwoX - 1, partTwoY - 1);
        } else if (type.equals(RIGHT_DOWN)) {
            isOK = isRangeOverOrStuck(partOneX + 1, partOneY + 1, partTwoX, partTwoY);
            isCornerOk = isCornerStuck(partTwoX - 1, partTwoY + 1);
        } else if (type.equals(UP_LEFT)) {
            isOK = isRangeOverOrStuck(partOneX, partOneY, partTwoX - 1, partTwoY - 1);
            isCornerOk = isCornerStuck(partOneX - 1, partOneY + 1);
        } else if (type.equals(UP_RIGHT)) {
            isOK = isRangeOverOrStuck(partOneX, partOneY, partTwoX + 1, partTwoY - 1);
            isCornerOk = isCornerStuck(partOneX + 1, partOneY + 1);
        } else if (type.equals(DOWN_RIGHT)) {
            isOK = isRangeOverOrStuck(partOneX + 1, partOneY + 1, partTwoX, partTwoY);
            isCornerOk = isCornerStuck(partTwoX + 1, partTwoY - 1);
        } else if (type.equals(DOWN_LEFT)) {
            isOK = isRangeOverOrStuck(partOneX - 1, partOneY + 1, partTwoX, partTwoY);
            isCornerOk = isCornerStuck(partTwoX - 1, partTwoY - 1);
        }
        return isOK && isCornerOk;
    }

    static boolean isRangeOverOrStuck(int partOneX, int partOneY, int partTwoX, int partTwoY) {
        if (0 > partOneY || partOneY >= size || 0 > partOneX || partOneX >= size) return false;
        if (0 > partTwoY || partTwoY >= size || 0 > partTwoX || partTwoX >= size) return false;
        return map[partOneY][partOneX] != 1 && map[partTwoY][partTwoX] != 1;
    }

    static boolean isCornerStuck(int cornerY, int cornerX) {
        if (0 > cornerY || cornerY >= size || 0 > cornerX || cornerX >= size) return false;
        return map[cornerY][cornerX] != 1;
    }
}

class Body {
    Part partOne;
    Part partTwo;
    int count;

    public Body(Part partOne, Part partTwo, int count) {
        this.partOne = partOne;
        this.partTwo = partTwo;
        this.count = count;
    }

    public void setUpAsPartOne() {
        if (partOne == null || partTwo == null) return;
        if (partOne.y < partTwo.y) {
            Part temp = partOne;
            partOne = partTwo;
            partTwo = temp;
        }
    }

    public void setLeftAsPartOne() {
        if (partOne == null || partTwo == null) return;
        if (partOne.x > partTwo.x) {
            Part temp = partOne;
            partOne = partTwo;
            partTwo = temp;
        }
    }
}

class Part {
    int y, x;

    public Part(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

