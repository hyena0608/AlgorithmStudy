package 백준.자바.가로수;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] treeArr = new int[n];
        for (int i = 0; i < n; i++) {
            treeArr[i] = sc.nextInt();
        }

        int[] betweenDistanceArr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            betweenDistanceArr[i] = treeArr[i + 1] - treeArr[i];
        }

        Arrays.sort(betweenDistanceArr);
        int betweenDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            betweenDistance = Math.min(betweenDistance, gcd(betweenDistanceArr[i], betweenDistanceArr[i + 1]));
        }

        int tmp = treeArr[0];
        int answer = 0;
        while (tmp <= treeArr[n - 1]) {
            tmp += betweenDistance;
            answer++;
        }

        System.out.println(answer - n);
    }

    public static int gcd(int a, int b) {
        while(b > 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
