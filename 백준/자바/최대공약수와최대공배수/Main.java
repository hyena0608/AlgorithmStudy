package 백준.자바.최대공약수와최대공배수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int larger = Math.max(n, m);
        int firstAnswer = 1;
        for (int i = 1; i <= larger; i++) {
            if (n % i == 0 && m % i == 0) {
                firstAnswer = Math.max(firstAnswer, i);
            }
        }

        for (int i = 1; i <= n * m / firstAnswer / firstAnswer; i++) {
            if (firstAnswer * i % n == 0 && firstAnswer * i % m == 0) {
                System.out.println(firstAnswer);
                System.out.print(firstAnswer * i);
                break;
            }
        }

    }
}
