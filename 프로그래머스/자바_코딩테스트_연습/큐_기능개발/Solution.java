package 프로그래머스.자바_코딩테스트_연습.큐_기능개발;

/**
 * @author hyena
 */
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = 1;
            while (progresses[i] + speeds[i] * days < 100) {
                days++;
            }
            Q.add(days);
        }

        int currentDays = Q.poll();
        int cnt = 1;
        while (!Q.isEmpty()) {
            if (currentDays >= Q.peek()) {
                Q.poll();
                cnt++;
            } else {
                currentDays = Q.poll();
                answerList.add(cnt);
                cnt = 1;
            }
        }
        answerList.add(cnt);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}