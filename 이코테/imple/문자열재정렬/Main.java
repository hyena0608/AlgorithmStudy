package 이코테.imple.문자열재정렬;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[] chars;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("이코테/imple/문자열재정렬/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        chars = br.readLine().toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        int number = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (Character.isAlphabetic(chars[i])) sb.append(chars[i]);
            else number += chars[i] - '0';
        }
        sb.append(number);

        System.out.println(sb.toString());
    }
}
