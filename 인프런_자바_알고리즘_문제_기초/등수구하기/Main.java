package 인프런_자바_알고리즘_문제_기초.등수구하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int[] arr) {
        int[] grade = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) grade[j]++;
                else if (arr[i] < arr[j]) grade[i]++;
            }
        }
        return grade;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = T.solution(n, arr);
        for (int o : answer) {
            bw.write(o + 1 + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
