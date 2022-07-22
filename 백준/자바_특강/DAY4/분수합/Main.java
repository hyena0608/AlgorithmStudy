package 백준.자바_특강.DAY4.분수합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[2][2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int a = (arr[0][0] * arr[1][1]) + (arr[1][0] * arr[0][1]);
        int b = arr[0][1] * arr[1][1];
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;

        System.out.println(a + " " + b);
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
