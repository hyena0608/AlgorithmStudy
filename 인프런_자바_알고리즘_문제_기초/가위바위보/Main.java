package 인프런_자바_알고리즘_문제_기초.가위바위보;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public char[] solution(int n, int[] A, int[] B) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) answer[i] = 'D';
            else if (A[i] == 1 && B[i] == 3) answer[i] = 'A';
            else if (A[i] == 2 && B[i] == 1) answer[i] = 'A';
            else if (A[i] == 3 && B[i] == 2) answer[i] = 'A';
            else answer[i] = 'B';
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer A = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(A.nextToken());
            arrB[i] = Integer.parseInt(B.nextToken());
        } 
        
        char[] answer = T.solution(n, arrA, arrB);
        for (char x : answer) bw.write(x + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
