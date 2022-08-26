package 프로그래머스.자바_코딩테스트_연습.x만큼간격이있는n개의숫자;

public class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (long) x * i;
        }

        return answer;
    }
}