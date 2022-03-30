package 인프런_자바_알고리즘_문제_기초.팩토리얼;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author hyena
 */
public class Main {
    public int dfs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else return n * dfs(n - 1);
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        System.out.println(T.dfs(n));
    }
}
