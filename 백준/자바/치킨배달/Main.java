package 백준.자바.치킨배달;

import java.io.*;
import java.util.*;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int n, m, sum;
    static Stack<Integer> stack = new Stack<>();
    static List<Point> chickenShop = new ArrayList<>();
    static List<Point> house = new ArrayList<>();

    public static void dfs(int L, int idx) {
        if (L == m) {
            calDistance();
        } else {
            for (int i = idx; i < chickenShop.size(); i++) {
                if (!stack.contains(i)) {
                    if (stack.size() > 0) {
                        if (idx < i) {
                            stack.push(i);
                            dfs(L + 1, i);
                            stack.pop();
                        }
                    } else {
                        stack.push(i);
                        dfs(L + 1, i);
                        stack.pop();
                    }
                }
            }
        }
    }

    private static void calDistance() {
        int[] distance = new int[house.size()];
        for (int i = 0; i < house.size(); i++) distance[i] = Integer.MAX_VALUE;
        for (Integer chickenIdx : stack) {
            Point chickenPoint = chickenShop.get(chickenIdx);
            for (int i = 0; i < house.size(); i++) {
                int houseY = house.get(i).y;
                int houseX = house.get(i).x;
                int houseToChickenDistance = Math.abs(chickenPoint.x - houseX) + Math.abs(chickenPoint.y - houseY);
                if (houseToChickenDistance < distance[i]) {
                    distance[i] = houseToChickenDistance;
                }
            }
        }
        sum = Math.min(sum, Arrays.stream(distance).sum());
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stNM.nextToken());
        m = Integer.parseInt(stNM.nextToken());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    house.add(new Point(i, j));
                } else if (num == 2) {
                    chickenShop.add(new Point(i, j));
                }
            }
        }

        sum = Integer.MAX_VALUE;
        dfs(0, 0);
        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
