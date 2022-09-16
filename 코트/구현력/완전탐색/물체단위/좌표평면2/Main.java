package 코트.구현력.완전탐색.물체단위.좌표평면2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    final static int MAX_N = 100;
    final static int MAX_XY = 40000;

    static int N;
    static List<int[]> list;

    public static void main(String[] args) throws Exception {
        list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        int minWidth = MAX_XY * MAX_XY;
        for (int excludedIdx = 0; excludedIdx < N; excludedIdx++) {
            int mostLeftX = MAX_XY;
            int mostRightX = 0;
            int mostDownY = MAX_XY;
            int mostUpY = 0;
            for (int idx = 0; idx < N; idx++) {
                if (excludedIdx == idx) continue;
                int[] curr = list.get(idx);
                mostLeftX = Math.min(mostLeftX, curr[0]);
                mostRightX = Math.max(mostRightX, curr[0]);
                mostDownY = Math.min(mostDownY, curr[1]);
                mostUpY = Math.max(mostUpY, curr[1]);
            }

            int row = mostRightX - mostLeftX;
            int col = mostUpY - mostDownY;

            minWidth = Math.min(minWidth, row * col);
        }

        System.out.print(minWidth);
    }
}
