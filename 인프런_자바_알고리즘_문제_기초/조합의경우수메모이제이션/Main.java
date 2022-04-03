package 인프런_자바_알고리즘_문제_기초.조합의경우수메모이제이션;

import java.util.Scanner;

/**
 * @author hyena
 */
public class Main {
    static int n, r;
    static int[][] arr;

    public int dfs(int a, int b) {
        if (a == b) return arr[a][b] = 1;
        else if (b == 0) return arr[a][b] = 1;
        else {
            return arr[a][b] =  dfs(a - 1, b - 1) + dfs(a - 1, b);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();

        arr = new int[n + 1][r + 1];

        T.dfs(n, r);
        System.out.println(arr[n][r]);
    }
}
