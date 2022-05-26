package 백준.자바.골드바흐의추측;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nList = new ArrayList<>();
        boolean[] sosu = new boolean[1000001];

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                nList.add(n);
            }
        }

        T.makeSosuArr(sosu);
        for (Integer num : nList) {
            T.findRightOperation(sosu, num);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void makeSosuArr(boolean[] sosu) {
        for (int i = 3; i <= 1000000; i++) {
            if (isSosu(i)) {
                sosu[i] = true;
            }
        }
    }

    private boolean isSosu(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void findRightOperation(boolean[] sosu, int num) throws IOException {
        for (int i = 3; i <= num / 2; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            if (sosu[i] && sosu[num - i]) {
                stringBuilder.append(num)
                        .append(" = ")
                        .append(i)
                        .append(" + ")
                        .append(num - i)
                        .append("\n");
                bw.write(String.valueOf(stringBuilder));
                return;
            }
        }
        bw.write("Goldbach's conjecture is wrong.\n");
    }
}
