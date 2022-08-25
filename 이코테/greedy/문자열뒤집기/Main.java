package 이코테.greedy.문자열뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] chars;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        chars = br.readLine().toCharArray();

        int oneCount = 0;
        int zeroCount = 0;

        char curr = chars[0];
        if (curr == '1') oneCount++;
        else zeroCount++;

        for (char c : chars) {
            if (curr != c) {
                if (c == '1') oneCount++;
                else if (c == '0') zeroCount++;
                curr = c;
            }
        }

        System.out.println(Math.min(oneCount, zeroCount));
    }
}
