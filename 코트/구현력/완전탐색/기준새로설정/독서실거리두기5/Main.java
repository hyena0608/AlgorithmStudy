package 코트.구현력.완전탐색.기준새로설정.독서실거리두기5;

import java.io.*;

public class Main {

    final static char SEAT_TRUE = '1';
    final static char SEAT_FALSE = '0';
    final static int MAX_DISTANCE = 20;

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[] seats = br.readLine().toCharArray();

        int answer = -1;
        for (int selectIdx = 0; selectIdx < N; selectIdx++) {
            if (seats[selectIdx] == SEAT_TRUE) continue;

            seats[selectIdx] = SEAT_TRUE;
            int minGap = MAX_DISTANCE;
            for (int curr = 0; curr < N; curr++) {
                for (int next = curr + 1; next < N; next++) {
                    if (seats[curr] == SEAT_TRUE && seats[next] == SEAT_TRUE) {
                        minGap = Math.min(minGap, next - curr);
                    }
                }
            }
            answer = Math.max(answer, minGap);
            seats[selectIdx] = SEAT_FALSE;
        }

        System.out.println(answer);
    }
}
