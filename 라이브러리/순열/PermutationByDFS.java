package 라이브러리.순열;

public class PermutationByDFS {

    public static void main(String[] args) {
        int n = 4;
        int r = 3;
        int[] arr = {1, 2, 3, 4};
        int[] answer = new int[n];
        boolean[] visited = new boolean[n];

        permutation(arr, answer,visited, 0, n, r);
    }

    public static void permutation(int[] arr, int[] answer, boolean visited[], int depth, int n, int r) {
        if (depth == r) {
            print(answer, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                answer[depth] = arr[i];
                permutation(arr, answer, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    private static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
