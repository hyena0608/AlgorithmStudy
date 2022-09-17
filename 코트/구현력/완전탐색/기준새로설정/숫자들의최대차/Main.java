package 코트.구현력.완전탐색.기준새로설정.숫자들의최대차;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_N = 1000;

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[MAX_N];
        Arrays.fill(arr, Integer.MAX_VALUE);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int maxCount = 0;
        List<Integer> list = new ArrayList<>();
        for (int start = 0; start < N; start++) {
            list.clear();
            for (int i = start; i < N; i++) {
                if (list.isEmpty()) list.add(arr[i]);
                else if (Math.abs(arr[i] - list.get(0)) <= K) list.add(arr[i]);
                else break;
            }
            maxCount = Math.max(maxCount, list.size());
        }

        System.out.println(maxCount);
    }
}
