package 프로그래머스.카카오2019인턴십.튜플;

import java.util.*;

public class Solution {

//    public int[] solution(String s) {
//
//    }

    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "-");
        String[] splits = s.split("-");

        int length = splits.length;
        int[] answer = new int[length];
        Queue<Integer> Q = new LinkedList<>();

        Arrays.sort(splits, (a, b) -> (a.length() - b.length()));
        for (String split : splits) {
            System.out.println(split);
            for (String number : split.split(",")) {
                if (!Q.contains(Integer.parseInt(number))) {
                    Q.offer(Integer.valueOf(number));
                }
            }
        }

        for (Integer integer : Q) {
            System.out.print(integer + " ");
        }
        System.out.println();


        for (int i = 0; i < length; i++) {
            answer[i] = Q.poll();
        }


        for (int i : answer) {
            System.out.println(i);
        }
    }
}
