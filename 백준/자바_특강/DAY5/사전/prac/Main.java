package 백준.자바_특강.DAY5.사전.prac;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] combination;
    static int N, M, K;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("백준/자바_특강/DAY5/사전/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        combination = new int[201][201];

        if (K > combination(N + M, M)) {
            System.out.println("-1");
        } else {
            query(N, M, K);
        }
        System.out.println(sb.toString());

    }

    static void query(int n, int m, int k) {
        if (n + m == 0) {
            return;
        } else if (n == 0) {
            sb.append("z");
            query(n, m - 1, k);
        } else if (m == 0) {
            sb.append("a");
            query(n - 1, m, k);
        } else {
            int left = combination(n + m - 1, m);
            if (left >= k) {
                sb.append("a");
                query(n - 1, m, k);
            } else {
                sb.append("z");
                query(n, m - 1, k - left);
            }
        }
    }

    static int combination(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        } else if (combination[n][k] != 0) {
            return combination[n][k];
        } else {
            return combination[n][k] = Math.min((int)1e9, combination(n - 1, k - 1) + combination(n - 1, k));
        }
    }

}
