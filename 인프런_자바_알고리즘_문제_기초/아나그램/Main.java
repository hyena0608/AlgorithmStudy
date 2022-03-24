package 인프런_자바_알고리즘_문제_기초.아나그램;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public String solution(String strA, String strB) {
        String isSame = "YES";
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for (char c : strA.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }

        for (char c : strB.toCharArray()) {
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
        }

        for (Character key : mapA.keySet()) {
            if (!Objects.equals(mapA.get(key), mapB.get(key))) {
                isSame = "NO";
                break;
            }
        }
        return isSame;
    }

    public static void main(String[] args) throws IOException {
        String strA;
        String strB;
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        strA = stA.nextToken();
        strB = stB.nextToken();

        String answer = T.solution(strA, strB);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
