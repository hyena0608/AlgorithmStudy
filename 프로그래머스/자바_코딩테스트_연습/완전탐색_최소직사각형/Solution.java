package 프로그래머스.자바_코딩테스트_연습.완전탐색_최소직사각형;

public class Solution {

    public int solution(int[][] sizes) {

        int length = sizes.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < length; i++) {
            int row = sizes[i][0];
            int col = sizes[i][1];

            if (row < col) {
                sizes[i][0] = col;
                sizes[i][1] = row;
            }
            maxRow = Math.max(sizes[i][0],  maxRow);
            maxCol = Math.max(maxCol, sizes[i][1]);
        }


        return maxCol * maxRow;
    }
}
