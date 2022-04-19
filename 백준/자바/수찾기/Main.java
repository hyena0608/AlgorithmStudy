package 백준.자바.수찾기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int m, int[] arrA, int[] arrB) {
        int[] answer = new int[m];

        Arrays.sort(arrA);

        for (int i = 0; i < m; i++) {
            if (binarySearch(arrB[i], arrA)) answer[i] = 1;

        }

        return answer;
    }

    public boolean binarySearch(int key, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > key) {
                right = mid - 1;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return arr[mid] == key;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(stA.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(stB.nextToken());
        }

        int[] answer = T.solution(n, m, arrA, arrB);
        for (int i : answer) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
