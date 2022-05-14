package 백준.자바.요세푸스문제;

import java.util.*;

// 14

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        int index = m - 1;
        int[] answer = new int[n];
        answer[0] = list.remove(index);
        for (int i = 1; i < n; i++) {
            if (list.size() <= m) {
                answer[i] = list.remove(0);
            } else {
                if (index + m > list.size() - 1) {
                    index = m + index - (list.size() - 1) - 1;
                    // 1245
                } else {
                    index += m;
                }
                answer[i] = list.remove(index);
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
