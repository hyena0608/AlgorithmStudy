package 백준.자바_특강.DAY9.가장긴증가하는부분수열5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] lis;
    static int[] lisIndex;
    static List<Integer> answer;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY9/가장긴증가하는부분수열5/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        lis = new int[N + 1];
        lisIndex = new int[N + 1];
        answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis();

        System.out.println(answer.size());
        for (int i = answer.size() - 1; i >= 0; i--) {
            System.out.print(answer.get(i) + " ");
        }
    }

    static void lis() {
        int len = 0;
        lis[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            // 현재 확인할 값
            int target = arr[i];

            if (lis[len] < target) {
                lis[++len] = target;
                lisIndex[i] = len;
            } else if (lis[len] >= target) {
                // 이분 탐색 -> 현재 들어갈 값 위치 리턴
                int findIndex = binarySearch(1, len, target);
                lis[findIndex] = target;
                lisIndex[i] = findIndex;
            }
        }

        // lis 인덱스로 부터 값 가져오기
        for (int i = N; i >= 1; i--) {
            if (lisIndex[i] == len) {
                answer.add(arr[i]);
                len--;
            }
        }

    }

    static int binarySearch(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
