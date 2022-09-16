package 코트.구현력.완전탐색.값기준.흥미로운숫자2;

import java.io.*;
import java.util.*;

public class Main {


    static int X, Y;
    static int[] countArr;

    public static void main(String[] args) throws Exception {
        countArr = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int num = X; num <= Y; num++) {
            Arrays.fill(countArr, 0);
            boolean isInteresting = false;
            char[] chars = String.valueOf(num).toCharArray();
            for (char c : chars) {
                countArr[c - '0']++;
            }

            for (int count : countArr) {
                if (count == chars.length - 1) {
                    isInteresting = true;
                    break;
                }
            }

            if (isInteresting) answer++;
        }

        System.out.println(answer);
    }
}