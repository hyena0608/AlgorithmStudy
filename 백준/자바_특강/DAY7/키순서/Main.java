package 백준.자바_특강.DAY7.키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, inCnt[], outCnt[];
    static List<Integer> adj[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNM = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stNM.nextToken());
        M = Integer.parseInt(stNM.nextToken());

        adj = new ArrayList[N + 1];
        inCnt = new int[N + 1];
        outCnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            outCnt[i] = dfs(i) - 1;
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if ((inCnt[i] + outCnt[i]) == N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
    
    static int dfs(int curr) {
        int outCnt =  0;
        for (int next : adj[curr]) {
            if (visited[next]){
                continue;
            }
            inCnt[next]++;
            visited[next] = true;
            outCnt +=dfs(next);
        }
        return outCnt + 1;
    }
}
