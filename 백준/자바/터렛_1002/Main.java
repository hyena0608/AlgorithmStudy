package 백준.자바.터렛_1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int INFINITE = -1;
    private static int x1, y1, x2, y2, r1, r2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            int answer = 0;
            double betweenXY = Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2);
            double betweenOuterR = Math.pow(r1 + r2, 2);
            double betweenInnerR = Math.pow(r1 - r2, 2);
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                answer = INFINITE;
            } else if (betweenXY > betweenOuterR) {
                answer = 0;
            } else if (betweenXY < betweenInnerR) {
                answer = 0;
            } else if (betweenXY == betweenOuterR) {
                answer = 1;
            } else if (betweenXY == betweenInnerR) {
                answer = 1;
            } else {
                answer = 2;
            }

            System.out.println(answer);
        }
    }
}
