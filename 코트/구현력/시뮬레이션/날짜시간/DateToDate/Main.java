package 코트.구현력.시뮬레이션.날짜시간.DateToDate;

import java.io.*;
import java.util.*;

public class Main {

    final static int[] MONTH_DAY = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int month2 = Integer.parseInt(st.nextToken());
        int day2 = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 1; i < month2; i++) {
            answer += MONTH_DAY[i];
        }
        answer += day2;

        for (int i = 0; i < month; i++) {
            answer -= MONTH_DAY[i];
        }
        answer -= day;

        System.out.println((answer + 1));
    }
}
