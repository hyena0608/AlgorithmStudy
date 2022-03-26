package 인프런_자바_알고리즘_문제_기초.k번째큰수;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public int solution(int n, int m, int[] cards) {
        int answer = -1;
        TreeSet<Integer> cardSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    cardSet.add(cards[i] + cards[j] + cards[k]);
                }
            }
        }

        int cnt = 0;
        for (Integer cardSum : cardSet) {
            if (++cnt == m) {
                answer = cardSum;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNK = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stNK.nextToken());
        int m = Integer.parseInt(stNK.nextToken());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = (Integer.parseInt(st.nextToken()));
        }

        int answer = T.solution(n, m, cards);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
