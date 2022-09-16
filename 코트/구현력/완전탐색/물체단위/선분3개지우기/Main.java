package 코트.구현력.완전탐색.물체단위.선분3개지우기;

import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_LINE_SIZE = 100;
    final static int REMOVE_EDGE_COUNT = 3;

    static int N;
    static int[] lines;
    static List<Edge> edges;

    public static void main(String[] args) throws Exception {
        edges = new ArrayList<>();
        lines = new int[MAX_LINE_SIZE + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end));
        }

        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {

                    Arrays.fill(lines, 0);
                    boolean checkOverlap = false;
                    for (int edgeIdx = 0; edgeIdx < N; edgeIdx++) {
                        if (edgeIdx == i || edgeIdx == j || edgeIdx == k) continue;

                        Edge curr = edges.get(edgeIdx);
                        for (int currIdx = curr.start; currIdx <= curr.end; currIdx++) {
                            lines[currIdx]++;
                            if (lines[currIdx] > 1) {
                                checkOverlap = true;
                                break;
                            }
                        }
                    }

                    if (!checkOverlap) count++;
                }
            }
        }

        System.out.print(count);
    }
}

class Edge {
    int start, end;

    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
