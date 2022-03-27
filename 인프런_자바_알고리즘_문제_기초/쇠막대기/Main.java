package 인프런_자바_알고리즘_문제_기초.쇠막대기;

import java.io.*;
import java.util.Stack;

/**
 * @author hyena
 */
public class Main {
    public int solution(String parentheses) {
        int cutStickCount = 0;
        char beforeParenthsis = ' ';
        Stack<Character> parenthesesStack = new Stack<>();

        for (char parenthsis : parentheses.toCharArray()) {
            if (parenthsis == '(') {
                parenthesesStack.push(parenthsis);
            } else {
                parenthesesStack.pop();
                if (beforeParenthsis == '(') {
                    cutStickCount += parenthesesStack.size();
                } else {
                    cutStickCount++;
                }
            }
            beforeParenthsis = parenthsis;
        }
        return cutStickCount;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String parentheses = br.readLine();

        int answer = T.solution(parentheses);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
