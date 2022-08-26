package 프로그래머스.자바_코딩테스트_연습.나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) list.add(arr[i]);
        }

        int[] answer = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        if (answer.length == 0) return new int[] {-1};
        else return answer;
    }
}
