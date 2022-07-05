package 백준.자바.일로만들기_1463;

import java.io.*;

public class Main {
    static Integer[] repo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        repo = new Integer[n + 1];
        repo[0] = 0;
        repo[1] = 0;
        dp(n);

        System.out.print(repo[n]);
    }

    private static int dp(int X) {
        if (repo[X] == null) {
            if (X % 6 == 0) {
                repo[X] = Math.min(dp(X - 1), Math.min(dp(X / 3), dp(X / 2))) + 1;
            } else if (X % 3 == 0) {
                repo[X] = Math.min(dp(X - 1), dp(X / 3)) + 1;
            } else if (X % 2 == 0) {
                repo[X] = Math.min(dp(X - 1), dp(X / 2)) + 1;
            } else {
                repo[X] = dp(X - 1) + 1;
            }
        }
        return repo[X];
    }

}
