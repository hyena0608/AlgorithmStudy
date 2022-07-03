package 프로그래머스.카카오2020인턴십.키패드누르기;

import java.util.HashMap;
import java.util.Map;

class Solution {
    class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        S.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }

    public String solution(int[] numbers, String hand) {
        String[][] keypad = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"*", "0", "#"}};
        Map<String, Point> keypadMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 3; x++) {
                keypadMap.put(keypad[y][x], new Point(y, x));
            }
        }

        Point right = keypadMap.get("#");
        Point left = keypadMap.get("*");

        for (int number : numbers) {
            int key = -1;
            if (number == 1 || number == 4 || number == 7) {
                key = 2;
            } else if (number == 3 || number == 6 || number == 9) {
                key = 1;
            } else if (number == 2 || number == 5 || number == 8 || number == 0) {
                key = whichIsBig(keypadMap, right, left, number, hand);
            }
            if (key == 1) {
                sb.append("R");
                right = keypadMap.get(String.valueOf(number));
            } else if (key == 2) {
                sb.append("L");
                left = keypadMap.get(String.valueOf(number));
            }
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    // right = 1, left = 2
    private int whichIsBig(Map<String, Point> keypadMap, Point right, Point left, int number, String hand) {
        int rightDistance = calDistance(keypadMap, right, number);
        int leftDistance = calDistance(keypadMap, left, number);
        if (rightDistance > leftDistance) {
            return 2;
        } else if (rightDistance < leftDistance) {
            return 1;
        } else {
            if (hand.equals("right")) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    private int calDistance(Map<String, Point> keypadMap, Point point, int number) {
        Point p = keypadMap.get(String.valueOf(number));
        int distance = Math.abs(point.y - p.y) + Math.abs(point.x - p.x);
        return distance;
    }
}