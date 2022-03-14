package 인프런_자바_알고리즘_문제_기초;

import java.util.Scanner;

public class 중복문자제거 {
    public String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
//            System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        중복문자제거 T = new 중복문자제거();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
