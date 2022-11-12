package 데코.일번;

public class Main {

    public static void main(String[] args) {

        Operator plus = (leftOperand, rightOperand) -> leftOperand + rightOperand;
        Operator minus = (leftOperand, rightOperand) -> leftOperand - rightOperand;
        Operator multiply = (leftOperand, rightOperand) -> leftOperand * rightOperand;
        Operator divide = (leftOperand, rightOperand) -> leftOperand / rightOperand;

        System.out.println("plus = " + plus.calculation(1, 2));
        System.out.println("minus = " + minus.calculation(1, 2));
        System.out.println("multiply = " + multiply.calculation(1, 2));
        System.out.println("divide = " + divide.calculation(1, 2));

    }
    private static int calculate(int leftOperand, int rightOperand, Operator operator) {
        return operator.calculation(leftOperand, rightOperand);
    }

}
