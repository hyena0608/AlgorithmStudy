package 인프런_자바_알고리즘_문제_기초.격자판최대합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[][] arr) {
        int max = 0;
        int cross_tmp = 0;
        int cross_over_tmp = 0;

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            int tmp_opp = 0;
            for (int j = 0; j < n; j++) {
                tmp += arr[i][j];
                tmp_opp += arr[j][i];
                if (i == j) cross_tmp += arr[i][j];
                if (i + j == n - 1) cross_over_tmp += arr[i][j];
            }
            max = Math.max(max, tmp);
            max = Math.max(max, tmp_opp);
        }
        max = Math.max(max, cross_tmp);
        max = Math.max(max, cross_over_tmp);

        return max;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = T.solution(n, arr);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
