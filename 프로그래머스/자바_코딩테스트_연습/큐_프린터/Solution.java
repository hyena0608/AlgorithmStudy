package 프로그래머스.자바_코딩테스트_연습.큐_프린터;

import java.util.*;

/**
 * @author hyena
 */
class Docu {
    int priority;
    int location;

    public Docu(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        Stack<Integer> stack = new Stack<>();
        Queue<Docu> Q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            Q.add(new Docu(priorities[i], i));
        }

        Arrays.sort(priorities);
        for (int p : priorities) {
            stack.add(p);
        }

        int cnt = 0;
        while(!Q.isEmpty()) {
            Docu polledDocu = Q.poll();
            if (stack.peek() == polledDocu.priority) {
                cnt++;
                stack.pop();
                if (polledDocu.location == location) {
                    return cnt;
                }
            } else {
                Q.add(polledDocu);
            }
        }

        return 0;
    }
}