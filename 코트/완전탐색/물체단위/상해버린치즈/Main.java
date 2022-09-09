package 코트.완전탐색.물체단위.상해버린치즈;

import java.io.*;
import java.util.*;

/**
 * 치즈.. 하나만.. 상하는 구나..
 */
public class Main {

    final static int MAX_NM_SIZE = 50;
    final static int MAX_D_SIZE = 1000;

    static int N, M, D, S;
    static int[] notSureReportPeople;
    static int[] notSureReportCheeseType;
    static int[] notSureReportEatTime;
    static int[] sureReportPeople;
    static int[] sureReportHurtTime;
    static boolean[] checkCheeseRotArr;
    static boolean[] checkPeopleNeedPill;

    public static void main(String[] args) throws Exception {
        notSureReportPeople = new int[MAX_D_SIZE];
        notSureReportCheeseType = new int[MAX_D_SIZE];
        notSureReportEatTime = new int[MAX_D_SIZE];
        sureReportPeople = new int[MAX_NM_SIZE];
        sureReportHurtTime = new int[MAX_NM_SIZE];
        checkCheeseRotArr = new boolean[MAX_NM_SIZE + 1];
        checkPeopleNeedPill = new boolean[MAX_NM_SIZE + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            notSureReportPeople[i] = Integer.parseInt(st.nextToken());
            notSureReportCheeseType[i] = Integer.parseInt(st.nextToken());
            notSureReportEatTime[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            sureReportPeople[i] = Integer.parseInt(st.nextToken());
            sureReportHurtTime[i] = Integer.parseInt(st.nextToken());
        }

        for (int cheeseType = 1; cheeseType <= M; cheeseType++) {
            boolean isCheeseRot = true;
            boolean isSureReportExist = false;

            for (int idx = 0; idx < D; idx++) {
                if (!isCheeseRot) break;

                if (notSureReportCheeseType[idx] == cheeseType) {
                    int currPerson = notSureReportPeople[idx];
                    int currPersonEatTime = notSureReportEatTime[idx];

                    for (int sureIdx = 0; sureIdx < S; sureIdx++) {
                        if (sureReportPeople[sureIdx] == currPerson) {
                            isSureReportExist = true;
                            if (sureReportHurtTime[sureIdx] <= currPersonEatTime) {
                                isCheeseRot = false;
                                break;
                            }
                        }

                    }
                }

                if (isCheeseRot && isSureReportExist)
                    checkCheeseRotArr[cheeseType] = true;
            }
        }

        int maxCount = 0;
        for (int cheeseType = 1; cheeseType <= M; cheeseType++) {

            boolean checkSureReportIsOk = true;
            for (int sureIdx = 0; sureIdx < S; sureIdx++) {
                boolean isThisCheeseCorrect = false;

                int sickPeopleNumber = sureReportPeople[sureIdx];
                for (int notSureIdx = 0; notSureIdx < D; notSureIdx++) {
                    if (notSureReportPeople[notSureIdx] == sickPeopleNumber
                            && notSureReportCheeseType[notSureIdx] == cheeseType) {

                        isThisCheeseCorrect = true;
                        break;
                    }
                }

                if (!isThisCheeseCorrect) {
                    checkSureReportIsOk = false;
                    break;
                }
            }

            if (!checkSureReportIsOk) continue;

            Arrays.fill(checkPeopleNeedPill, false);
            int count = 0;

            if (checkCheeseRotArr[cheeseType]) {
                for (int idx = 0; idx < D; idx++) {
                    if (notSureReportCheeseType[idx] == cheeseType) {
                        checkPeopleNeedPill[notSureReportPeople[idx]] = true;
                    }
                }
            }

            for (int person = 1; person <= N; person++) {
                if (checkPeopleNeedPill[person]) count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        System.out.print(maxCount);
    }
}