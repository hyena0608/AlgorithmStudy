package 프로그래머스.타겟넘버;

/**
 * @author hyena
 */
class Solution {
    static int answer = 0;
    static char[] PlusMinus = { '+', '-' };
    static char[] types;

    public void dfs(int L, int[] numbers, int target) {
        if (L == numbers.length) {
            int tmp = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (types[i] == '+') tmp += numbers[i];
                else tmp -= numbers[i];
            }

            if (tmp == target) answer++;
        } else {
            for (char type : PlusMinus) {
                types[L] = type;
                dfs(L + 1, numbers, target);
                types[L] = type;
            }
        }
    }

    public int solution(int[] numbers, int target) {
        types = new char[numbers.length];
        dfs(0, numbers, target);
        return answer;
    }
}
