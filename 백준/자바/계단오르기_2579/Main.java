//package 백준.자바.계단오르기_2579;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//public class Main {
//
//    static int N;
//    static int[] stairs;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        stairs = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            stairs[i] = Integer.parseInt(br.readLine());
//        }
//
//        for (int i = 0; i < N / 4; i *= 4) {
//            int one = stairs[i + 1] + stairs[i + 1] + stairs[i ] ;
//        }
//
//
//
//
//
//        System.out.println(answer);
//    }
//
//}
//
//class Case {
//    int curr, oneStepCount;
//
//
//    public Case(int curr, int oneStepCount) {
//        this.curr = curr;
//        this.oneStepCount = oneStepCount;
//    }
//
//}
