package 인프런_자바_알고리즘_문제_기초.미로탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
public class Main {
    static int[][] miro = new int[7][7];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public void dfs(int col, int row) {
        if (col == 6 && row == 6) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                if (col + dy[i] < 7 && col + dy[i] >= 0
                        && row + dx[i] < 7 && row + dx[i] >= 0) {

                    if (miro[col + dy[i]][row + dx[i]] == 0) {
                        miro[col + dy[i]][row + dx[i]] = 1;
                        dfs(col + dy[i], row + dx[i]);
                        miro[col + dy[i]][row + dx[i]] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        miro[0][0] = 1;
        T.dfs(0, 0);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
