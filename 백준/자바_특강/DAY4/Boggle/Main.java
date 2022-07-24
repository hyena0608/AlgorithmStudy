package 백준.자바_특강.DAY4.Boggle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int sum;
    static int count;
    static String answer;
    static StringBuilder sb = new StringBuilder();
    static TrieNode root = new TrieNode();
    static boolean[][] visited;
    static char[][] board;
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String word = br.readLine();
//            list.add(str);
            insertTrieNode(word);
        }

        br.readLine();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            board = new char[4][4];
            visited = new boolean[4][4];
            sum = 0;
            count = 0;
            answer = "";
            sb = new StringBuilder();

            for (int j = 0; j < 4; j++) {
                String line = br.readLine();
                for (int k = 0; k < 4; k++) {
                    board[j][k] = line.charAt(k);
                }
            }

            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (root.hasChild(board[y][x])) {
                        search(y, x, root.getChild(board[y][x]));
                    }
                }
            }

            System.out.println(sum + " " + answer + " " + count);
            root.clearHit();
            br.readLine();
        }
    }

    static void search(int y, int x, TrieNode node) {
        // 1. 체크인
        visited[y][x] = true;
        sb.append(board[y][x]);
        // 2. 목적지 : 현재 문자열 trie에 단어로 존재하는지
        if (node.isWord == true && node.isHit == false) {
            node.isHit = true;
            String foundWord = sb.toString();
            int length = foundWord.length();
            sum += checkPoint(length);
            count++;

            if (length > answer.length()) {
                answer = foundWord;
            } else if (length == answer.length()) {
                if (foundWord.compareTo(answer) < 0) {
                    answer = foundWord;
                }
            }
        }

        // 3. 연결 순회
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 4. 갈 수 있는가 ?
            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && visited[ny][nx] == false) {
                if (visited[ny][nx] == false && node.hasChild(board[ny][nx])) {
                    // 5. 간다
                    search(ny, nx, node.getChild(board[ny][nx]));
                }
            }
        }

        // 체크 아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    static int checkPoint(int length) {
        if (length == 1 || length == 2) {
            return 0;
        } else if (length == 3 || length == 4) {
            return 1;
        } else if (length == 5) {
            return 2;
        } else if (length == 6) {
            return 3;
        } else if (length == 7) {
            return 5;
        } else if (length == 8) {
            return 11;
        } else {
            return 0;
        }
    }
    
    static void insertTrieNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            int index = a - 'A';
            if (current.child[index] == null) {
                current.child[index] = new TrieNode();
            }
            current = current.child[index];
        }
        current.isWord = true;
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