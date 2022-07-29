package 백준.자바_특강.DAY10.카드게임;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[] card;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY10/카드게임/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int cardSize = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());


            card = new int[cardSize];
            for (int i = 0; i < cardSize; i++) {
                card[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[cardSize][cardSize];
            dp[0][0] = card[0];
            dp[0][cardSize - 1] = card[cardSize - 1];
            for (int i = 1; i < Math.ceil((double) cardSize / 2); i++) {
                for (int j = 0; j < cardSize - i; j++) {
                    dp[i][j] = Math.max(
                            Math.max(
                                    card[0 + i] + dp[i - 1][0 + i - 1],
                                    card[0 + i] + dp[i - 1][cardSize - 1 - i + 1]
                            ),
                            Math.max(
                                    card[cardSize - 1 - i] + dp[i - 1][0 + i - 1],
                                    card[cardSize - 1 - i] + dp[i - 1][cardSize - 1 - i + 1]
                            )
                    );
                }
            }


            for (int[] ints : dp) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
    }
}
