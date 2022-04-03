package 인프런_자바_알고리즘_문제_기초.최단거리BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hyena
 */
class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int val) {
        this.data = val;
        this.lt = null;
        this.rt = null;
    }
}
public class Main {
    Node root;
    public int bfs(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = Q.poll();
                if (currentNode.lt == null && currentNode.rt == null) return L;
                if (currentNode.lt != null) Q.offer(currentNode.lt);
                if (currentNode.rt != null) Q.offer(currentNode.rt);
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.bfs(tree.root));
    }
}
