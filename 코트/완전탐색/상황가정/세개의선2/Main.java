package 코트.완전탐색.상황가정.세개의선2;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 20;
    final static int MAX_XY_LOC = 10;

    static int N;
    static int[] y, x;
    static int[][] threeLines;


    public static void main(String[] args) throws IOException {
        y = new int[MAX_N];
        x = new int[MAX_N];
        threeLines = new int[2][3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        boolean threeLineWorks = false;
        outer:
        for (int a = 0; a <= MAX_XY_LOC; a++) {
            for (int b = 0; b <= MAX_XY_LOC; b++) {
                for (int c = 0; c <= MAX_XY_LOC; c++) {

                    for (int typeA = 0; typeA <= 1; typeA++) {
                        for (int typeB = 0; typeB <= 1; typeB++) {
                            for (int typeC = 0; typeC <= 1; typeC++) {

                                for (int threeLineType = 0; threeLineType <= 1; threeLineType++) {
                                    Arrays.fill(threeLines[threeLineType], -1);
                                }

                                if (typeA == 0) threeLines[0][0] = a;
                                if (typeA == 1) threeLines[1][0] = a;

                                if (typeB == 0) threeLines[0][1] = b;
                                if (typeB == 1) threeLines[1][1] = b;

                                if (typeC == 0) threeLines[0][2] = c;
                                if (typeC == 1) threeLines[1][2] = c;

                                int count = 0;
                                for (int curr = 0; curr < N; curr++) {
                                    for (int lineIdx = 0; lineIdx <= 2; lineIdx++) {
                                        if (threeLines[0][lineIdx] == x[curr] || threeLines[1][lineIdx] == y[curr]) {
                                            count++;
                                            break;
                                        }
                                    }
                                }

                                if (count == N) {
                                    threeLineWorks = true;
                                    break outer;
                                }
                            }
                        }
                    }

                }
            }
        }

        System.out.println(threeLineWorks ? 1 : 0);

    }
}
