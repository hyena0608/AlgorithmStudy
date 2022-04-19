package 백준.자바.수정렬하기2;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Character> list = new LinkedList<>();
    static int cursor;

    public static void solution(String commend) {
        if (commend.charAt(0) == 'P') {
            String substring = commend.substring(2, commend.length());
            for (char c : substring.toCharArray()) {
                list.add(cursor++, c);
            }
            return;
        }

        if (commend.charAt(0) == 'L') {
            if (cursor != 0) cursor--;
            return;
        }

        if (commend.charAt(0) == 'D') {
            if (cursor != list.size()) cursor++;
            return;
        }

        if(commend.charAt(0) == 'B') {
            if (cursor == 0) return;
            else {
                list.remove(cursor - 1);
                cursor--;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        int n = Integer.parseInt(br.readLine());
        cursor = list.size();
        for (int i = 0; i < n; i++) {
            solution(br.readLine());
        }
        for (Character c : list) {
            bw.write(c + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
