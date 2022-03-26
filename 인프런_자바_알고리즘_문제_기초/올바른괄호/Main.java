package 인프런_자바_알고리즘_문제_기초.올바른괄호;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public String solution(String parenthesese) {
        String answer = "YES";
        Stack<Character> parenthesisStack = new Stack<>();

        for (char c : parenthesese.toCharArray()) {

            if (c == '(') {
                parenthesisStack.push(c);
            } else {

                if (parenthesisStack.isEmpty()) {
                    answer = "NO";
                    break;
                } else {
                    parenthesisStack.pop();
                }

            }

        }

        if (!parenthesisStack.isEmpty()) {
            answer = "NO";
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String parentheses = st.nextToken();

        String answer = T.solution(parentheses);

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}