package 백준.자바_특강.DAY9.가장긴증가하는부분수열5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> originalList;
    static int[] lis;
    static int[] lisIndex;
    static List<Integer> answer;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY9/가장긴증가하는부분수열5/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        originalList = new ArrayList<>();
        lis = new int[N];
        lisIndex = new int[N];
        answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            originalList.add(Integer.parseInt(st.nextToken()));
        }

        lis();
        System.out.println(answer.size());
        for (int i = answer.size() - 1; i >= 0; i--) {
            System.out.print(answer.get(i) + " ");
        }
    }

    static void lis() {
        // 이분탐색
        int len = 0;
        for (int i = 0; i < N; i++) {
            // 현재 확인할 값
            int target = originalList.get(i);

//            if (lis.length == 0) {
//                // lis 리스트가 비어있을 때
//                lisList.add(target);
//                lisIndex[i] = len;
//            } else

            if (lis[len] < target) {
                // lis 리스트의 마지막 값 < 현재 들어갈 값
                lis[++len] = target;
                lisIndex[i] = len;
            } else if (lis[len] > target) {
                // lis 리스트의 마지막 값 > 현재 들어갈 값
                // 이분 탐색 -> 현재 들어갈 값 위치 리턴
                int findIndex = binarySearch(0, len, target);
                lis[findIndex] = target;
                lisIndex[i] = findIndex;
            }
        }

        for (int index : lisIndex) {
            System.out.print(index + " ");
        }
        System.out.println();

        // lis 인덱스로 부터 값 가져오기
        for (int i = N - 1; i >= 0; i--) {

        }
    }

    static int binarySearch(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lisList.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
