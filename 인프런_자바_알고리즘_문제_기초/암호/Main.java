package 인프런_자바_알고리즘_문제_기초.암호;

import java.util.Scanner;

public class Main {
    public String solution(int cnt, String str) {
        String answer = "";
        for (int i = 0; i < cnt; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            str = str.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(cnt, str));
    }
}
