package 데코.이번;

import 데코.일번.Operator;

import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {
        BinaryOperator<Integer> plus = (leftOperand, rightOperand) -> leftOperand + rightOperand;
        BinaryOperator<Integer> minus = (leftOperand, rightOperand) -> leftOperand - rightOperand;
        BinaryOperator<Integer> multiply = (leftOperand, rightOperand) -> leftOperand * rightOperand;
        BinaryOperator<Integer> divide = (leftOperand, rightOperand) -> leftOperand / rightOperand;

        plus.apply(1, 2);
        minus.apply(1, 2);
        multiply.apply(1, 2);
        divide.apply(1, 2);
    }
}
