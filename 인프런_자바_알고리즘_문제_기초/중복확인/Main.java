package 인프런_자바_알고리즘_문제_기초.중복확인;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @author hyena
 */
public class Main {
    public char solution(int n, int[] arr) {
        IntStream sorted = Arrays.stream(arr).sorted();
        char answer = 'U';
        int tmp = 0;
        for (int i : sorted.toArray()) {
            if (tmp == i) {
                answer = 'D';
                break;
            }
            tmp = i;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(T.solution(n,arr));
        bw.flush();
        bw.close();
        br.close();
    }
}
