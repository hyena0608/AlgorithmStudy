package 인프런_자바_알고리즘_문제_기초.점수계산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;
        for (int i : arr) {
            if (i == 1) {
                cnt++;
                answer += cnt;
            } else cnt = 0;
        }
        return answer;
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

        int answer = T.solution(n, arr);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
