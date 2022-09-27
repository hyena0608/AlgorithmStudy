package 코트.구현력.완전탐색.기준새로설정.초기수열복원하기;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 1000;

    static int N;
    static int[] arr;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1];
        answer = new int[MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int curr = 1; curr <= N; curr++) {
            Arrays.fill(answer, 0);
            answer[0] = curr;

            for (int next = 1; next < N; next++) {
                answer[next] = arr[next - 1] - answer[next - 1] ;
            }

            boolean isPossible = true;
            boolean[] exists = new boolean[MAX_N + 1];
            for (int idx = 0; idx < N - 1; idx++) {
                if (0 >= answer[idx] || answer[idx] > N || exists[answer[idx]]) {
                    isPossible = false;
                    break;
                }
                exists[answer[idx]] = true;
            }

            if (isPossible) break;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
