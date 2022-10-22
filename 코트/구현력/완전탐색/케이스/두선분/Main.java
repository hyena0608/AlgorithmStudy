package 코트.구현력.완전탐색.케이스.두선분;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String INTERSECTING = "intersecting";
    static final String NON_INTERSECTING = "nonintersecting";
    static int x1, x2, x3, x4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        x3 = Integer.parseInt(st.nextToken());
        x4 = Integer.parseInt(st.nextToken());

        if (x2 < x3 || x4 < x1) {
            System.out.println(NON_INTERSECTING);
        } else {
            System.out.println(INTERSECTING);
        }

    }
}
