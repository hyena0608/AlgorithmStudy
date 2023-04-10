package 백준.자바.숨바꼭질3_13549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    final int count;
    final int position;

    public Node(final int count, final int position) {
        this.count = count;
        this.position = position;
    }
}

class Element {
    final int count;
    final int position;

    public Element(final int count, final int position) {
        this.count = count;
        this.position = position;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    private static final int MAX_N = 100_000;
    
    private static int SUBIN_POSITION, BROTHER_POSITION;
    private static int[] distance;

    public static void main(String[] args) throws Exception {
        distance = new int[MAX_N + 1];
        Arrays.fill(distance, (int) 1e9);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        SUBIN_POSITION = Integer.parseInt(st.nextToken());
        BROTHER_POSITION = Integer.parseInt(st.nextToken());
        distance[SUBIN_POSITION] = 0;

        final PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(Element::getCount));
        pq.add(new Element(0, SUBIN_POSITION));
        
        while (!pq.isEmpty()) {
            final Element poll = pq.poll();
            final int minCount = poll.count;
            final int minPosition = poll.position;

            if (distance[minPosition] < minCount) {
                continue;
            }
            distance[minPosition] = minCount;

            final int minusPosition = minPosition - 1;
            final int minusPositionCount = minCount + 1;
            if (!isNotOk(minusPosition, minusPositionCount)) {
                pq.add(new Element(minusPositionCount, minusPosition));
            }

            final int plusPosition = minPosition + 1;
            final int plusPositionCount = minCount + 1;
            if (!isNotOk(plusPosition, plusPositionCount)) {
                pq.add(new Element(plusPositionCount, plusPosition));
            }

            final int multiplyPosition = minPosition * 2;
            final int multiplyPositionCount = minCount;
            if (!isNotOk(multiplyPosition, multiplyPositionCount)) {
                pq.add(new Element(multiplyPositionCount, multiplyPosition));
            }
        }

        System.out.println(distance[BROTHER_POSITION]);
    }

    private static boolean isNotOk(final int newPosition, final int newPositionCount) {
        return newPosition < 0 || newPosition > MAX_N || distance[newPosition] <= newPositionCount;
    }
}
