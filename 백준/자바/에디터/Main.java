package 백준.자바.에디터;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (char c : str.toCharArray()) {
            leftStack.push(c);
        }
        for (int i = 0; i < n; i++) {
            String commend = br.readLine();
            if (!leftStack.isEmpty() && commend.charAt(0) == 'L') {
                rightStack.push(leftStack.pop());
            } else if (!rightStack.isEmpty() && commend.charAt(0) == 'D') {
                leftStack.push(rightStack.pop());
            } else if (!leftStack.isEmpty() && commend.charAt(0) == 'B') {
                leftStack.pop();
            } else if (commend.charAt(0) == 'P') {
                leftStack.push(commend.charAt(2));
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
