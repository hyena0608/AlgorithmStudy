package 인프런_자바_알고리즘_문제_기초;

import java.util.Scanner;

public class 대소문자변환 {

    public String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (x >= 97 && x <= 122) answer += (char) (x - 32);
            else answer += (char) (x + 32);
        }
        return answer;
    }

    public static void main(String[] args) {
        대소문자변환 T = new 대소문자변환();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
