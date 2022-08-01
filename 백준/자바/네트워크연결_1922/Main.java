package 백준.자바.네트워크연결_1922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] parent;
	static List<Route> adj;
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList<>();
		parent = new int[1001];
		for (int i = 1; i <= 1000; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj.add(new Route(A, B, C));
		}
		
		Collections.sort(adj, Comparator.comparingInt(Route::getC));
		
		int answer = 0;
		for (Route curr : adj) {
			if (isSameParent(curr.a, curr.b) == false) {
				union(curr.a, curr.b);
				answer += curr.c;
			}
		}
		
		System.out.print(answer);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return;
		
		parent[bRoot] = aRoot;
	}
	
	static int find(int a) {
		if (parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static boolean isSameParent(int a, int b) {
		if (find(a) == find(b)) return true;
		else return false;
	}
	

}

class Route {
	int a, b, c;
	
	public Route(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int getC() {
		return this.c;
	}
}
