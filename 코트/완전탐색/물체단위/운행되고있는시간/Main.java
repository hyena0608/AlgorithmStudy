package 코트.완전탐색.물체단위.운행되고있는시간;

import java.io.*;
import java.util.*;

public class Main {
    final static int MAX_TIME = 1000;

    static int N;
    static int[] startArr;
    static int[] endArr;
    static boolean[] workingOnTable;

    public static void main(String[] args) throws Exception {
        startArr = new int[MAX_TIME + 1];
        endArr = new int[MAX_TIME + 1];
        workingOnTable = new boolean[MAX_TIME + 1];


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            startArr[i] = Integer.parseInt(st.nextToken());
            endArr[i] = Integer.parseInt(st.nextToken());
        }

        int maxWorkingOnTime = 0;
        for (int firedMan = 1; firedMan <= N; firedMan++) {
            int workingOnTime = 0;
            Arrays.fill(workingOnTable, false);

            for (int devMan = 1; devMan <= N; devMan++) {
                if (firedMan == devMan) continue;

                for (int time = startArr[devMan] + 1; time <= endArr[devMan]; time++) {
                    if (workingOnTable[time]) continue;
                    workingOnTable[time] = true;
                    workingOnTime++;
                }
            }

            maxWorkingOnTime = Math.max(maxWorkingOnTime, workingOnTime);
        }

        System.out.print(maxWorkingOnTime);
    }
}
