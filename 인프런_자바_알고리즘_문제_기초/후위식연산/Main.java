package 인프런_자바_알고리즘_문제_기초.후위식연산;

import java.io.*;
import java.util.Stack;

public class Main {
    public int solution(String str) {
        Stack<Integer> postfixStack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                postfixStack.push(c - 48);
            } else {
                int popedA = postfixStack.pop();
                int popedB = postfixStack.pop();
                if (c == '+') {
                    postfixStack.push(popedB + popedA);
                } else if (c == '-') {
                    postfixStack.push(popedB - popedA);
                } else if (c == '*') {
                    postfixStack.push(popedB * popedA);
                } else if (c == '/') {
                    postfixStack.push(popedB / popedA);
                }
            }
        }
        return postfixStack.pop();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int answer = T.solution(str);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
