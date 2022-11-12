package 데코.이번;

@FunctionalInterface
public interface Operator {
    int calculation(int leftOperand, int rightOperand);

    default int returnZero() {
        return 0;
    }

    static int returnOne() {
        return 1;
    }
}
