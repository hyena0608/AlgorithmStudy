package 백준.자바.스택수열;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> wannaBeStack = new Stack<>();
        for (int i = 0; i < n; i++) wannaBeStack.push(sc.nextInt());

        Queue<Integer> numberQ = new LinkedList<>();
        for (int i = 1; i <= n; i++) numberQ.add(i);

        Stack<Integer> stack = new Stack<>();

        int notThisTime = 0;
        while (!wannaBeStack.isEmpty() || !numberQ.isEmpty()) {
            if (isleftBehindEqual(wannaBeStack, numberQ, stack)) {
                while (!stack.isEmpty()) {
                    System.out.println("-");
                }
                System.exit(0);
            }
            if (wannaBeStack.peek().equals(numberQ.peek())) {
                if (notThisTime != 0) {
                    for (int i = 0; i < notThisTime; i++) {
                        numberQ.add(stack.pop());
                    }
                    notThisTime = 0;
                    stack.push(numberQ.poll());
                    wannaBeStack.pop();
                }
            } else {
                stack.push(numberQ.poll());
                notThisTime++;
            }
        }
        System.out.println("NO");
    }


    public static String stackToStringByPop(Stack<Integer> stack) {
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.toString();
    }

    public static String stackToString(Stack<Integer> stack) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer integer : stack) {
            stringBuffer.append(integer);
        }
        return stringBuffer.toString();
    }

    public static String queueToString(Queue<Integer> Q) {
        StringBuffer stringBuffer = new StringBuffer();
        while (!Q.isEmpty()) {
            stringBuffer.append(Q.poll());
        }
        return stringBuffer.toString();
    }

    public static boolean isleftBehindEqual(Stack<Integer> wannaBeStack, Queue<Integer> numberQ, Stack<Integer> stack) {
        if ((queueToString(numberQ) + stackToStringByPop(stack)).equals(stackToString(wannaBeStack))) {
            return true;
        }
        return false;
    }
}
// push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop
// 436
// 43687521 wannaBeStack
// 436 numberQ
// 12578            stack