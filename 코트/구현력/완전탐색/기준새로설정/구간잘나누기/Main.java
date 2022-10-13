package 코트.구현력.완전탐색.기준새로설정.구간잘나누기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int MAX_ARR_SIZE = 200;

    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_ARR_SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i * 2] = Integer.parseInt(st.nextToken());
        }

        int maxButMin = Integer.MAX_VALUE;

        List<Point> stores = new ArrayList<>();
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(new ArrayList<>()));
        while (!Q.isEmpty()) {
            Point curr = Q.poll();

            if (curr.checkStickSizeFull()) {
                maxButMin = Math.min(maxButMin, findMax(curr.getStickIndexes()));
                continue;
            }

            for (int idx = 1; idx < N; idx++) {
                int stickIdx = idx * 2 - 1;

                if (!curr.checkStickExists(stickIdx)) {
                    curr.addStick(stickIdx);

                    boolean checkAlreadyExists = stores.stream()
                            .anyMatch(store -> store.checkSame(curr.getStickIndexes()));

                    if (!checkAlreadyExists) {
                        Q.add(curr.clone());
                        stores.add(curr.clone());
                    }

                    curr.removeStick(stickIdx);
                }
            }
        }

        System.out.println(maxButMin);

    }

    public static int findMax(List<Integer> stickIndexes) {
        stickIndexes.add(0);
        stickIndexes.add(N * 2);
        Collections.sort(stickIndexes);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            int left = stickIndexes.get(i);
            int right = stickIndexes.get(i + 1);
            int sum = 0;
            for (int j = left; j <= right; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    static class Point {
        private final List<Integer> stickIndexes;

        public Point(List<Integer> sticks) {
            stickIndexes = new ArrayList<>();
            stickIndexes.addAll(sticks);
        }

        public void addStick(Integer stick) {
            if (stickIndexes.contains(stick)) return;
            stickIndexes.add(stick);
        }

        public void removeStick(Integer stick) {
            if (!stickIndexes.contains(stick)) return;
            stickIndexes.remove(stick);
        }

        public boolean checkStickSizeFull() {
            return stickIndexes.size() == M - 1;
        }

        public boolean checkStickExists(int stick) {
            return stickIndexes.contains(stick);
        }

        public boolean checkSame(List<Integer> sticks) {
            return new HashSet<>(stickIndexes).containsAll(sticks);
        }

        public List<Integer> getStickIndexes() {
            return stickIndexes;
        }

        public Point clone() {
            return new Point(this.getStickIndexes());
        }
    }
}
