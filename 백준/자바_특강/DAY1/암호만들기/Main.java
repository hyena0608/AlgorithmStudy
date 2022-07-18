package 백준.자바_특강.DAY1.암호만들기;

import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static String[] splitArr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        splitArr = sc.nextLine().split(" ");
        Arrays.sort(splitArr);

        visited = new boolean[M];

        dfs(0, 0, new ArrayList<>());




    }

    static void dfs(int L, int index, List<String> strList) {
        // 1. 체크인 visited[]

        // 2. 목적지인가? 목적지 : L, 답 : 자음 모음 숫자 맞아야함
        if (L == N) {
            int moum = 0;
            for (String s : strList) {
                if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                    moum++;
                }
            }
            if (moum >= 1 && strList.size() - moum >= 2) {
                for (String s : strList) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }

        // 3. 순회 0-C, index + 1 - C
        for (int i = index; i < splitArr.length; i++) {
            //4. 갈 수 있는가 ? visited[], 정렬되잇나
            if (!visited[i]) {
                // 5. 간다
                visited[i] = true;
                strList.add(splitArr[i]);
                dfs(L + 1, i, strList);
                // 6. 체크아웃
                strList.remove(strList.size() - 1);
                visited[i] = false;
            }
        }

    }
}
