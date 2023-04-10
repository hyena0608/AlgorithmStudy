package 백준.자바.최소비용구하기_1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    final int index;
    final int distance;

    public Node(final int index, final int distance) {
        this.index = index;
        this.distance = distance;
    }
}

class Element {
    final int index;
    final int distance;

    public Element(final int index, final int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}

public class Main {

    private static final int MAX_N = 1_000;

    private static int N, M;
    private static int START_POSITION, END_POSITION;
    private static List<Node>[] graph;
    private static int[] distance;

    public static void main(String[] args) throws Exception {
        graph = new List[MAX_N + 1];
        for (int index = 0; index <= MAX_N; index++) {
            graph[index] = new ArrayList<>();
        }
        distance = new int[MAX_N + 1];
        Arrays.fill(distance, (int) 1e9);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int count = 0; count < M; count++) {
            st = new StringTokenizer(br.readLine());
            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());
            final int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        START_POSITION = Integer.parseInt(st.nextToken());
        END_POSITION = Integer.parseInt(st.nextToken());
        distance[START_POSITION] = 0;

        final PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(Element::getDistance));
        pq.add(new Element(START_POSITION, 0));

        while (!pq.isEmpty()) {
            final Element poll = pq.poll();
            final int minIndex = poll.index;
            final int minDistance = poll.distance;

            if (distance[minIndex] != minDistance) {
                continue;
            }

            for (int index = 0; index < graph[minIndex].size(); index++) {
                final int targetIndex = graph[minIndex].get(index).index;
                final int targetDistance = graph[minIndex].get(index).distance;

                final int newDistance = minDistance + targetDistance;
                if (distance[targetIndex] > newDistance) {
                    distance[targetIndex] = newDistance;
                    pq.add(new Element(targetIndex, newDistance));
                }
            }
        }

        System.out.println(distance[END_POSITION]);
    }
}
