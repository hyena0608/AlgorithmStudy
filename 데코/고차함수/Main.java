//package 데코.고차함수;
//
//import java.util.*;
//
//import static 데코.고차함수.Operator.MINUS;
//import static 데코.고차함수.Operator.PLUS;
//
//enum Operator {
//    MINUS("-"),
//    PLUS("+");
//
//    private final String operator;
//
//    Operator(String operator) {
//        this.operator = operator;
//    }
//
//    public int plus(int leftOperand, int rightOperand) {
//        return leftOperand + rightOperand;
//    }
//
//    public int minus(int leftOperand, int rightOperand) {
//        return leftOperand - rightOperand;
//    }
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//        Operator operator = PLUS;
//        List<String> words = new ArrayList<>();
//        Collections.sort(words, (o1, o2) -> o1.compareTo(o2));
//
//    }
//
//    private static int calculate(int leftOperand, int rightOperand, Operator operator) {
//        int result = 0;
//        if (operator == PLUS) {
//            result = operator.plus(leftOperand, rightOperand);
//        }
//        if (operator == MINUS) {
//            result = operator.minus(leftOperand, rightOperand);
//        }
//
//        return result;
//    }
//
//}
//
//class User {
//
//    private final int leftOperand = 1;
//    private final int rightOperand = 2;
//
//    public int calculate() {
//
//    }
//
//    private static void changeOperator(Operator operator) {
//        if (operator == PLUS) {
//            operator = MINUS;
//        } else if (operator == MINUS) {
//            operator = PLUS;
//        }
//    }
//}
