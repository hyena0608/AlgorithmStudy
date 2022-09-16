package 코트.구현력.시뮬레이션.날짜시간.요일맞추기;

import java.io.*;
import java.util.*;

public class Main {

    final static int[] MONTH_DAY = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int days = d2;
        int antiDays = d1;
        for (int i = 1; i < m1; i++) {
            antiDays += MONTH_DAY[i];
        }
        for (int i = 1; i < m2; i++) {
            days += MONTH_DAY[i];
        }

        int day = days - antiDays;
        int countLastDays = day >= 0 ? day % 7 : 7 - Math.abs(day) % 7;
        String answer = "";

        if (countLastDays == 0) answer = "Mon";
        else if (countLastDays == 1) answer = "Tue";
        else if (countLastDays == 2) answer = "Wed"; // Sun
        else if (countLastDays == 3) answer = "Thu"; // Sat
        else if (countLastDays == 4) answer = "Fri"; // Wed
        else if (countLastDays == 5) answer = "Sat";
        else if (countLastDays == 6) answer = "Sun";
        System.out.println(answer);
    }
}
