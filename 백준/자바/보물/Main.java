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
        Arrays.sort(arrB);

        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer += arrA[n - i - 1] * arrB[i];
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
