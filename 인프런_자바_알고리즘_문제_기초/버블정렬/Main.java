package 인프런_자바_알고리즘_문제_기초.버블정렬;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
public class Main {
    public int[] solution(int n, int[] arr) {
        for (int j = 0; j < n - 1; j++) {
            int tmp = 0;
            for (int i = 0; i < n - j - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        return arr;
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

        int[] answer = T.solution(n, arr);
        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
