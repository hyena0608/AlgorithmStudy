package 인프런_자바_알고리즘_문제_기초.합이같은부분집합;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
class Main {
    static int n, targetValue;
    static int[] arr;
    static String answer = "NO";
    boolean isExist = false;

    public void dfs(int L, int sum) {
        if (isExist) return;
        if (L == n + 1) {
            if (sum == targetValue) {
                isExist = true;
                answer = "YES";
            }
        } else {
            dfs(L + 1, sum + arr[L]);
            dfs(L + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer sc = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(sc.nextToken());
        }

        if (Arrays.stream(arr).sum() % 2 == 0) {
            targetValue = Arrays.stream(arr).sum() / 2;
            T.dfs(1, 0);
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}