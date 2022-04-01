package 인프런_자바_알고리즘_문제_기초.이진트레벨탐색BFS;

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
    public void bfs(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);

        while(!Q.isEmpty()) {
            Node polledQ = Q.remove();
            System.out.print(polledQ.data + " ");
            if (polledQ.lt != null) Q.offer(polledQ.lt);
            if (polledQ.rt != null) Q.offer(polledQ.rt);
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.bfs(tree.root);
    }
}
