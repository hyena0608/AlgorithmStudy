package 인프런_자바_알고리즘_문제_기초.공주구하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author hyena
 */
public class Main {
    public int solution(int princeCount, int numRemove) {
        int answer = 0;
        Queue<Integer> princeQueue = new LinkedList<>();

        for (int i = 1; i <= princeCount; i++) {
            princeQueue.add(i);
        }

        while (!princeQueue.isEmpty()) {
            for (int i = 0; i < numRemove - 1; i++) {
                princeQueue.offer(princeQueue.poll());
            }
            princeQueue.poll();
            if (princeQueue.size() == 1) {
                answer = princeQueue.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        int princeCount = sc.nextInt();
        int numRemove = sc.nextInt();

        int answer = T.solution(princeCount, numRemove);
        System.out.println(answer);
    }
}
