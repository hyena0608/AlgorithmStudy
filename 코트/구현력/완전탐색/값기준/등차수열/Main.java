package 코트.구현력.완전탐색.값기준.등차수열;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 100;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxK = 0;
        for (int k = 1; k <= 100; k++) {
            int count = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (arr[i] == arr[j]) continue;
                    if (arr[j] - k == k - arr[i]) {
                        count++;
                    }
                }
            }
            
            maxK = Math.max(maxK, count);
        }

        System.out.println(maxK);
    }
}
