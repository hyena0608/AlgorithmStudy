package 인프런_자바_알고리즘_문제_기초;

import java.util.Scanner;

public class 문장속단어 {

    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if (str.length() > m) answer = str;
        return answer;
    }

    public static void main(String[] args) {
        문장속단어 T = new 문장속단어();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
