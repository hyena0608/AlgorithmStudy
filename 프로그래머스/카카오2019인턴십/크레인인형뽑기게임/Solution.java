package 프로그래머스.카카오2019인턴십.크레인인형뽑기게임;

import java.util.Stack;

public class Solution {
    static int answer = 0;
    public int solution(int[][] board, int[] moves) {
        int length = board.length;
        Stack<Integer> box = new Stack<>();

        for (int x : moves) {
            for (int y = 0; y < length; y++) {
                if (board[y][x - 1] != 0) {
                    if (!isNeedToBomb(box, board[y][x - 1])) {
                        box.push(board[y][x - 1]);
                    } else if (isNeedToBomb(box, board[y][x - 1])) {
                        box.pop();
                    }
                    board[y][x - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    private boolean isNeedToBomb(Stack<Integer> box, int dollTwo) {
        if (!box.isEmpty()) {
            int dollOne = box.peek();
            if (dollOne == dollTwo) {
                answer++;
                return true;
            }
        }
        return false;
    }
}
