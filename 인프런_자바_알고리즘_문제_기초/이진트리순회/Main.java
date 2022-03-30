package 인프런_자바_알고리즘_문제_기초.이진트리순회;

/**
 * @author hyena
 */
class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}
public class Main {
    Node root;
    public void DFS(Node root) {
        if (root == null) return;
        else {
            DFS(root.lt);
            System.out.println(root.data + " ");
            DFS(root.rt);
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
        tree.DFS(tree.root);
    }
}
