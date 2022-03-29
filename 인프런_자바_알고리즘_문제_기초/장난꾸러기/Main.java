package 인프런_자바_알고리즘_문제_기초.장난꾸러기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @author hyena
 */
public class Main {
    public int[] solution(int n, int[] arr) {
        IntStream sorted = Arrays.stream(arr).sorted();
        int[] sortedArr = sorted.toArray();

        int cnt = 0;
        int[] answer = new int[2];
        for (int i = 0; i < n; i++) {
            if (sortedArr[i] != arr[i]) answer[cnt++] = i + 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answers = T.solution(n, arr);
        for (int answer : answers) {
            bw.write(answer + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
