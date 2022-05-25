package 백준.자바.골드바흐의추측;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    class Oper {
        int firstNum, secondNum;

        public Oper(int firstNum, int secondNum) {
            this.firstNum = firstNum;
            this.secondNum = secondNum;
        }
    }

    static List<Integer> sosuList;
    static List<Integer> nList;
    static Map<Integer, Oper> operMap;
    static int maxNum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sosuList = new ArrayList<>();
        nList = new ArrayList<>();
        operMap = new HashMap<>();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                nList.add(n);
            }
        }

        T.findBiggestNumInnList();
        T.makeSosuList(maxNum);



    }

    private void findBiggestNumInnList() {
        nList.stream().forEach(o -> {
            maxNum = Math.max(o, maxNum);
        });

    }

    private void canNotFindN() {

    }

    private void makeSosuList(int num) {
        sosuList.add(2);
        for (int i = 3; i <= num; i++) {
            if (isSosu(i)) {
                sosuList.add(i);
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

    private void isOdd() {

    }

    private void findBiggestAbs() {

    }


}
