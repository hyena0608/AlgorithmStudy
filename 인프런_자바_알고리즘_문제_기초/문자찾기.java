package 인프런_자바_알고리즘_문제_기초;

import java.util.Locale;
import java.util.Scanner;

public class 문자찾기 {

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for(char x : str.toCharArray()) {
            if (x == t) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        문자찾기 T = new 문자찾기();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
