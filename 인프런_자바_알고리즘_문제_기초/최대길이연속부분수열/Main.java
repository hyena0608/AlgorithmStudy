package 인프런_자바_알고리즘_문제_기초.최대길이연속부분수열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;
            while (cnt > m) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        int n = 0;
        int m = 0;
        int[] arr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stNM.nextToken());
        m = Integer.parseInt(stNM.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = T.solution(n, m, arr);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
