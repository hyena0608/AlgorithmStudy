package 인프런_자바_알고리즘_문제_기초.재귀함수;

/**
 * @author hyena
 */
public class Main {
    public void DFS(int n) {
        System.out.println(n);
        DFS(n - 1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        T.DFS(3);
    }
}
