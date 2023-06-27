package 최단RunLength인코딩;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final List<String> strings = Arrays.asList(sc.nextLine().split(""));

        int minLength = Integer.MAX_VALUE;
        for (int count = 0; count < strings.size(); count++) {
            Deque<String> deque = new ArrayDeque<>(strings);
            for (int shift = 0; shift < count; shift++) {
                deque.addFirst(deque.pollLast());
            }

            StringBuilder sb = new StringBuilder();
            Map<String, Integer> numberCounts = new HashMap<>();
            while (!deque.isEmpty()) {
                String poll = deque.pollFirst();
                if (!numberCounts.containsKey(poll)) {
                    numberCounts.keySet().forEach(str -> sb.append(numberCounts.get(str)).append(str));
                    numberCounts.clear();
                }
                numberCounts.put(poll, numberCounts.getOrDefault(poll, 0) + 1);
            }
            numberCounts.keySet().forEach(str -> sb.append(numberCounts.get(str)).append(str));
            minLength = Math.min(minLength, sb.length());
        }

        System.out.println(minLength);
    }
}
