package 백준.자바_특강.DAY2.나무자르기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long answer;
    static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNM.nextToken());
        M = Integer.parseInt(stNM.nextToken());
        trees = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        long start = 0;
        long end = Arrays.stream(trees).max().getAsLong();
        while (true) {
            long mid = (start + end) / 2;
            long temp = 0;
            for (long tree : trees) {
                if (tree > mid) {
                    temp += tree - mid;
                }
            }

            if (temp == M) {
                answer = mid;
                break;
            } else if (temp > M) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (start > end) {
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
