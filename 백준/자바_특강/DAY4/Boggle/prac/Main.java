package 백준.자바_특강.DAY4.Boggle.prac;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] point = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static TrieNode root = new TrieNode();
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;
    static char[][] board;
    static String longestWord;
    static int totalPoint;
    static int foundCount;
    static int W;
    static int B;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("백준/자바_특강/DAY4/Boggle/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        W = Integer.parseInt(br.readLine());

        for (int i = 0; i < W; i++) {
            // 트라이에 단어 저장
            saveWordToTrie(br.readLine());
        }

        br.readLine();
        B = Integer.parseInt(br.readLine());
        for (int i = 0; i < B; i++) {
            // 그리드 보드판 B번 반복
            sb = new StringBuilder();
            board = new char[4][4];
            visited = new boolean[4][4];
            totalPoint = 0;
            longestWord = "";
            foundCount = 0;

            for (int j = 0; j < 4; j++) {
                String line = br.readLine();
                for (int k = 0; k < 4; k++) {
                    board[j][k] = line.charAt(k);
                }
            }

            // 실행
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (root.hasChild(board[y][x])) {
                        query(y, x, root.getChild(board[y][x]));
                    }
                }
            }

            System.out.println(totalPoint + " " + longestWord + " " + foundCount);
            root.clearHit();
            br.readLine();
        }
    }

    static void query(int y, int x, TrieNode node) {
        // 1. 체크인
        visited[y][x] = true;
        sb.append(board[y][x]);

        // 2. 목적지인가
        if (node.isWord == true && node.isHit == false) {
            node.isHit = true;
            String word = sb.toString();
            int length = word.length();
            totalPoint += point[length];
            foundCount++;

            if (longestWord.length() < length) {
                longestWord = word;
            } else if (longestWord.length() == length) {
                if (word.compareTo(longestWord) < 0) {
                    longestWord = word;
                }
            }
        }

        // 3. 연속 순회
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 4. 갈 수 있는가
            if (0 <= ny && ny < 4 && 0 <= nx && nx < 4 && visited[ny][nx] == false) {
                if (node.hasChild(board[ny][nx])) {
                    // 5. 간다
                    query(ny, nx, node.getChild(board[ny][nx]));
                }
            }
        }

        // 6. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    static void saveWordToTrie(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'A';
            if (node.child[index] == null) {
                // 트라이에 없는 알파벳이면 노드 생성
                node.child[index] = new TrieNode();
                // 생성한 노드로 바꿔주기
            }
            // 트라이에 있는 알파벳이라면 해당 노드로 바꿔주기
            node = node.child[index];
        }
        // 마지막 노드가 단어의 끝임을 알려주기
        node.isWord = true;
    }
}

class TrieNode {
    boolean isWord = false;
    boolean isHit = false;
    TrieNode[] child = new TrieNode[26];

    void clearHit() {
        isHit = false;
        for (int i = 0; i < 26; i++) {
            if (child[i] != null) {
                child[i].clearHit();
            }
        }
    }

    boolean hasChild(char c) {
        return child[c - 'A'] != null;
    }

    TrieNode getChild(char c) {
        return child[c - 'A'];
    }
}
