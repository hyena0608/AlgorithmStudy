package 인프런_자바_알고리즘_문제_기초.두배열합치기;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Stream<Integer> stream;

    public List<Integer> solution(int n, int m, int[] arrA, int[] arrB) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (arrA[p1] < arrB[p2]) answer.add(arrA[p1++]);
            else answer.add(arrB[p2++]);
        }
        while (p1 < n) answer.add(arrA[p1++]);
        while (p2 < m) answer.add(arrB[p2++]);


//        밑에 코드는 내 코드
//
//        List<Integer> arr = new ArrayList<>();
//
//        Arrays.stream(arrA).forEach(arr::add);
//        Arrays.stream(arrB).forEach(arr::add);
//
//        List<Integer> answer = arr.stream().sorted().collect(Collectors.toList());
//
//        return answer;
        return answer;
    }

    public static void main (String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stA = new StringTokenizer(br.readLine());
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(stA.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        int[] arrB = new int[m];
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(stB.nextToken());
        }

        List<Integer> answer = T.solution(n, m, arrA, arrB);
        for (Integer o : answer) {
            bw.write(o + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
