package 인프런_자바_알고리즘_문제_기초.학급회장;

import java.io.*;
import java.util.HashMap;

public class Main {
    public char solution(int n, String str) {
        char answer = ' ';
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> peopleMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            peopleMap.put(c, peopleMap.getOrDefault(c, 0) + 1);
        }

        for (Character key : peopleMap.keySet()) {
            int tmp = peopleMap.get(key);
            if (tmp > max) {
                max = tmp;
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        int n;
        String str;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        str = br.readLine();

        char answer = T.solution(n, str);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
