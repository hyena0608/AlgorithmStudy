//package 백준.자바_특강.DAY3.구간합구하기;
//
//import java.io.*;
//import java.util.*;
//public class Main {
//
//    static int N, M;
//    static int[] parent;
//    static long[] dist;
//    static String type;
//    static int a, b, w;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringBuilder sb = new StringBuilder();
//
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        for (; N != 0 && M != 0;) {
//            parent = new int[N + 1];
//            for (int i = 1; i <= N; i++) {
//                parent[i] = i;
//            }
//            dist = new long[N + 1];
//
//            for (int i = 1; i <= M; i++) {
//                st = new StringTokenizer(br.readLine());
//                type = st.nextToken();
//
//                if (type.equals("!")) {
//                    a = Integer.parseInt(st.nextToken());
//                    b = Integer.parseInt(st.nextToken());
//                    w = Integer.parseInt(st.nextToken());
//
//                    union(a, b, w);
//                }
//                else {
//                    a = Integer.parseInt(st.nextToken());
//                    b = Integer.parseInt(st.nextToken());
//
//                    if (find(a) != find(b)) {
//                        sb.append("UNKNOWN\n");
//                    }
//                    else {
//                        sb.append((dist[b] - dist[a]) + "\n");
//                    }
//                }
//            }
//
//            st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken());
//            M = Integer.parseInt(st.nextToken());
//        }
//
//        bw.write(sb.toString());
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    static int find(int id) {
//        if (parent[id] == id)
//            return id;
//        int pId = find(parent[id]);
//        dist[id] += dist[parent[id]];
//        return parent[id] = pId;
//    }
//
//    static void union(int a, int b, long diff) {
//        int pa = find(a);
//        int pb = find(b);
//
//        if (pa == pb)
//            return;
//
//        dist[pb] = dist[a] - dist[b] + diff;
//        parent[pb] = pa;
//
//        return;
//    }
//}
