package 백준.자바.소수의연속합;

import java.util.*;

public class Main {

    static List<Integer> sosuList;
    static Map<Integer, Integer> sumMap;
    static List<Point> pointList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sosuList = new ArrayList<>();
        sumMap = new HashMap<>();
        pointList = new ArrayList<>();

        makeSosuList(sosuList, n);
        collectPoints(0);
        addAllSumToMap();

        if (sumMap.containsKey(n)) {
            System.out.println(sumMap.get(n));
        } else {
            System.out.println(0);
        }
    }

    private static void addAllSumToMap() {
        for (Point point : pointList) {
            int sum = 0;
            for (int i = point.start; i <= point.end; i++) {
                sum += sosuList.get(i);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        for (Integer sosu : sosuList) {
            sumMap.put(sosu, sumMap.getOrDefault(sosu, 0) + 1);

        }
    }

    public static void makeSosuList(List<Integer> sosuList, int n) {
        for (int num = 2; num <= n; num++) {
            if (isSosu(num)) {
                sosuList.add(num);
            }
        }
    }

    private static boolean isSosu(int n) {
        int sqirtN = (int) Math.sqrt(n);
        for (int num = 2; num <= sqirtN; num++) {
            if (n % num == 0) {
                return false;
            }
        }
        return true;
    }

    public static void collectPoints(int L) {
        for (int i = L; i < sosuList.size(); i++) {
            for (int j = L + 1; j < sosuList.size(); j++) {
                if (sosuList.get(i) < sosuList.get(j))
                    pointList.add(new Point(i, j));
            }
        }
    }

    static class Point {
        int start, end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

