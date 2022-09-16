package 코트.구현력.완전탐색.상황가정.좌표평면위의균형2;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_X = 100;
    final static int MAX_Y = 100;
    final static int SIDE_TYPE_SIZE = 4;

    static int N;
    static boolean[][] map;
    static int[] counts;

    public static void main(String[] args) throws Exception {
        map = new boolean[MAX_Y + 1][MAX_Y + 1];
        counts = new int[SIDE_TYPE_SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int x;
        int y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[y][x] = true;
        }

        int minValue = Integer.MAX_VALUE;
        for (int lineY = 0; lineY <= MAX_Y; lineY += 2) {
            for (int lineX = 0; lineX <= MAX_X; lineX += 2) {
                Arrays.fill(counts, 0);
                for (int currY = 1; currY <= MAX_Y; currY++) {
                    for (int currX = 1; currX <= MAX_X; currX++) {
                        if (!map[currY][currX]) continue;

                        if (currY > lineY && currX < lineX) {
                            counts[0]++;
                        } else if (currY > lineY && currX > lineX) {
                            counts[1]++;
                        } else if (currY < lineY && currX > lineX) {
                            counts[2]++;
                        } else if (currY < lineY && currX < lineX) {
                            counts[3]++;
                        }

                    }
                }

                minValue = Math.min(minValue, Arrays.stream(counts).max().getAsInt());
            }
        }

        System.out.println(minValue);
    }
}
