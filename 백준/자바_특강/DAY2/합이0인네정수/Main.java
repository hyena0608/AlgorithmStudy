//package 백준.자바_특강.DAY2.합이0인네정수;
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//    static int N;
//    static long[] A, B, C, D;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        N = Integer.parseInt(br.readLine());
//        A = new long[N];
//        B = new long[N];
//        C = new long[N];
//        D = new long[N];
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            A[i] = Long.parseLong(st.nextToken());
//            B[i] = Long.parseLong(st.nextToken());
//            C[i] = Long.parseLong(st.nextToken());
//            D[i] = Long.parseLong(st.nextToken());
//        }
//
//        List<Long> subAB = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                subAB.add(A[i] + B[j]);
//            }
//        }
//
//        Map<Integer, Integer> subCD = new HashMap();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                subCD.put(C[i] + D[j], subCD.getOrDefault());
//            }
//        }
//
//        Collections.sort(subCD);
//
//        int count = 0;
//        for (int ABIndex = 0; ABIndex < subAB.size(); ABIndex++) {
//            int start = 0;
//            int end = subCD.size() - 1;
//            while (true) {
//                int mid = (start + end) / 2;
//
//                long value = subAB.get(ABIndex) + subCD.get(mid);
//
//                if (value == 0) {
//                    int sameCount = 1;
//                    while (true) {
//                        if (subCD.get(mid - sameCount) == subCD.get(mid)) {
//                            sameCount++;
//                        } else if (subCD.get(mid + sameCount) == subCD.get(mid)) {
//                            sameCount++;
//                        } else {
//                            break;
//                        }
//                    }
//                    count += sameCount;
//                    break;
//                } else if (value > 0) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//
//                if (start > end) {
//                    break;
//                }
//            }
//
//        }
//
//        bw.write(count + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}
