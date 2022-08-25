package 이코테.greedy.만들수없는금액;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int CASH_MAX = 1000000;
    static int N;
    static List<Integer> list = new ArrayList<>();
    static boolean[] ableCash = new boolean[CASH_MAX + 1];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("이코테/greedy/만들수없는금액/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));

        find(0, new boolean[N]);

        for (int i = 1; i <= CASH_MAX; i++) {
            if (!ableCash[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    static void find(int cash, boolean[] visited) {
        if (ableCash[cash]) return;
        ableCash[cash] = true;

        for (int i = 0; i < N; i++) {
            if (visited[i])  continue;
            visited[i] = true;
            find(cash + list.get(i), visited);
            visited[i] = false;
        }
    }
}
