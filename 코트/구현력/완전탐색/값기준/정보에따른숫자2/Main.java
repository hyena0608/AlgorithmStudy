package 코트.구현력.완전탐색.값기준.정보에따른숫자2;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_S = 1000;
    final static int MAX_N = 1000;

    static int T, A, B;
    static boolean[] S;
    static boolean[] N;

    public static void main(String[] args) throws IOException {
        S = new boolean[MAX_S + 1];
        N = new boolean[MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            char type = st.nextToken().charAt(0);
            if (type == 'S') S[Integer.parseInt(st.nextToken())] = true;
            else if (type == 'N') N[Integer.parseInt(st.nextToken())] = true;
        }

        int count = 0;
        for (int value = A; value <= B; value++) {
            int sIdx = -1;
            int nIdx = -1;

            for (int move = 0; move <= MAX_S; move++) {
                if (sIdx == -1 && isRange(value - move) && S[value - move]) sIdx = move;
                if (sIdx == -1 && isRange(value + move) && S[value + move]) sIdx = move;
                if (nIdx == -1 && isRange(value - move) && N[value - move]) nIdx = move;
                if (nIdx == -1 && isRange(value + move) && N[value + move]) nIdx = move;

                if (sIdx != -1 && nIdx != -1) break;
            }

            if (nIdx >= sIdx) count++;
        }

        System.out.println(count);
    }

    static boolean isRange(int idx) {
        return (1 <= idx && idx <= MAX_S);
    }
}
