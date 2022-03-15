package 인프런_자바_알고리즘_문제_기초;

import java.util.Scanner;

public class 팰린드롬 {
    public String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        팰린드롬 T = new 팰린드롬();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
