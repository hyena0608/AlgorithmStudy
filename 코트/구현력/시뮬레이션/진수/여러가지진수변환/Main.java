package 코트.구현력.시뮬레이션.진수.여러가지진수변환;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int value = Integer.parseInt(st.nextToken());
        int jinsu = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (true) {
            if (value < jinsu) break;
            sb.append(value % jinsu);
            value /= jinsu;
        }
        sb.append(value);


        System.out.println(sb.reverse().toString());
    }
}
