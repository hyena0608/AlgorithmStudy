package 백준.자바.AC;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();

            Deque<Integer> deque = new LinkedList<>();
            String substring = str.substring(1, str.length() - 1);
            String[] split = substring.split(",");
            for (String s : split) {
                try {
                    deque.add(Integer.parseInt(s));
                } catch (NumberFormatException ignored) {}
            }

            Boolean isReverse = false;
            Boolean isError = false;
            for (char com : command.toCharArray()) {
                if (com == 'R' && !isError) {
                    isReverse = !isReverse;
                } else if (com == 'D' && !isError) {
                    try {
                        if (!isReverse) {
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                    } catch (NoSuchElementException e) {
                        isError = true;
                    }
                }
            }

            if (!deque.isEmpty() && !isError) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('[');
                while (!deque.isEmpty()) {
                    if (!isReverse) {
                        stringBuilder
                                .append(deque.pollFirst());
                    } else {
                        stringBuilder
                                .append(deque.pollLast());
                    }
                    stringBuilder.append(',');
                }
                stringBuilder
                        .deleteCharAt(stringBuilder.length() - 1)
                        .append(']');
                bw.write(stringBuilder.toString());
            } else if (deque.isEmpty() && !isError) {
              bw.write("[]");
            } else if (deque.isEmpty() && isError){
                bw.write("error");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

