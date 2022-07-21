package 백준.자바_특강.DAY4.최대공약수하나빼기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;
    static int[] gcdLToR;
    static int[] gcdRToL;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        gcdLToR = new int[N];
        gcdRToL = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        gcdLToR[0] = nums[0];
        for (int i = 1; i < N; i++) {
            gcdLToR[i] = gcd(gcdLToR[i - 1], nums[i]);
        }

        gcdRToL[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            gcdRToL[i] = gcd(gcdRToL[i + 1], nums[i]);
        }

        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            if (i == 0) {
                gcd = gcdRToL[1];
            } else if (i == N - 1) {
                gcd = gcdLToR[N - 2];
            } else {
                gcd = gcd(gcdLToR[i - 1], gcdRToL[i + 1]);
            }

            if (nums[i] % gcd != 0 && max < gcd) {
                max = gcd;
                maxIndex = i;
            }
        }

        if (maxIndex == -1) {
            System.out.println(-1);
        } else {
            System.out.println(max + " " + nums[maxIndex]);
        }


    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
