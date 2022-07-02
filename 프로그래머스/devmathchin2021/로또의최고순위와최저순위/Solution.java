package 프로그래머스.devmathchin2021.로또의최고순위와최저순위;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int maxWin = 0;
        int minWin = 0;
        int correctNum = 0;
        int erasedNum = 0;
        int[] answer = new int[2];

        for (int lotto : lottos) {
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    correctNum++;
                }
            }
            if (lotto == 0) {
                erasedNum++;
            }
        }

        int sum_num = correctNum + erasedNum;
        if (sum_num == 6) {
            answer[0] = 1;
        } else if (sum_num == 5) {
            answer[0] = 2;
        } else if (sum_num == 4) {
            answer[0] = 3;
        } else if (sum_num == 3) {
            answer[0] = 4;
        } else if (sum_num == 2) {
            answer[0] = 5;
        } else if (sum_num == 1) {
            answer[0] = 6;
        } else if (sum_num == 0) {
            answer[0] = 6;
        }

        if (correctNum == 6) {
            answer[1] = 1;
        } else if (correctNum == 5) {
            answer[1] = 2;
        } else if (correctNum == 4) {
            answer[1] = 3;
        } else if (correctNum == 3) {
            answer[1] = 4;
        } else if (correctNum == 2) {
            answer[1] = 5;
        } else if (correctNum == 1) {
            answer[1] = 6;
        } else if (correctNum == 0) {
            answer[1] = 6;
        }

        return answer;
    }
}