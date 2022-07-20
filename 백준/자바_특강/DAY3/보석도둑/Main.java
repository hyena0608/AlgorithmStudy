package 백준.자바_특강.DAY3.보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bosok{
    int weight, price;

    public Bosok(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}

public class Main {

    static long N, M;
    static List<Bosok> bosokList;
    static List<Integer> bagList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stNM = new StringTokenizer(br.readLine());
        N = Long.parseLong(stNM.nextToken());
        M = Long.parseLong(stNM.nextToken());

        bosokList = new ArrayList<>();
        bagList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bosokList.add(new Bosok(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < M; i++) {
            bagList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bagList);
        Collections.sort(bosokList, Comparator.comparingInt(Bosok::getWeight));

        PriorityQueue<Bosok> Q = new PriorityQueue<>(Comparator.comparingInt(Bosok::getPrice).reversed());

        long answer = 0;
        int jIndex = 0;
        for (int i = 0; i < bagList.size(); i++) {
            while (jIndex < N && bosokList.get(jIndex).weight <= bagList.get(i)) {
                Q.add(bosokList.get(jIndex++));
            }
            if (!Q.isEmpty()) {
                answer += Q.poll().price;
            }
        }

        System.out.println(answer);
    }
}
