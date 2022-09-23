package 코트.구현력.완전탐색.기준새로설정.ABCD찾기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final static int MAX_NUMBERS_SIZE = 15;
    private final static int MAX_NUMBER = 37;
    private final static int NUMBER_COUNT = 4;

    private static List<Integer> givenMixedNumbers;

    public static void main(String[] args) throws Exception {
        givenMixedNumbers = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < MAX_NUMBERS_SIZE; i++) {
            givenMixedNumbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(givenMixedNumbers);

        int findA = 0, findB = 0, findC = 0, findD = 0;
        outer:
        for (int a = 1; a <= MAX_NUMBER; a++) {
            for (int b = 1; b <= MAX_NUMBER; b++) {
                for (int c = 1; c <= MAX_NUMBER; c++) {
                    for (int d = 1; d <= MAX_NUMBER; d++) {
                        List<Integer> createdMixedNumbers = createMixedNumbers(new int[]{a, b, c, d});
                        if (isSameList(createdMixedNumbers, givenMixedNumbers)) {
                            findA = a;
                            findB = b;
                            findC = c;
                            findD = d;
                            break outer;
                        }
                    }
                }
            }
        }

        System.out.println(findA + " " + findB + " " + findC + " " + findD);
    }

    private static List<Integer> createMixedNumbers(int[] abcd) {
        List<Integer> createdMixedNumbers = new ArrayList<>();
        addOneOperandsPlus(createdMixedNumbers, abcd);
        addTwoOperandsPlus(createdMixedNumbers, abcd);
        addThreeOperandsPlus(createdMixedNumbers, abcd);
        addFourOperandsPlus(createdMixedNumbers, abcd);
        Collections.sort(createdMixedNumbers);
        return createdMixedNumbers;
    }

    private static void addFourOperandsPlus(List<Integer> findResult, int[] selectedNumbers) {
        findResult.add(
                selectedNumbers[0] +
                        selectedNumbers[1] +
                        selectedNumbers[2] +
                        selectedNumbers[3]
        );
    }

    private static boolean isSameList(List<Integer> givenNumbers, List<Integer> mixedNumbers) {
        for (int idx = 0; idx < MAX_NUMBERS_SIZE; idx++) {
            if (!Objects.equals(givenNumbers.get(idx), mixedNumbers.get(idx))) return false;
        }
        return true;
    }

    private static void addOneOperandsPlus(List<Integer> findResult, int[] selectedNumbers) {
        Arrays.stream(selectedNumbers).forEach(findResult::add);
    }

    private static void addTwoOperandsPlus(List<Integer> findResult, int[] selectedNumbers) {
        for (int operandOne = 0; operandOne < NUMBER_COUNT - 1; operandOne++) {
            for (int operandTwo = operandOne + 1; operandTwo < NUMBER_COUNT; operandTwo++) {
                findResult.add(
                        (selectedNumbers[operandOne] + selectedNumbers[operandTwo])
                );
            }
        }
    }

    private static void addThreeOperandsPlus(List<Integer> findResult, int[] selectedNumbers) {
        for (int operandOne = 0; operandOne < NUMBER_COUNT - 2; operandOne++) {
            for (int operandTwo = operandOne + 1; operandTwo < NUMBER_COUNT - 1; operandTwo++) {
                for (int operandThree = operandTwo + 1; operandThree < NUMBER_COUNT; operandThree++) {
                    findResult.add(
                            (selectedNumbers[operandOne] +
                                    selectedNumbers[operandTwo] +
                                    selectedNumbers[operandThree])
                    );
                }
            }
        }
    }

}
