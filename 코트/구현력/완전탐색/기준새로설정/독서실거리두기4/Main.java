package 코트.구현력.완전탐색.기준새로설정.독서실거리두기4;

import java.io.*;

public class Main {

    final static int MAX_N = 100;

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String seats = br.readLine();

        int maxShortestGap = 0;
        for (int curr = 0; curr < N - 1; curr++) {
            for (int next = curr + 1; next < N; next++) {
                if (seats.charAt(curr) == '1' || seats.charAt(next) == '1') continue;
                seats = seats.substring(0, curr) + '1' + seats.substring(curr + 1, next) + '1' + seats.substring(next + 1, N);

                int shortestGap = MAX_N + 1;
                for (int selectedCurr = 0; selectedCurr < N - 1; selectedCurr++) {
                    for (int selectedNext = selectedCurr + 1; selectedNext < N; selectedNext++) {
                        if (seats.charAt(selectedCurr) == '0' || seats.charAt(selectedNext) == '0') continue;
                        shortestGap = Math.min(shortestGap, Math.abs(selectedNext - selectedCurr));
                    }
                }

                maxShortestGap = Math.max(maxShortestGap, shortestGap);

                seats = seats.substring(0, curr) + '0' + seats.substring(curr + 1, next) + '0' + seats.substring(next + 1, N);
            }
        }

        System.out.println(maxShortestGap);
    }
}
