package 백준.자바.NQueen;

import java.util.Scanner;

public class Main {
    static int answer, n = 0;
    static int[] visitedX;

    public static void nQueen(int L, int[] visitedX) {
       if (L == n) {
           answer++;
           return;
       }

       for (int x = 0; x < n; x++) {
           visitedX[L] = x;
           if (isOk(L)) nQueen(L + 1, visitedX);
       }
    }

    private static boolean isOk(int L) {
        for (int x = 0; x < L; x++) {
            if (visitedX[x] == visitedX[L]) {
                return false;
            } else if (Math.abs(L - x) == Math.abs(visitedX[L] - visitedX[x])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visitedX = new int[n];

        nQueen(0, visitedX);
        System.out.print(answer);
    }
}