package 백준.자바.N과M_1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int n, m;
    static Stack<Integer> stack = new Stack<>();

    public int solution(int L) {
        if (L == m + 1) {
            for (Integer i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
            return -1;
        }

        for (int i = 1; i <= n; i++) {
            if(!stack.contains(i)) {
                stack.add(i);
                solution(L + 1);
                stack.pop();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        T.solution(1);

    }
}