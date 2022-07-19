package 백준.자바_특강.DAY1.가르침;

import java.util.Scanner;

public class Main {

    static int N, K, selectedCount, answer;
    static String[] words;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        words = new String[N];
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            words[i] = sc.next().replaceAll("[antic]", "");
        }

        if (K >= 5) {
            selectedCount = 5;
            answer = countWords();

            for (int i = 0; i < 26; i++) {
                if (visited[i] == false) {
                    dfs(i);
                }
            }
        } else {
            answer = 0;
        }
        System.out.println(answer);
    }

    static void dfs(int index) {
        // 1. 체크인
        selectedCount++;
        visited[index] = true;

        // 2. 목적지인가 ?
        if (selectedCount == K) {
            answer = Math.max(answer, countWords());
        } else {
            // 3. 연결된 곳을 순회
            for (int i = index + 1; i <= 25; i++) {
                // 4. 갈 수 있는가 ?
                if (visited[i] == false) {
                    // 5. 간다
                    dfs(i);
                }
            }
        }

        // 6. 체크아웃
        selectedCount--;
        visited[index] = false;
    }

    static int countWords() {
        int count = 0;
        for (int n = 0; n < N; n++) {
            boolean isOk = true;
            String word = words[n];
            for (int i = 0; i < word.length(); i++) {
                if (visited[word.charAt(i) - 'a'] == false) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                count++;
            }
        }
        return count;
    }
}
