package 인프런_자바_알고리즘_문제_기초.바둑이승차;

import java.util.Scanner;

/**
 * @author hyena
 */
public class Main {
    private static int C, N;
    static int answer = 0;
    static int[] arr;

    public void dfs(int L, int sum) {
        if (sum > C) return;
        if (L == N) {
            if (answer <= sum) answer = sum;
        } else {
            dfs(L + 1, sum + arr[L]);
            dfs(L + 1, sum);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        String[] CN = sc.nextLine().split(" ");
        C = Integer.parseInt(CN[0]);
        N = Integer.parseInt(CN[1]);
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        T.dfs(0, 0);
        System.out.println(answer);
    }
}
