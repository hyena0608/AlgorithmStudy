package 인프런_자바_알고리즘_문제_기초.씨름선수;

import java.io.*;
import java.util.*;

/**
 * @author hyena
 */
class Player implements Comparable<Player>{
    int height;
    int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player o) {
        return o.height - this.height;
    }
}

public class Main {
    public int solution(List<Player> playerList) {
        int cnt = 0;
        Collections.sort(playerList);
        int max = Integer.MIN_VALUE;
        for (Player p : playerList) {
            if (p.weight > max) {
                max = p.weight;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            playerList.add(new Player(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        bw.write(T.solution(playerList) + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
