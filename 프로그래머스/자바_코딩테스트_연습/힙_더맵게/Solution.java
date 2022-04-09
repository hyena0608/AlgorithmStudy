package 프로그래머스.자바_코딩테스트_연습.힙_더맵게;

import java.util.*;

/**
 * @author hyena
 */
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> Q = new PriorityQueue<>();

        for (int s : scoville) {
            Q.add(s);
        }

        while (Q.size() > 1 && Q.peek() < K) {
            int a = Q.poll();
            int b = Q.poll();
            Q.add(a + (b * 2));
            answer++;
        }

        if (Q.peek() >= K) {
            return answer;
        } else {
            return -1;
        }
    }
}
