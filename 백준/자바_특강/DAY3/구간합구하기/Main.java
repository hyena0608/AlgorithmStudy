package 백준.자바_특강.DAY3.구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stNMk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNMk.nextToken());
        M = Integer.parseInt(stNMk.nextToken());
        K = Integer.parseInt(stNMk.nextToken());

        nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[S * 2];

        initBU();

        for (int i = 0; i < M + K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - tree[(int) (S + b - 1)];
                update(1, S, 1, b, diff);
            } else if (a == 2) {
                System.out.println(query(1, S, 1, b, c));
            }
        }

    }

    static void initBU() {
        // Left에 주어진 값을 반영한다.
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        // 내부 노드를 채워준다.
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, long queryLeft, long queryRight) {
        // 연관이 없다 -> 결과에 영향이 없는 값을 return
        if (queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값을 return
        else if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 판단 불가 -> 자식에게 위임한다, 자식에서 올라온 합을 return한다
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            long resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }

    static void update(int left, int right, int node, long target, long diff) {
        // 연관 없음
        if (target < left || right < target) {
            return;
        }
        // 연관 있음 -> 현재 노드에 diff를 반영 -> 자식에게 diff 전달
        else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}
