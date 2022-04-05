package 인프런_자바_알고리즘_문제_기초.조합구하기;

import java.util.Scanner;

/**
 * @author hyena
 */
public class Main {
    static int n;
    static int m;
    static int[] combi;

    public void dfs(int L, int s) {
        if (L == m) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        T.dfs(0, 1);



    }
}
