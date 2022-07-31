//package 백준.자바.사탕상자;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int N, S;
//    static int MAX_CANDY_FLAVOR = 1000000;
//    static int[] tree;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        // 이진 트리를 만든다.
//        tree = new int[MAX_CANDY_FLAVOR * 2 + 1];
//        S = MAX_CANDY_FLAVOR;
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            int A = Integer.parseInt(st.nextToken());
//            int B = Integer.parseInt(st.nextToken());
//
//            if (A == 1) {
//                query(0, MAX_CANDY_FLAVOR * 2, 0, );
//            } else if (A == 2) {
//                int C = Integer.parseInt(st.nextToken());
//                if (C > 0) {
//                    // update(B, C);
//                } else if (C < 0) {
//                    // update(B, -1);
//                }
//            }
//
//
//        }
//
//    }
//
//    static int query(int B) {
//        int node = 1;
//        while (node > MAX_CANDY_FLAVOR) {
//
//            if (tree[node] >= B) {
//                node *= 2;
//            } else {
//                node *= 2 + 1;
//            }
//        }
//        return node;
//    }
//
//    static void update(int B, int C) {
//
//    }
//}
