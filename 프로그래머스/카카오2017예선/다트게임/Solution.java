package 프로그래머스.카카오2017예선.다트게임;

public class Solution {

    private final static char SINGLE = 'S';
    private final static char DOUBLE = 'D';
    private final static char TRIPLE = 'T';

    public int solution(String dartResult) {
        int answer = 0;

        char[] dart = dartResult.toCharArray();

        int idx = 0;
        for (int t = 0; t < 3; t++) {
            StringBuilder sb = new StringBuilder();
            boolean isDigitEnd = false;

            int point = 0;
            while (true) {
                char curr = dart[idx];
                if (Character.isDigit(curr)) {
                    if (isDigitEnd) {
                        answer += point;
                        break;
                    }
                    sb.append(curr);
                } else {
                    if (!isDigitEnd) point = Integer.parseInt(sb.toString());
                    isDigitEnd = true;
                    if (curr == DOUBLE) {
                        point = point * point;
                    } else if (curr == TRIPLE) {
                        point = point * point * point;
                    } else if (curr == '*') {
                        point *= 2;
                    } else if (curr == '#') {
                        point *= -1;
                    }
                }
                idx++;

                if (idx >= dart.length) {
                    answer += point;
                    break;
                }
            }


        }

        return answer;
    }
}
