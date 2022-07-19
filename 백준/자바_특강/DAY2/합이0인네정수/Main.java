package 백준.자바_특강.DAY2.합이0인네정수;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] A, B, C, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new long[N];
        B = new long[N];
        C = new long[N];
        D = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        List<Long> subAB = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                subAB.add(A[i] + B[j]);
            }
        }

        List<Long> subCD = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                subCD.add(C[i] + D[j]);
            }
        }

        Collections.sort(subAB);
        Collections.sort(subCD, Collections.reverseOrder());

        int count = 0;
        int left = 0;
        int right = 0;
        while (true) {

            long value = subAB.get(left) + subCD.get(right);

            if (value == 0) {
                count++;
                right++;
            } else if (value > 0) {
                right++;
            } else {
                left++;
            }

            if (right == subCD.size()) {
                break;
            }

            if (left == subAB.size()) {
                break;
            }
        }


        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
