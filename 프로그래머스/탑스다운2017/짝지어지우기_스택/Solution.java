package 프로그래머스.탑스다운2017.짝지어지우기_스택;

import java.util.Stack;

public class Solution {
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.empty()) {
                if (stack.peek() == c) stack.pop();
                else stack.push(c);
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) return 1;
        else return 0;
    }
}

