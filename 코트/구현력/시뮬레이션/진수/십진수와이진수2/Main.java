package 코트.구현력.시뮬레이션.진수.십진수와이진수2;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int value = 0;
        for (char c : chars) {
            if (c == '1') value = value * 2 + 1;
            else value *= 2;
        }

        value *= 17;
        StringBuilder sb = new StringBuilder();
        while (value != 0 && value != 1) {
            sb.append(value % 2);
            value /= 2;
        }
        sb.append(value);

        System.out.println(sb.reverse().toString());
    }
}
