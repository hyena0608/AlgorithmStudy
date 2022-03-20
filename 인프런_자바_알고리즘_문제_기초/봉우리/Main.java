package 인프런_자바_알고리즘_문제_기초.봉우리;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private boolean isMax(int i, int j, int[][] arr) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            if (arr[i][j] <= arr[i + dx[k]][j + dy[k]]) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                boolean isTrue = isMax(i, j, arr);
                if (isTrue) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()) + 2;

        int[][] arr = new int[n][n];
        for (int i = 1; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n - 1; j++) {
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
