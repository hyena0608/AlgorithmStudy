package 백준.자바_특강.DAY2.합이0인네정수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("백준/자바_특강/DAY2/합이0인네정수/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int M = 4;

        int[][] arr = new int[M][N * N];
        int[] AB = new int[N * N];
        int[] CD = new int[N * N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[count] = arr[0][i] + arr[1][j];
                CD[count++] = arr[2][i] + arr[3][j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        int p1 = 0;
        int p2 = count - 1;
        while (p1 < count && p2 >= 0) {

            if (AB[p1] + CD[p2] < 0) {
                p1++;
            } else if (AB[p1] + CD[p2] > 0) {
                p2--;
            } else {
                // 동률을 구한다
                long p1Count = 0;
                long p2Count = 0;
                int p1Original = p1;
                while (AB[p1] + CD[p2] == 0) {
                    // 현재에 대한 동률 개수 =  + 1
                    p1Count++;
                    // 다음으로 찾을 인덱스 =  p1 + 1
                    p1++;
                    if (p1 >= count) {
                        break;
                    }
                }
                while (AB[p1Original] + CD[p2] == 0) {
                    p2Count++;
                    p2--;
                    if (p2 < 0) {
                        break;
                    }
                }
                answer += p1Count * p2Count;
            }
        }
        System.out.println(answer);
    }
}

