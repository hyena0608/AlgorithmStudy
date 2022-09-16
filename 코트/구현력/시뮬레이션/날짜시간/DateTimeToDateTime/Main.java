package 코트.구현력.시뮬레이션.날짜시간.DateTimeToDateTime;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int diff = (day * 24 * 60 + hour * 60 + minute) - (11 * 24 * 60 + 11 * 60 + 11);

        System.out.println(diff < 0 ? -1 : diff);
    }
}
