package 인프런_자바_알고리즘_문제_기초.이분검색;

import java.io.*;
import java.util.*;

/**
 * @author hyena
 */
public class Main {

    public int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int lt = 0;
        int rt = n - 1;
        int mid = 0;
        while(arr[mid] != m) {
            mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                break;
            } else if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return mid + 1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stNM.nextToken());
        int m = Integer.parseInt(stNM.nextToken());

        int[] arr = new int[n];
        StringTokenizer stArr = new StringTokenizer(br.readLine());
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
