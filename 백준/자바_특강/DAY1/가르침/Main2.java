package 백준.자바_특강.DAY1.가르침;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 아... 이거 문자로 캐스팅하면서 시간 초과.. 진작에 걍 정수로 뽑아먹을걸 바보
 * 통과는 했는데 메모리, 시간 엄청 잡아먹힘
 */
public class Main2 {
    static int N, M, tempAnswer, answer;
    static String[] words;
    static List<List<Integer>> wordIntListList;


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY1/가르침/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        wordIntListList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            wordIntListList.add(new ArrayList<>());
        }

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
            List<Integer> wordIntList = wordIntListList.get(i);
            for (char c : words[i].substring(4, words[i].length() - 4).toCharArray()) {
                if (!wordIntList.contains(c) && c != 'a' && c != 'c' && c != 'i' && c != 'n' && c != 't') {
                    wordIntList.add((int) c);
                }
            }
        }

        if (M >= 5) {
            List<Integer> charList = new ArrayList<>();
            dfs(0, charList, 97);
        }

        System.out.println(answer);

    }

    static void dfs(int L, List<Integer> intList, int ascii) {
        // 체크인
        // 목적지
        if (L == M - 5) {
            tempAnswer = 0;
            wordIntListList.forEach(wordCharList -> {if (intList.containsAll(wordCharList)) tempAnswer++;});
            answer = Math.max(tempAnswer, answer);
            return;
        }

        // 순회
        for (int i = ascii; i <= 122; i++) {

            // 갈 수 있는가
            if (!intList.contains(i) && i != 97 && i != 99 && i != 105 && i != 110 && i != 116) {

                // 간다
                intList.add(i);
                dfs(L + 1, intList, i + 1);
                // 체크아웃
                intList.remove(intList.size() - 1);
            }
        }
    }
}
