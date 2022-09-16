package 코트.구현력.완전탐색.상황가정.팀으로하는틱택토2;

import java.io.*;
import java.util.*;

public class Main {

    final static int TIKTAKTOK_MAP_SIZE = 3;

    static int[][] map;
    static Set<Integer> playerSet;

    public static void main(String[] args) throws Exception {
        map = new int[TIKTAKTOK_MAP_SIZE][TIKTAKTOK_MAP_SIZE];
        playerSet = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < TIKTAKTOK_MAP_SIZE; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int idx = 0; idx < TIKTAKTOK_MAP_SIZE; idx++) {
                map[i][idx] = chars[idx] - '0';
                playerSet.add(map[i][idx]);
            }
        }

        int winCount = 0;
        List<Integer> players = new ArrayList<>(playerSet);
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i; j < players.size(); j++) {
                int player1 = players.get(i);
                int player2 = players.get(j);
                int player1Count = 0;
                int player2Count = 0;
                int player1CountReverse = 0;
                int player2CountReverse = 0;

                for (int crossIdx = 0; crossIdx < TIKTAKTOK_MAP_SIZE; crossIdx++) {
                    if (map[crossIdx][crossIdx] == player1) player1Count++;
                    if (map[crossIdx][crossIdx] == player2) player2Count++;
                    if (map[TIKTAKTOK_MAP_SIZE - 1 - crossIdx][crossIdx] == player1) player1CountReverse++;
                    if (map[TIKTAKTOK_MAP_SIZE - 1 - crossIdx][crossIdx] == player2) player2CountReverse++;
                }

                if ((player1Count != 3 && player2Count != 3 && player1Count + player2Count == 3)
                        || (player1CountReverse != 3 && player2CountReverse != 3 && player1CountReverse + player2CountReverse == 3)) {
                    winCount++;
                    continue;
                }

                for (int y = 0; y < TIKTAKTOK_MAP_SIZE; y++) {
                    player1Count = 0;
                    player2Count = 0;
                    player1CountReverse = 0;
                    player2CountReverse = 0;

                    for (int x = 0; x < TIKTAKTOK_MAP_SIZE; x++) {
                        int currNum = map[y][x];
                        if (currNum == player1) player1Count++;
                        if (currNum == player2) player2Count++;

                        int currNumReverse = map[x][y];
                        if (currNumReverse == player1) player1CountReverse++;
                        if (currNumReverse == player2) player2CountReverse++;
                    }

                    if ((player1Count != 3 && player2Count != 3 && player1Count + player2Count == 3)
                            || (player1CountReverse != 3 && player2CountReverse != 3 && player1CountReverse + player2CountReverse == 3)) {
                        winCount++;
                        break;
                    }
                }
            }
        }

        System.out.println(winCount);
    }
}
