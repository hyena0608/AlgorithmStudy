package 코트.구현력.완전탐색.자리마다숫자를정하기.물체하나를정하여완전탐색;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 100;
    final static int MAX_LOCKER_SIZE = 3;

    static int N;
    static int[] A, B;

    public static void main(String[] args) throws Exception {

        A = new int[MAX_LOCKER_SIZE];
        B = new int[MAX_LOCKER_SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < MAX_LOCKER_SIZE; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < MAX_LOCKER_SIZE; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (getDistance(A[0], i) <= 2
                            && getDistance(A[1], j) <= 2
                            && getDistance(A[2], k) <= 2) count++;
                    else if (getDistance(B[0], i) <= 2
                            && getDistance(B[1], j) <= 2
                            && getDistance(B[2], k) <= 2) count++;
                }
            }
        }

        System.out.print(count);
    }

    static int getDistance(int compareNumber, int currNumber) {
        int toLeftCount = Math.min(
                Math.abs(currNumber + N - compareNumber),
                Math.abs(compareNumber - currNumber));
        int toRightCount = Math.min(
                Math.abs(compareNumber - currNumber),
                Math.abs(N - currNumber + compareNumber));

        return toLeftCount > toRightCount ? toRightCount : toLeftCount;
    }
}