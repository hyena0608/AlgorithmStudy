package 인프런_자바_알고리즘_문제_기초.공통원소;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public List<Integer> solution(int n, int m, int[] arrN, int[] arrM) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(arrN);
        Arrays.sort(arrM);

        while (p1 < n && p2 < m) {
            if (arrN[p1] == arrM[p2]) {
                answer.add(arrN[p1]);
                p1++;
                p2++;
            } else if (arrN[p1] < arrM[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];
        StringTokenizer stN = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(stN.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m];
        StringTokenizer stM = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(stM.nextToken());
        }

        List<Integer> answer = T.solution(n, m, arrN, arrM);
        for (Integer o : answer) {
            bw.write(o + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
