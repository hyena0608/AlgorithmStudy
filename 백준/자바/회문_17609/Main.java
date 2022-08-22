package 백준.자바.회문_17609;

import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("백준/자바/회문_17609/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            char[] str2 = new char[str.length];

            int count = 0;
            for (int j = str.length - 1; j >= 0; j--) {
                str2[j] = str[count++];
            }

            int p1 = 0;
            int p2 = 0;
            int deleteCount = 0;

            boolean UYOUNGU = true;
            while (true) {

                if (p1 >= str.length || p2 >= str.length) {
                    break;
                }
                if (str[p1] == ' ') {
                    p1++;
                    continue;
                } else if (str2[p2] == ' ') {
                    p2++;
                    continue;
                }

                if (str[p1] == str2[p2]) {
                    p1++;
                    p2++;
                } else {
                    if (str[p1 + 1] == str2[p2]) {
                        p1++;
                        deleteCount++;
                        str2[str.length - p1] = ' ';
                    } else if (str2[p2 + 1] == str[p1]) {
                        p2++;
                        deleteCount++;
                        str[str.length - p2] = ' ';
                    } else {
                        UYOUNGU = false;
                    }
                }


                if (deleteCount >= 2) {
                    UYOUNGU = false;
                    break;
                }

                if (UYOUNGU == false) {
                    break;
                }
            }

            if (UYOUNGU && deleteCount == 0) {
                System.out.println(0);
            } else if (UYOUNGU && deleteCount == 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }

        }
    }
}
