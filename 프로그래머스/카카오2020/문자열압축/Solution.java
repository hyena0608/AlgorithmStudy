package 프로그래머스.카카오2020.문자열압축;

public class Solution {
    public void solution(String s) {
        int answer = 0;
        int length = s.length();

        for (int cutLength = 1; cutLength <= length / 2; cutLength++) {
            int count = 0;
            String substringOne = null;
            String substringTwo = null;
            for (int idx = 0; idx < length - cutLength * 2; idx += cutLength) {
                substringOne = s.substring(idx, idx + cutLength);
                substringTwo = s.substring(idx + cutLength, idx + cutLength * 2);
                System.out.println("substringOne = " + substringOne);
                System.out.println("substringTwo = " + substringTwo);
                if (substringOne.equals(substringTwo)) {
                    s.(substringTwo, "");
                    count++;
                }
                System.out.println("count = " + count);
                System.out.println("s = " + s);
            }
            if (count > 0)
            s.replaceAll(substringOne, String.valueOf(count + 1));

            System.out.println("s = " + s);
        }



    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("ababcdcdababcdcd");
    }
}
