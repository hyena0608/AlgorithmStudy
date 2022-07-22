package 백준.자바_특강.DAY5.순열의순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] fact = new long[21];
    static int[] nums;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i - 1] * i;
        }

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int command = Integer.parseInt(st.nextToken());

        if (command == 1) {
            long target = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[i] == true) {
                        continue;
                    }
                    if (target > fact[N - i - 1]) {
                        target -= fact[N - i - 1];
                    } else {
                        sb.append(j);
                        sb.append(" ");
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        } else if (command == 2) {
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            long result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < nums[i]; j++) {
                    if (visited[j] == false) {
                        result += fact[N - i - 1];
                    }
                }
                visited[nums[i]] = true;
            }

            System.out.println(result + 1);
        }

    }
}
