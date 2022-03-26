package 인프런_자바_알고리즘_문제_기초.모든아나그램찾기;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public int solution(String str, String findStr) {
        int answer = 0;
        int lenStr = str.length();
        int lenNeedStr = findStr.length();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> needMap = new HashMap<>();

        for (int rt = 0; rt < lenNeedStr - 1; rt++) {
            map.put(str.charAt(rt), map.getOrDefault(str.charAt(rt), 0) + 1);
        }

        for (char c : findStr.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int lt = 0;
        for (int rt = lenNeedStr - 1; rt < lenStr; rt++) {

            map.put(str.charAt(rt), map.getOrDefault(str.charAt(rt), 0) + 1);

            if (map.equals(needMap)) {
                answer++;
            }

            char charRemove = str.charAt(lt++);
            map.put(charRemove, map.getOrDefault(charRemove, 0) - 1);
            Integer charCount = map.get(charRemove);
            if (charCount == 0) {
                map.remove(charRemove);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strTarget = new StringTokenizer(br.readLine());
        StringTokenizer strFind = new StringTokenizer(br.readLine());

        String str = strTarget.nextToken();
        String findStr = strFind.nextToken();

        int answer = T.solution(str, findStr);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
