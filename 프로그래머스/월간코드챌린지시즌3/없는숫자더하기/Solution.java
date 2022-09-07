package 프로그래머스.월간코드챌린지시즌3.없는숫자더하기;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] isExist = new boolean[10];
        for (int number : numbers) {
            isExist[number] = true;
        }

        for (int i = 0; i <= 9; i++) {
            if (!isExist[i]) answer += i;
        }

        return answer;
    }
}
