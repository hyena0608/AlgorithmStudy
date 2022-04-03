package 인프런_자바_알고리즘_문제_기초.동전교환;

import java.io.*;
import java.util.*;

/**
 * @author hyena
 */
public class Main {
    static int n, leftCash, answer = Integer.MAX_VALUE;
    static Integer[] coins;

    public void dfs(int L, int sum) {
        if (sum > leftCash) return;
        if (L >= answer) return;
        if (sum == leftCash) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(L + 1, sum + coins[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        coins = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        leftCash = Integer.parseInt(br.readLine());
        Arrays.sort(coins, Collections.reverseOrder());
        T.dfs(0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
