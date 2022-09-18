package 프로그래머스.자바_코딩테스트_연습.완전탐색.카펫;

public class Solution {

    final static int MAX_BROWN = 5000;
    final static int MAX_YELLOW = 2000000;
    final static int MAX_COL_ROW_SIZE = (int) Math.sqrt(MAX_BROWN + MAX_YELLOW);

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalSquares = brown + yellow;

        for (int col = 3; col <= MAX_COL_ROW_SIZE; col++) {
            if (totalSquares % col != 0) continue;

            int row = totalSquares / col;
            int currBrown = (col + row) * 2 - 4;
            int currYellow = totalSquares - currBrown;

            if (currBrown == brown && currYellow == yellow) {
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }

        return answer;
    }
}
