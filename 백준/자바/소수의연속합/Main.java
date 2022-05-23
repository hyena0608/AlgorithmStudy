package 백준.자바.소수의연속합;

import java.util.*;

public class Main {
    static List<Integer> sosuList;
    static int answer;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sosuList = new ArrayList<>();
        answer = 0;

        Main T = new Main();

        T.makeSosuList(sosuList);

        for (int i = 0; i < sosuList.size(); i++) {
            T.c(i, 0);
        }

        if (T.isSosu(n)) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }

    private void makeSosuList(List<Integer> sosuList) {
        for (int num = 2; num <= n; num++) {
            if (isSosu(num)) {
                sosuList.add(num);
            }
        }
    }

    private boolean isSosu(int n) {
        int sqirtN = (int) Math.sqrt(n);
        for (int num = 2; num <= sqirtN + 1; num++) {
            if (n % num == 0) {
                return false;
            }
        }
        return true;
    }

    private void c(int L, int sum) {
        for (int i = L; i < sosuList.size(); i++) {
            if (sum + sosuList.get(i) > n) {
                break;
            } else if (sum + sosuList.get(i) == n) {
                answer++;
                break;
            } else {
                sum += sosuList.get(i);
            }
        }
    }
}