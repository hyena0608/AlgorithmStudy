package 인프런_자바_알고리즘_문제_기초.최대점수구하기;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
public class Main {
    static int N, M, answer;
    static int[] score, time;

    public void dfs(int L, int scoreSum, int timeSum) {
        if (timeSum > M) return;
        if (L == N) {
            answer = Math.max(scoreSum, answer);
        } else {
            dfs(L + 1, scoreSum + score[L], timeSum + time[L]);
            dfs(L + 1, scoreSum, timeSum);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        score = new int[N];
        time = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stProblem = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(stProblem.nextToken());
            time[i] = Integer.parseInt(stProblem.nextToken());
        }

        T.dfs(0, 0, 0);
        System.out.println(answer);
    }
}
