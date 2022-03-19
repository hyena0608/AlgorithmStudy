package 인프런_자바_알고리즘_문제_기초.보이는학생;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] arr) {
        int answer = 1;
        int maxHeight = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxHeight) {
                maxHeight = arr[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(T.solution(n, arr) + "");

        bw.flush();
        br.close();
        bw.close();
    }
    
}
