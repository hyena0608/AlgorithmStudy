package 인프런_자바_알고리즘_문제_기초.멘토링;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int a = 0;
                    int b = 0;
                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i) a = l;
                        if (arr[k][l] == j) b = l;
                    }
                    if (a < b) cnt++;
                }
                if (cnt == m) answer++;
            }
        }
        return answer;
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
        n = nm[0];
        m = nm[1];

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            StringTokenizer sto = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(sto.nextToken());
            }
        }

        int answer = T.solution(n, m, arr);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
