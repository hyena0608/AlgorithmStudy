package 백준.자바.보물;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            arrA[j] = Integer.parseInt(stA.nextToken());
        }
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            arrB[j] = Integer.parseInt(stB.nextToken());
        }

        Arrays.sort(arrA);
        int[] sortedarrA = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if (arrB[idx] < arrB[j]) {
                    idx = j + 1;
                }
            }

            if (idx == -1) {
                sortedarrA[0] = arrA[i] * arrB[0];
                System.out.println(arrA[i] + " " + arrB[0]);
            } else {
                System.out.println(arrA[i] + " " + arrB[idx]);

                sortedarrA[i] = arrA[i] * arrB[idx];
                arrB[idx] = -1;
            }
        }

        int answer = Arrays.stream(sortedarrA).sum();

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
