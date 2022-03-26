package 인프런_자바_알고리즘_문제_기초.괄호문자제거;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public List<Character> solution(String str) {
        List<Character> charList = new ArrayList<>();
        char leftShape = '(';
        char rightShape = ')';
        int leftCount = 0;
        int rightCount = 0;

        for (Character c : str.toCharArray()) {

            if (leftCount != rightCount || !Character.isAlphabetic(c)) {

                if (c == leftShape) {
                    leftCount++;
                } else if (c == rightShape) {
                    rightCount++;
                }

            } else {
                charList.add(c);
            }

        }

        return charList;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        List<Character> charList = T.solution(str);
        for (Character c : charList) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
