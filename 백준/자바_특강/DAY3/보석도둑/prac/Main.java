package 백준.자바_특강.DAY3.보석도둑.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static Bosok[] bosoks;
    static int[] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stNK = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNK.nextToken());
        K = Integer.parseInt(stNK.nextToken());


        bosoks = new Bosok[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bosoks[i] = new Bosok(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(bosoks, Comparator.comparingInt(Bosok::getWeight));

        PriorityQueue<Bosok> queue = new PriorityQueue<>(Comparator.comparingInt(Bosok::getPrice).reversed());


        long answer = 0;
        int bosoksIndex = 0;
        for (int i = 0; i < bag.length; i++) {
            while (bosoksIndex < bosoks.length && bag[i] >= bosoks[bosoksIndex].weight) {
                queue.add(bosoks[bosoksIndex++]);
            }
            if (!queue.isEmpty()) {
                answer += queue.poll().price;
            }
        }

        System.out.println(answer);
    }

}

class Bosok {
    int weight;
    int price;

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
