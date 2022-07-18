package 백준.자바_특강.DAY1.암호만들기;

import java.util.*;

public class Main2 {

    static int L, C;
    static char[] data;
    static List<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        data = new char[C];
        result = new LinkedList<>();

        for (int i = 0; i < C; i++) {
            data[i] = sc.next().charAt(0);
        }

        Arrays.sort(data);

        dfs(0, 0, 0, -1, "");

        for (String s : result) {
            System.out.println(s);
        }
    }

    static void dfs(int length, int ja, int mo, int current, String pwd) {
        // 1. 체크인
        // 2. 목적지 인가 ?
        if (length == L) {
            if (ja >= 2 && mo >= 1) {
                result.add(pwd);
            }
        } else {
            // 3. 연결된 곳 순회 ; current + 1 ~ C
            for (int i = current + 1; i < C; i++) {
                // 4. 갈 수 있는가?
                // 5. 간다
                if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
                    dfs(length + 1, ja, mo + 1, i, pwd + data[i]);
                } else {
                    dfs(length + 1, ja + 1, mo, i, pwd + data[i]);

                }
            }
        }
    }
}
