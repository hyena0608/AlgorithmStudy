package 코트.구현력.시뮬레이션.날짜시간.TimeToTime;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int targetHour = Integer.parseInt(st.nextToken());
        int targetMinute = Integer.parseInt(st.nextToken());

        System.out.println(((targetHour - hour) * 60 + targetMinute - minute));
    }
}
