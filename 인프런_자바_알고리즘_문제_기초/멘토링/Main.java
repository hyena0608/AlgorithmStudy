package 인프런_자바_알고리즘_문제_기초.멘토링;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

            }
        }
        return 1;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nm = new int[2];
        int n;
        int m;

        for (int i = 0; i < 2; i++) {
            nm[i] = Integer.parseInt(st.nextToken());
        }
        n = nm[1];
        m = nm[0];

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer sto = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(sto.nextToken());
            }
        }

        int answer = T.solution(n, m, arr);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
