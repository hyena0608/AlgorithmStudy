package 라이브러리.순열;

/**
 * 자바로 순열 구하기
 * swap으로 순열 구현하기
 */
public class PermutationBySwap {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = 4;
        int r = 3;

        permutation(arr, 0, n, r);
    }
    public static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    private static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    private static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
