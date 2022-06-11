package 라이브러리;

import java.util.*;

/**
 * 자바로 순열 구하기
 * 라이브러리.Permutation
 */
public class Permutation {

    private int n;
    private int r;
    private int[] now; // 현재 순열
    private List<List<Integer>> result; // 모든 순열

    public List<List<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
    }

    public void permutation(int[] arr, int depth) {
        //  현재 순열이 r일 때 저장한다.
        if (depth == r) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {

        }
    }
}
}
