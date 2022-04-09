package 프로그래머스.자바_코딩테스트_연습.탐욕법_체육복;

import java.util.Arrays;

/**
 * @author hyena
 */
public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (lost[i] != -1) {
                boolean isFind = false;
                int left = lost[i] - 1;
                int right = lost[i] + 1;
                for (int j = 0; j < reserve.length; j++) {
                    if (reserve[j] == left || reserve[j] == right) {
                        reserve[j] = -1;
                        isFind = true;
                        break;
                    }
                }
                if (!isFind) n--;
            }
        }
        return n;
    }
}
