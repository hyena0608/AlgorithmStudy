package 백준.자바.스택수열;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        int currentNum = 0;
        while (n --> 0) {
            int wannaBeValue = sc.nextInt();

            if (currentNum < wannaBeValue){
                for (int num = currentNum + 1; num <= wannaBeValue; num++) {
                    stack.push(num);
                    stringBuffer.append("+").append("\n");
                }
                currentNum = wannaBeValue;
            } else if (stack.peek() != wannaBeValue){
                System.out.println("NO");
                return;
            }
            stringBuffer.append("-").append("\n");
            stack.pop();
        }
        System.out.println(stringBuffer);
    }
}