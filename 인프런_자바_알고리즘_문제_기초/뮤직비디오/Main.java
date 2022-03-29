package 인프런_자바_알고리즘_문제_기초.뮤직비디오;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
public class Main {

    private int count(int arr[], int capacity) {
        int cnt = 1;
        int sum = 0;
        for(int x : arr) {
            if (sum + x > capacity) {
                sum = x;
                cnt++;
            } else {
                sum += x;
            }
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stNM.nextToken());
        int m = Integer.parseInt(stNM.nextToken());

        StringTokenizer stArr = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        int answer = T.solution(n, m, arr);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
