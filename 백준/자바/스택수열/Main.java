package 백준.자바.스택수열;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }



    }
}


// 4 3 6 8 7 5 2 1
// 1 2 3 4 5 6 7 8
//push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop
// 4 3 6 8 7 5 2 1
// 1 2 5 7 8