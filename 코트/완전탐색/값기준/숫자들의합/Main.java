package 코트.완전탐색.값기준.숫자들의합;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int maxSum = 0;
        for (int value = a; value <= b; value++) {
            int num = 0;
            for (int i = 1; i <= 10000; i *= 10) {
                num += (value / i) % 10;
            }
            maxSum = Math.max(maxSum, num);
        }

        System.out.print(maxSum);
    }
}
