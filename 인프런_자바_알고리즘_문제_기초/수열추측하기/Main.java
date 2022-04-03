package 인프런_자바_알고리즘_문제_기초.수열추측하기;

import java.util.Scanner;

/**
 * @author hyena
 */
public class Main {
    static int n, m;
    static int[] arr;

    public int dfs(int a) {
        if (a == n) return arr[a] = m;
        else {
            return arr[a] = dfs(a - 1) + dfs(a - 2);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 1];
        T.dfs(n);
    }
}
