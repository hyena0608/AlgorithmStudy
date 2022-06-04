package 백준.자바.숨바꼭질;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] map = new int[1000001];
        int subin = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        int answer = 0;

        if (subin != bro) {
            answer = T.bfs(subin, bro, map);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int subin, int bro, int[] map) {
        Queue<Integer> subinQ = new LinkedList<>();

        subinQ.offer(subin);
        map[subin] = 1;
        while (!subinQ.isEmpty()) {
            int subinPolled = subinQ.poll();
            if (subinPolled + 1 == bro
                    || subinPolled - 1 == bro
                    || subinPolled * 2 == bro) {
                return map[subinPolled];
            }

            if (subinPolled < bro && map[subinPolled + 1] == 0) {
                subinQ.offer(subinPolled + 1);
                map[subinPolled + 1] = map[subinPolled] + 1;
            }
            if (subinPolled > 0 && map[subinPolled - 1] == 0) {
                subinQ.offer(subinPolled - 1);
                map[subinPolled - 1] = map[subinPolled] + 1;;
            }
            if (subinPolled < bro && map[subinPolled * 2] == 0) {
                subinQ.offer(subinPolled * 2);
                map[subinPolled * 2] = map[subinPolled] + 1;
            }
        }

        return 0;
    }
}