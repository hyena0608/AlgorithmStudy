package 프로그래머스.자바_코딩테스트_연습.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();
        int currNum = -1;
        for (int num : arr) {
            if (currNum != num) list.add(num);
            currNum = num;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}
