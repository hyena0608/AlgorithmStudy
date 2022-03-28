package 인프런_자바_알고리즘_문제_기초.LRU;

import java.io.*;
import java.util.*;

/**
 * @author hyena
 */
public class Main {
    public int[] solution(int maxSize, int arrSize, int[] arr) {
        int[] memory = new int[maxSize];

        for (int i = 0; i < arrSize; i++) {
            int alreadyExistIdx = -1;
            for (int findIdx = 0; findIdx < maxSize; findIdx++) {
                if (arr[i] == memory[findIdx]) {
                    alreadyExistIdx = findIdx;
                    break;
                }
            }

            if (alreadyExistIdx != -1) {
                for (int tmpIdx = alreadyExistIdx; tmpIdx >= 1; tmpIdx--) {
                    memory[tmpIdx] = memory[tmpIdx - 1];
                }
            } else {
                for (int tmpIdx = maxSize - 1; tmpIdx >= 1; tmpIdx--) {
                    memory[tmpIdx] = memory[tmpIdx - 1];
                }
            }
            memory[0] = arr[i];
        }
        return memory;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer stArr = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        int[] answers = T.solution(n, m, arr);
        for (int i : answers) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}