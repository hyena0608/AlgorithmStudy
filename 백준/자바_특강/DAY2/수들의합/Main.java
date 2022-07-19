package 백준.자바_특강.DAY2.수들의합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNM.nextToken());
        M = Integer.parseInt(stNM.nextToken());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 0;
        int value = arr[low];
        while (true) {
            if (value == M) {
                answer++;
                value -= arr[low++];
            } else if (value < M) {
                if (++high == N) {
                    break;
                }
                value += arr[high];
            } else {
                value -= arr[low++];
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
