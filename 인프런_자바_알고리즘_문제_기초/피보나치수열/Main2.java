package 인프런_자바_알고리즘_문제_기초.피보나치수열;

import java.util.Scanner;

public class Main2 {
    public int solution(int n, int[] arr) {
        if (n == 1) arr[n - 1] = 1;
        else if (n == 2) arr[n - 1] = 1;
        else {
            arr[n - 1] = solution(n - 1, arr) + solution(n - 2, arr);
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        T.solution(n, arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
