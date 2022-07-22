package 백준.자바_특강.DAY5.암호제작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isNotPrime;
    static int MAX = 1000000;
    static char[] P;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = st.nextToken().toCharArray();
        int K = Integer.parseInt(st.nextToken());

        isNotPrime = new boolean[MAX + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <= MAX; i++) {
            if (isNotPrime[i] == false) {
                primes.add(i);
                for (int j = i * 2; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int prime : primes) {
            if (prime >= K) {
                break;
            }
            if (checkIsBad(prime)) {
                return;
            }
        }
        System.out.println("GOOD");

    }

    static boolean checkIsBad(int x) {
        int ret = 0;
        for (int i = 0; i < P.length; i++) {
            ret = (ret * 10 + (P[i] - '0')) % x;
        }

        if (ret == 0) {
            System.out.println("BAD " + x);
            return true;
        } else {
            return false;
        }
    }
}
