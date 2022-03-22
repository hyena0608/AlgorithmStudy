package 인프런_자바_알고리즘_문제_기초.최대매출;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
                int tmp = 0;
                for (int j = i; j < i + k; j++) {
                    tmp += arr[j];
                }
            if (answer < tmp) answer = tmp;
        }
        return answer;
    }

    public static void main(String args[]) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNK = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stNK.nextToken());
        int k = Integer.parseInt(stNK.nextToken());


        StringTokenizer stArr = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        int answer = T.solution(n, k, arr);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
