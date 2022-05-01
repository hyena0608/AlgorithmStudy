package 백준.자바.소수구하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] argd) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] answer = new int[end + 1];
        for (int i = 2; i <= end; i++) answer[i] = i;

        for (int num = 2; num <= end; num++) {
            if (answer[num] == 0) continue;
            else {
                for (int i = num * 2; i <= end; i += num) answer[i] = 0;
            }
        }

        for (int i = start; i <= end; i++) {
            if (answer[i] != 0) bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
