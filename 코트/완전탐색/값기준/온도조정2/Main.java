package 코트.완전탐색.값기준.온도조정2;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 1000;
    final static int MAX_T = 1000;

    static int N, C, G, H;
    static int[] Ta, Tb;

    public static void main(String[] args) throws IOException {

        Ta = new int[MAX_N];
        Tb = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Ta[i] = Integer.parseInt(st.nextToken());
            Tb[i] = Integer.parseInt(st.nextToken());
        }


        int maxWork = 0;
        for (int degree = 0; degree <= MAX_T + 1; degree++) {
            int work = 0;
            for (int i = 0; i < N; i++) {
                if (Ta[i] >  degree) {
                    work += C;
                } else if (Ta[i] <= degree && degree <= Tb[i]) {
                    work += G;
                } else if (Tb[i] < degree) {
                    work += H;
                }
            }

            maxWork = Math.max(maxWork, work);
        }

        System.out.println(maxWork);
    }
}
