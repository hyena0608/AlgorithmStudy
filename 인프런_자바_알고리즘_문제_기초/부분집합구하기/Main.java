package 인프런_자바_알고리즘_문제_기초.부분집합구하기;

/**
 * @author hyena
 */
public class Main {
    static int n;
    static int[] ch;

    public void dfs(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) tmp += i + " ";
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        }
        else {
            ch[L] = 1;
            dfs(L + 1);
            ch[L] = 0;
            dfs(L + 1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n + 1];
        T.dfs(1);
    }
}
