package 백준.자바.게으른백곰_10025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;
    static int MAX_X = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[MAX_X + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }


        if (K < 500000) {
            int albert = K;
            int maxIce = 0;
            int currIce = 0;
            for (int i = 0; i <= K * 2; i++) {
                currIce += arr[i];
                maxIce += arr[i];
            }

            while (albert + K + 1 <= MAX_X) {
                currIce -= arr[albert++ - K];
                currIce += arr[albert + K];

                maxIce = Math.max(maxIce, currIce);
            }
            System.out.println(maxIce);
        } else {
            System.out.println(Arrays.stream(arr).sum());
        }

    }
}
