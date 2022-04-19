package 백준.자바.수정렬하기2;

import java.io.*;

public class Main {
    static StringBuffer stringBuffer;
    static int cursor;

    public static void solution(String commend) {
        if (commend.charAt(0) == 'P') {
            stringBuffer.insert(cursor, commend.substring(2, commend.length()));
            cursor += commend.length() - 2;
            return;
        }

        if (commend.charAt(0) == 'L') {
            if (cursor != 0) cursor--;
            return;
        }

        if (commend.charAt(0) == 'D') {
            if (cursor != stringBuffer.length()) cursor++;
            return;
        }

        if(commend.charAt(0) == 'B') {
            if (cursor == 0) return;
            else {
                stringBuffer.deleteCharAt(cursor - 1);
                cursor--;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stringBuffer = new StringBuffer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        cursor = stringBuffer.length();
        for (int i = 0; i < n; i++) {
            solution(br.readLine());
        }
        bw.write(stringBuffer.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
