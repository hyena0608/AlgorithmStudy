package 백준.자바.프린터큐;

import java.io.*;
import java.util.*;

class Docu {
    int priority;
    int num;

    public Docu(int priority, int num) {
        priority = this.priority;
        num = this.num;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stNM = new StringTokenizer(br.readLine());
            int[] testCase = {Integer.parseInt(stNM.nextToken()), Integer.parseInt(stNM.nextToken())};
            StringTokenizer stArr = new StringTokenizer(br.readLine());
            Queue<Docu> Q = new LinkedList<>();
            for (int j = 0; j < testCase[0]; j++) {
                Q.add(new Docu(Integer.parseInt(stArr.nextToken()), j));
            }

            while(!Q.isEmpty()) {
                boolean isMax = true;
                Docu pollDocu = Q.peek();
                for (Docu docu : Q) {
                    if (pollDocu.priority < docu.priority) {
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    Q.poll();
                    if (pollDocu.num == testCase[1]) {
                        answer[i] = testCase[0] - Q.size();
                        break;
                    }
                } else {
                    Q.add(Q.poll());
                }
            }
        }

        for (int i : answer) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}