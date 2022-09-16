package 코트.구현력.완전탐색.자리마다숫자를정하기.개발자의능력2;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_DEV_SIZE = 6;

    static int[] abilityArr;
    static int totalAbility;

    public static void main(String[] args) throws Exception {
        abilityArr = new int[MAX_DEV_SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < MAX_DEV_SIZE; i++) {
            abilityArr[i] = Integer.parseInt(st.nextToken());
            totalAbility += abilityArr[i];
        }

        int minMinus = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_DEV_SIZE; i++) {
            for (int j = 0; j < MAX_DEV_SIZE; j++) {
                for (int k = 0; k < MAX_DEV_SIZE; k++) {
                    for (int l = 0; l < MAX_DEV_SIZE; l++) {
                        if (i == j || i == k || i == l
                                || j == k || j == l || k == l) continue;

                        int team1Sum = abilityArr[i] + abilityArr[j];
                        int team2Sum = abilityArr[k] + abilityArr[l];
                        int team3Sum = totalAbility - team1Sum - team2Sum;

                        int teamMaxSum = Math.max(Math.max(team1Sum, team2Sum), team3Sum);
                        int teamMinSum = Math.min(Math.min(team1Sum, team2Sum), team3Sum);

                        minMinus = Math.min(minMinus, teamMaxSum - teamMinSum);
                    }
                }
            }
        }

        System.out.print(minMinus);
    }
}
