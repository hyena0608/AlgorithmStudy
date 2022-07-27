package 백준.자바_특강.DAY8.교수님은기다리지않는다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N = -1, M = -1, S;
    static int[] parent;
    static List<Route> adj[];
    static long[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        // 교수님 납셨다
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adj = new ArrayList[N + 1];
            value = new long[N + 1];

            if (N == 0 && M == 0) break;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String inputCase = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (inputCase.equals("!")) {
                    int c = Integer.parseInt(st.nextToken());
                    adj[a].add(new Route(a, b, c));

                } else {
                    if (find(a) == find(b)) {

                    } else {
                        sb.append("UNKNOWN\n");
                    }
                }
            }


        }

    }




    // 조상을 찾는다.
    static int find(int a) {
        if (parent[a] == a) return a;
        else {
            int pid = find(parent[a]);
            value[a] += value[pid];

            return parent[a] = pid;
        }
    }

    // 같은 조상을 바라보게 한다
    static void union(int a, int b, int diff) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return;
        }

        value[aRoot] =


        parent[bRoot] = aRoot;
    }
}

class Route {
    int a, b;
    long c;

    public Route(int a, int b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}