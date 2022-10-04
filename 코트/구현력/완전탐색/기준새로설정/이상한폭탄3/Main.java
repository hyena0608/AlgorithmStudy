package 코트.구현력.완전탐색.기준새로설정.이상한폭탄3;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_N = 100;
    static int N, K;
    static int[] bombs;

    public static void main(String[] args) throws IOException {
        bombs = new int[MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            bombs[i] = Integer.parseInt(br.readLine());
        }

        int maxBomb = 0;
        int maxFindBombCount = 0;

        for (int curr = 0; curr < N; curr++) {
            int currBomb = bombs[curr];
            int findBombCount = 0;
            for (int left = curr - K; left < curr; left++) {
                if (left < 0) continue;
                if (currBomb == bombs[left]) findBombCount++;
            }
            for (int right = curr + 1; right < curr + K; right++) {
                if (right >= N) continue;
                if (currBomb == bombs[right]) findBombCount++;
            }

            if (findBombCount != 0 && (maxFindBombCount < findBombCount ||
                    (maxFindBombCount == findBombCount && maxBomb < currBomb))) {
                maxBomb = currBomb;
                maxFindBombCount = findBombCount;
            }
        }

        System.out.println(maxBomb);
    }
}
