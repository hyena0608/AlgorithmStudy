package 백준.자바_특강.DAY10.발전소;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, P;
    static int[][] factory;
    static int visited = 0;
//static boolean[] visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY10/발전소/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        factory = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                factory[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        StringBuilder sb = new StringBuilder();
        char[] broken = br.readLine().toCharArray();
//        visited = new boolean[N + 1];
//        for (int i = 1; i <= N; i++) {
//            if (broken[i] == 'Y') {
//                visited[i] = true;
//            }
//        }
        sb.append(0);
        for (int i = 0; i < N; i++) {
            char curr = broken[i];
            if (curr == 'Y') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        visited = Integer.parseInt(sb.toString());

        P = Integer.parseInt(br.readLine());

        //

        int[] answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if ((visited & (1 << i)) == (1 << i)) {
                for (int j = 1; j <= N; j++) {
                    if (j == i) continue;
                    if ((visited & (1 << j)) != (1 << j)) continue;
                    for (int k = 1; k <= N; k++) {
//                        if ((visited & (1 << k)) == (i << k)) continue;
                        factory[i][j] = Math.min(factory[i][j], factory[i][k] + factory[k][j]);
                        System.out.println(factory[i][j]);
                    }
                }
            }
        }

//
//        for (int k = 1; k <= N; k++) {
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    // 가능한 발전소라면
//                    if (i == j) continue;
//                    factory[i][j] = Math.min(factory[i][j], factory[i][k] + factory[k][j]);
//                }
//            }
//        }

        for (int[] ints : factory) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
