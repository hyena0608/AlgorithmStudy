package 인프런_자바_알고리즘_문제_기초;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 가장짧은문자거리 {
    public int[] solution(String str, char t) {
        int[] answer = new int[str.length()];
        int len = str.length();
        int cnt = 101;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == t) {
                cnt = 0;
                answer[i] = cnt;
            } else {
                cnt++;
                answer[i] = cnt;
            }
        }
        cnt = 101;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == t) cnt = 0;
            else {
                cnt++;
                answer[i] = Math.min(answer[i], cnt);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        가장짧은문자거리 T = new 가장짧은문자거리();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for (int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}
