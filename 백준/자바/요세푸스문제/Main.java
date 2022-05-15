package 백준.자바.요세푸스문제;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) Q.add(i);

        while (n --> 0) {
            recursionMTimes(Q, m, stringBuffer);
        }

        stringBuffer.replace(stringBuffer.length() - 2, stringBuffer.length() - 1, ">");
        System.out.print("<" + stringBuffer);
    }

    public static void recursionMTimes(Queue<Integer> Q, int m, StringBuffer stringBuffer) {
        for (int i = 0; i < m - 1; i++) {
            Q.add(Q.poll());
        }
        stringBuffer.append(Q.poll()).append(", ");
    }
}
