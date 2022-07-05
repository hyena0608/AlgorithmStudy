package 프로그래머스.카카오2017예선.카카오프렌즈컬러링북;

class Solution {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;




        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void dfs(int L, int y, int x) {

    }
}

// 1110
// 1220
// 1001
// 0001
// 0003
// 0003
