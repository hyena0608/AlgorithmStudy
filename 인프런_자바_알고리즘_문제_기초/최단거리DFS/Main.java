package 인프런_자바_알고리즘_문제_기초.최단거리DFS;

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
    public int dfs(int L, Node root) {
        if (root.lt == null && root.rt == null) return L;
        else return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt));
    }

    public static void main(String[] args) {
        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.dfs(0, tree.root));
    }
}
