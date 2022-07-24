package 백준.자바_특강.DAY5.암호제작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

    static List<Integer> primes;
    static boolean[] isNotPrime;
    static char[] P;
    static int K;
    static int r;
    static int MAX = 1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        primes = new ArrayList<>();
        isNotPrime = new boolean[MAX + 1];
        makePrime();

        if (isBad()) {
            System.out.println("BAD " + r);
        } else {
            System.out.println("GOOD");
        }


    }

    static boolean isBad() {
        for (int prime : primes) {
            if (prime >= K) {
                break;
            }

            int sum = 0;
            for (int i = 0; i < P.length; i++) {
                sum = ((sum * 10) + (P[i] - '0')) % prime;
            }
            if (sum == 0) {
                r = prime;
                return true;
            }
        }
        return false;
    }

    static void makePrime() {
        for (int i = 2; i <= MAX; i++) {
            if (isNotPrime[i] == false) {
                primes.add(i);
                for (int j = i * 2; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
