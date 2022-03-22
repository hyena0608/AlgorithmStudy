package 인프런_자바_알고리즘_문제_기초.연속부분수열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0;
        int sum = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while(sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNK = new StringTokenizer(br.readLine());
        StringTokenizer stArr = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stNK.nextToken());
        int m = Integer.parseInt(stNK.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        int answer = T.solution(n, m, arr);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
