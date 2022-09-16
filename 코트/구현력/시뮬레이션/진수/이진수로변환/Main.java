package 코트.구현력.시뮬레이션.진수.이진수로변환;

import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (N != 1 && N != 0) {
            sb.append(N % 2);
            N /= 2;
        }
        sb.append(N);

        System.out.println(sb.reverse().toString());
    }
}
