package 백준.자바_특강.DAY4.캔디분배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // A : 인원수 // x : 인당 사탕 수
            // B : 봉지 당 사탕 개수 // y : 구매할 봉지 수
            // A * x + 1 = B * y
            // 아무리 나눠도 사탕이 한개가 남는 상황 필요
            // 나머지 == 1 이어야 한다.
            // 1. 해 검증
            EGResult result = extendedGcd(A, B);
            if (result.r != 1) {
                System.out.println("IMPOSSIBLE");
            } else {
                // 2. 초기 해
                long x0 = result.s;;
                long y0 = result.t;

                // 3. 일반 해

                // 4. k 범위

                // 5. 만족하는 k가 있는지 화인
                long kFromY = (long) Math.ceil((double) y0 / (double) A) - 1;
                long kFromX = (long) Math.ceil((double) -x0 / (double) B) - 1;
                long k = Math.min(kFromX, kFromY);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) A);
                System.out.println("kLimitFromY = " + kLimitFromY);
                if (kLimitFromY <= k) {
                    System.out.println(y0 - A * k);
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }


    /**
     *  s0                          t0                          r0
     *  s1                          t1                          r1
     *  (s0 - (s1 * r0 / r1))      (t0 - (t1 * r0 / r1))        r0 % r1                 r0 / r1
     */
    static EGResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1; // 목

            // 나머지 == r0 - q * r1 == r0 - 목 * r1
            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        super();
        this.s = s;
        this.t = t;
        this.r = r;
    }


}