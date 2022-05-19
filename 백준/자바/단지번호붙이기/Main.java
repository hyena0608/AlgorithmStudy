package 백준.자바.단지번호붙이기;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static int[][] map;
    static int n;
    static int houseCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int y = 0; y < n; y++) {
            String line = br.readLine();
            String[] lineSplit = line.split("");
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(lineSplit[x]);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 1) {
                    dfs(0, y, x);
                    answer.add(houseCnt);
                    houseCnt = 0;
                }
            }
        }

        bw.write(answer.size() + "");
        answer.sort(Comparator.naturalOrder());
        for (Integer integer : answer) {
            bw.write("\n");
            bw.write(integer + "");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int L, int y, int x) {
        for (int i = 0; i < 5; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < n && nx >= 0 && nx < n
                    && map[ny][nx] == 1) {
                map[ny][nx] = 0;
                houseCnt++;
                dfs(L + 1, ny, nx);
            }
        }
    }
}
