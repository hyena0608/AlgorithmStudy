package 백준.자바.분해합_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            String number = String.valueOf(i);

            int num = i;
            for (int j = 0; j < number.length(); j++) {
                num += number.charAt(j) - '0';
            }

            if (num == N) answer = Math.min(answer, Integer.parseInt(number));
        }
        if (answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}
