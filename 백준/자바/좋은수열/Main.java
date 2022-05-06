package 백준.자바.좋은수열;

import java.util.Scanner;

public class Main {
    static int n;

    public static void backtracking(String str) {
        if (str.length() == n) {
            System.out.print(str);
            System.exit(0);
        } else {
            for (int number = 1; number <= 3; number++) {
                if (!isDuplicated(str + number)) backtracking(str + number);
            }
        }
    }

    public static boolean isDuplicated(String str) {
        for (int searchRange = 1; searchRange <= str.length() / 2; searchRange++) {
            if (isStringEqual(str, searchRange)) return true;
        }
        return false;
    }

    public static boolean isStringEqual(String str, int searchRange) {
        String currentStr = str.substring(str.length() - searchRange);
        String pastStr = str.substring(str.length() - searchRange * 2, str.length() - searchRange);
        return currentStr.equals(pastStr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        backtracking("");
    }
}
