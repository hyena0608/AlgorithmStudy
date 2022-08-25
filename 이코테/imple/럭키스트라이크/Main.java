package 이코테.imple.럭키스트라이크;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int halfLength = str.length() / 2;

        char[] left = str.substring(0, halfLength).toCharArray();
        char[] right = str.substring(halfLength, halfLength * 2).toCharArray();

        int sum = 0;
        for (int i = 0; i < halfLength; i++) {
            sum += left[i] - right[i];
        }

        if (sum == 0) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
