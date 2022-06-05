package 백준.자바.환상의짝궁;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Long> sosuList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makeSosuList(2000001);

        Long n = Long.parseLong(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            isDivideCanBeSosu(Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void isDivideCanBeSosu(Long num) throws IOException {

        if (num < 4) {
            bw.write("NO\n");
            return;
        } else if (num % 2 == 0) {
            bw.write("YES\n");
            return;
        } else {
            long sqrtNum = (long) Math.sqrt(num - 2);
            for (Long sosu : sosuList) {
                if ((num - 2) % sosu == 0) {
                    bw.write("NO\n");
                    return;
                }
                if (sqrtNum < sosu) {
                    bw.write("YES\n");
                    return;
                }
            }
            bw.write("YES\n");
            return;
        }
    }

    private static void makeSosuList(int num) {
        sosuList.add(2L);
        for (Long i = 3L; i <= num; i += 2) {
            if (isSosu(i)) {
                sosuList.add(i);
            }
        }
    }

    private static boolean isSosu(Long num) {
        int sqrtNum = (int) Math.sqrt(num);
        for (Long sosu : sosuList) {
            if (num % sosu == 0) {
                return false;
            }
            if (sosu > sqrtNum) {
                return true;
            }
        }
        return true;
    }

}
