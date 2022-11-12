package 데코.일번;

@FunctionalInterface
public interface Operator<T> {
    int calculation(int leftOperand, int rightOperand);
}
