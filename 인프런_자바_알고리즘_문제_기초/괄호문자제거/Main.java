package 인프런_자바_알고리즘_문제_기초.괄호문자제거;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public String solution(String str) {
        Stack<Character> st = new Stack<>();
        String answer = "";

        for (char c : str.toCharArray()) {

            if (c == ')') {

                while (st.pop() != '(');

            } else {
                st.push(c);
            }

        }

        for (int i = 0; i < st.size(); i++) {
            answer += st.get(i);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        String answer = T.solution(str);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
