package 코트.완전탐색.상황가정.수를여러번사용하여특정수;

import java.io.*;
import java.util.*;

public class Main {

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int maxValue = 0;
        for (int cntA = 0; cntA * A <= C; cntA++) {
            int currA = cntA * A;
            int currB = ((C - currA) / B) * B;

            maxValue = Math.max(maxValue, currA + currB);
        }

        System.out.println(maxValue);
    }
}
