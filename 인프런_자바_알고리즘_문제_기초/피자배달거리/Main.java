package 인프런_자바_알고리즘_문제_기초.피자배달거리;

import java.io.*;
import java.util.*;

/**
 * @author hyena
 */
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] pizzaSelected;
    static List<Point> pizzaPointList = new ArrayList<>();
    static List<Point> housePointList = new ArrayList<>();

    public void dfs(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : housePointList) {
                int dis = Integer.MAX_VALUE;
                for (int p : pizzaSelected) {
                    dis = Math.min(dis, Math.abs(h.x - pizzaPointList.get(p).x) + Math.abs(h.y - pizzaPointList.get(p).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                pizzaSelected[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stNM.nextToken());
        m = Integer.parseInt(stNM.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer stZido = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int type = Integer.parseInt(stZido.nextToken());
                if (type == 1) housePointList.add(new Point(i, j));
                else if (type == 2) pizzaPointList.add(new Point(i, j));
            }
        }
        len = pizzaPointList.size();
        pizzaSelected = new int[m];

        T.dfs(0, 0);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
