package 백준.자바.파티_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int index;
    int distance;

    public Node(final int index, final int distance) {
        this.index = index;
        this.distance = distance;
    }
}

class Element {
    int index;
    int distance;

    public Element(final int index, final int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}

public class Main {

    private static final int MAX_N = 1000;
    private static final int MAX_DISTANCE = (int) 1e9;

    private static int N, M, X;
    private static List<Node>[] partyGraph;
    private static List<Node>[] homeGraph;
    private static int[] partyDistance;
    private static int[] homeDistance;

    public static void main(String[] args) throws Exception {
        partyGraph = new List[MAX_N + 1];
        homeGraph = new List[MAX_N + 1];
        for (int index = 0; index < MAX_N + 1; index++) {
            partyGraph[index] = new ArrayList<>();
            homeGraph[index] = new ArrayList<>();
        }
        partyDistance = new int[MAX_N + 1];
        homeDistance = new int[MAX_N + 1];
        Arrays.fill(partyDistance, MAX_DISTANCE);
        Arrays.fill(homeDistance, MAX_DISTANCE);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        partyDistance[X] = 0;
        homeDistance[X] = 0;

        for (int count = 0; count < M; count++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            homeGraph[start].add(new Node(end, cost));
            partyGraph[end].add(new Node(start, cost));
        }

        dijk(homeGraph, homeDistance);
        dijk(partyGraph, partyDistance);

        int[] totalDistance = new int[N + 1];
        for (int index = 1; index <= N; index++) {
            totalDistance[index] = homeDistance[index] + partyDistance[index];
        }

        final int maxTime = Arrays.stream(totalDistance)
                .max()
                .getAsInt();

        System.out.println(maxTime);
    }

    private static void dijk(List<Node>[] graph, int[] distance) {
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(Element::getDistance));
        pq.add(new Element(X, 0));
        while (!pq.isEmpty()) {
            final Element poll = pq.poll();
            int minIndex = poll.index;
            int minDistance = poll.distance;

            for (int index = 0; index < graph[minIndex].size(); index++) {
                int targetIndex = graph[minIndex].get(index).index;
                int targetDistance = graph[minIndex].get(index).distance;

                int newDistance = minDistance + targetDistance;
                if (distance[targetIndex] > newDistance) {
                    distance[targetIndex] = newDistance;
                    pq.add(new Element(targetIndex, newDistance));
                }
            }
        }
    }
}
