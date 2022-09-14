package 코트.완전탐색.상황가정.등장하지않는문자열길이;

import java.io.*;

public class Main {

    static int N;
    static String str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        int answer = 0;
        int strLen = str.length();
        for (int len = 1; len < strLen; len++) {
            boolean isLenFind = false;
            for (int curr = 0; curr <= strLen - len; curr++) {
                String currSub = str.substring(curr, curr + len);

                int findCount = 0;
                for (int findCurr = 0; findCurr <= strLen - len; findCurr++) {
                    if (str.substring(findCurr, findCurr + len).equals(currSub)) findCount++;
                }

                if (findCount >= 2) {
                    isLenFind = true;
                    break;
                }
            }

            if (!isLenFind) {
                answer = len;
                break;
            }
        }

        System.out.println(answer);
    }
}
