package 인프런_자바_알고리즘_문제_기초.연속된자연수의합;

import java.io.*;

public class Main {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 1;
        int rt = 1;
        int halfFloorNum = n / 2 + 1;

        while (lt <= halfFloorNum && rt <= halfFloorNum) {
            if (sum + rt == n) {
                sum += rt;
                answer++;
                rt++;
            } else if (sum + rt < n) {
                sum += rt;
                rt++;
            } else {
                sum -= lt;
                lt++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int answer = T.solution(n);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
