package 인프런_자바_알고리즘_문제_기초;

import java.util.Scanner;

public class 회문문자열 {
    public String solution(String str) {
        str = str.toUpperCase();
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        회문문자열 T = new 회문문자열();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
