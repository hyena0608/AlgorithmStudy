package 백준.자바.숨바꼭질;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        int answer = 0;

        if (subin != bro) {
            answer = T.bfs(subin, bro);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private class TimeDis {
        int time;
        int distance;

        public TimeDis(int time, int distance) {
            this.time = time;
            this.distance = distance;
        }
    }

    private int bfs(int subin, int bro) {
        Queue<TimeDis> subinQ = new LinkedList<>();

        subinQ.offer(new TimeDis(0, subin));
        while (!subinQ.isEmpty()) {
            TimeDis subinPolled = subinQ.poll();
            if (subinPolled.distance + 1 == bro
                    || subinPolled.distance - 1 == bro
                    || subinPolled.distance * 2 == bro) {
                return subinPolled.time + 1;
            }

            if (subinPolled.distance * 2 <= bro) {
                subinQ.offer(new TimeDis(subinPolled.time + 1, subinPolled.distance * 2));
            } else {
                if (subinPolled.distance < bro) {
                    subinQ.offer(new TimeDis(subinPolled.time + 1, subinPolled.distance + 1));
                }
                if (subinPolled.distance > 0) {
                    subinQ.offer(new TimeDis(subinPolled.time + 1, subinPolled.distance - 1));
                }
                if (subinPolled.distance < bro) {
                    subinQ.offer(new TimeDis(subinPolled.time + 1, subinPolled.distance * 2));
                }
            }
        }
        return 0;
    }
}