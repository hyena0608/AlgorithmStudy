package 인프런_자바_알고리즘_문제_기초.크레인인형뽑기;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
public class Main {
    public int solution(int[][] machine, int[] cranes) {
        int machineSize = machine.length;
        int answer = 0;
        Stack<Integer> dollStack = new Stack<>();

        for (int col : cranes) {
            int row = 0;
            while (machine[row][col - 1] == 0 && row < machineSize - 1) {
                row++;
            }
            if (machine[row][col - 1] == 0) continue;

            if (!dollStack.isEmpty() && machine[row][col - 1] == dollStack.peek()) {
                answer += 2;
                dollStack.pop();
            } else {
                dollStack.push(machine[row][col - 1]);
            }
            machine[row][col - 1] = 0;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int machineSize = Integer.parseInt(br.readLine());
        int[][] machine = new int[machineSize][machineSize];
        for (int row = 0; row < machineSize; row++) {
            StringTokenizer machineSt = new StringTokenizer(br.readLine());
            for (int col = 0; col < machineSize; col++) {
                machine[row][col] = Integer.parseInt(machineSt.nextToken());
            }
        }

        int craneCount = Integer.parseInt(br.readLine());
        int[] cranes = new int[craneCount];
        StringTokenizer cranesSt = new StringTokenizer(br.readLine());
        for (int chance = 0; chance < craneCount; chance++) {
            cranes[chance] = Integer.parseInt(cranesSt.nextToken());
        }

        int answer = T.solution(machine, cranes);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
