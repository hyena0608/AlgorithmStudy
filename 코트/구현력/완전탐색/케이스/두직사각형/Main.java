package 코트.구현력.완전탐색.케이스.두직사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String OVERLAP = "overlapping";
    static final String NON_OVERLAP = "nonoverlapping";

    static int x1, x2, y1, y2;
    static int a1, a2, b1, b2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());

        if (x2 < a1 || x1 > a2 || y2 < b1 || y1 > b2) {
            System.out.println(NON_OVERLAP);
        } else {
            System.out.println(OVERLAP);
        }
    }
}
