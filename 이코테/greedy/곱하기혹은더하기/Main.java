package 이코테.greedy.곱하기혹은더하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String str;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("이코테/greedy/곱하기혹은더하기/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int answer = 0;
        for (char c : str.toCharArray()) {
            int curr = c - '0';

            if (curr == 0 || answer == 0) {
                answer += curr;
                continue;
            }

            if (curr == 1) {
                answer += curr;
            } else {
                answer *= curr;
            }

        }

        System.out.println(answer);
    }
}
