package 인프런_자바_알고리즘_문제_기초.좌표정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}

public class Main {

    public List<Point> solution(int n, List<Point> pointList) {
        Collections.sort(pointList);
        return pointList;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pointList.add(point);
        }

        List<Point> answerList = T.solution(n, pointList);
        for (Point point : answerList) {
            bw.write(point.x + " " + point.y + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
