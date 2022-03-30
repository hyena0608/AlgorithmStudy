package 인프런_자바_알고리즘_문제_기초.피보나치재귀;

import java.util.Scanner;

/**
 * @author hyena
 */
public class Main {
    static int[] arr;
    public int dfs(int n) {
        if (n == 1) {
            return arr[n] = 1;
        } else if (n == 2) {
            return arr[n] = 1;
        } else {
            return arr[n] = dfs(n - 1) + dfs(n - 2);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        arr = new int[n + 1];

        T.dfs(n);
        for (int i : arr) {
            System.out.print(arr[i] + " ");
        }
    }
}
