package 백준.자바_특강.DAY3.사탕상자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int S;
    static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = 1;
        while (S < 1000000) {
            S *= 2;
        }
        trees = new long[S * 2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                // 사탕 꺼내기
                int B = Integer.parseInt(st.nextToken());
                long flavor = query(1, S, 1, B);
                System.out.println(flavor);
                update(1, S, 1, (int) flavor, -1);
            } else {
                // 사탕 더하기
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                update(1, S, 1, B, C);
            }
        }
    }

    static long query(int left, int right, int node, long target) {
        // 탈출
        if (left == right) return left;

        // target을 검색
        int mid = (left + right) / 2;
        //
        if (trees[node * 2] >= target) {
            return query(left, mid, node * 2, target);
        } else {
            return query(mid + 1, right, node * 2 + 1, target - trees[node * 2]);
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (target < left || target > right) {
            return;
        } else {
            trees[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}
