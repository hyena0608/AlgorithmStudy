package 코트.완전탐색.자리마다숫자를정하기.숫자카운트;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_SIZE = 3;

    static int N;
    static List<int[]> list;

    public static void main(String[] args) throws Exception{
        list = new ArrayList<>();
        for (int[] arrB : list) {
            arrB = new int[3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int count1 = Integer.parseInt(st.nextToken());
            int count2 = Integer.parseInt(st.nextToken());

            list.add(new int[]{number, count1, count2});
        }

        int count = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || i == k || j == k) continue;

                    int currNumber = i * 100 + j * 10 + k;
                    boolean isPossible = true;
                    for (int[] B : list) {
                        isPossible = checkBpossible(currNumber, B);
                        if (!isPossible) break;
                    }

                    if (isPossible) count++;
                }
            }
        }

        System.out.print(count);
    }

    static boolean checkBpossible(int currNumber, int[] B) {
        int count1 = 0;
        int count2 = 0;

        char[] AnumberArr = String.valueOf(currNumber).toCharArray();
        char[] BnumberArr = String.valueOf(B[0]).toCharArray();

        for (int idx = 0; idx < MAX_SIZE; idx++) {
            if (AnumberArr[idx] == BnumberArr[idx]) {
                count1++;
            } else {
                for(int searchIdx = 0; searchIdx < MAX_SIZE; searchIdx++) {
                    if (AnumberArr[idx] == BnumberArr[searchIdx]) {
                        count2++;
                    }
                }
            }
        }

        if (B[1] == count1 && B[2] == count2) return true;
        else return false;
    }
}