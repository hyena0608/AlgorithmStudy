package 백준.자바_특강.DAY2.게임;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long X, Y, Z;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = (Y * 100 / X);

        long answer = -1;
        if (Z < 99) {
            long start = 0;
            long end = 1000000000;
            while (true) {
                long mid = (start + end) / 2;
                long newZ = ((Y + mid) * 100) / (X + mid);

                if (newZ > Z) {
                    answer = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

                if (end < start) {
                    break;
                }
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
