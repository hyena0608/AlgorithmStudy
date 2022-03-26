package 인프런_자바_알고리즘_문제_기초.올바른괄호;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public String solution(String parentheses) {
        String answer = "YES";
        char leftShape = '(';
        char rightShape = ')';
        int leftCount = 0;
        int rightCount = 0;

        for (char parenthesis : parentheses.toCharArray()) {

            if (parenthesis == leftShape) {
                leftCount++;
            } else if (parenthesis == rightShape) {
                rightCount++;
            }

            if (rightCount > leftCount) {
                answer = "NO";
                break;
            }

        }

        if (rightCount != leftCount) {
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