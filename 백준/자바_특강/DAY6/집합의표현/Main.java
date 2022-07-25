package 백준.자바_특강.DAY6.집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNM = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stNM.nextToken());
        M = Integer.parseInt(stNM.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (input == 0) {
                union(a, b);
            } else if (input == 1) {
                int aRoot = find(a);
                int bRoot = find(b);
                if (aRoot == bRoot) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        parent[bRoot] = aRoot;
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}
