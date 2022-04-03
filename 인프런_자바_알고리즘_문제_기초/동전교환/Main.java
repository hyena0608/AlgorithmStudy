package 인프런_자바_알고리즘_문제_기초.동전교환;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
public class Main {
    static int n, leftCash, answer;
    static int[] coins;

    public void bfs(int sum) {

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        coins = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        leftCash = Integer.parseInt(br.readLine());


    }
}
