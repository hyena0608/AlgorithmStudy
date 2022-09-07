package 코트.완전탐색.물체단위.스승의은혜2;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 1000;
    final static int HALF_COUPON = 2;

    static int N, B;
    static int[] presents;

    public static void main(String[] args) throws Exception {
        presents = new int[MAX_N];
        Arrays.fill(presents, Integer.MAX_VALUE);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            presents[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(presents);

        int count = 0;
        int priceSum = 0;
        boolean isCouponUsed = false;
        for (int i = 0; i < N; i++) {
            if (!isCouponUsed
                    && (i == 0 && (priceSum + presents[i] >= B))
                    || (i != 0 && (priceSum +  presents[i] >= B))) {
                presents[i] /= HALF_COUPON;
                isCouponUsed = true;
            }

            if (priceSum + presents[i] <= B) {
                priceSum += presents[i];
                count++;
            }
        }

        System.out.print(count);
    }
}