package 이코테.greedy.모험가길드;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("이코테/greedy/모험가길드/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        int fear = 0;
        int currPeople = 0;
        int groupCount = 0;

        for (int i = 0; i < N; i++) {
            fear = Math.max(fear, list.get(i));
            currPeople++;

            if (fear == currPeople) {
                groupCount++;
                currPeople = 0;
                fear = 0;
            }
        }

        System.out.println(groupCount);
    }
}
