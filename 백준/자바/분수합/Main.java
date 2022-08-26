package 백준.자바.분수합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int up1, down1, up2, down2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        up1 = Integer.parseInt(st.nextToken());
        down1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        up2 = Integer.parseInt(st.nextToken());
        down2 = Integer.parseInt(st.nextToken());

        int up = (up1 * down2) + (up2 * down1);
        int down = down1 * down2;
        int gcd = gcd(up, down);
        up /= gcd;
        down /= gcd;
        System.out.print(up + " " + down);
    }

    static int gcd(int a, int b) {
        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }

        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
