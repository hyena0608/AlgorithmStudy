package 프로그래머스.카카오2020.문자열압축;

public class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String zipStr = s.substring(0, i);

            int zipCount = 1;
            String currentStr = null;
            StringBuilder stringBuilder = new StringBuilder();

            for (int start = i; start <= s.length(); start += i) {
                if (start + i >= s.length()) {
                    currentStr = s.substring(start);
                } else {
                    currentStr = s.substring(start, start + i);
                }

                if (currentStr.equals(zipStr)) {
                    zipCount++;
                } else if (zipCount == 1) {
                    stringBuilder.append(zipStr);
                    zipStr = currentStr;
                } else if (zipCount >= 2) {
                    stringBuilder.append(zipCount).append(zipStr);
                    zipStr = currentStr;
                    zipCount = 1;
                }
            }
            if (i != zipStr.length()) stringBuilder.append(zipStr);

            answer = Math.min(answer, stringBuilder.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("aabbaccc");
    }
}
