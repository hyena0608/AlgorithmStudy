package 코트.구현력.시뮬레이션.진수.이진수십진수로;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') answer = answer * 2 + 1;
            else answer *= 2;
        }

        System.out.println(answer);
    }
}
