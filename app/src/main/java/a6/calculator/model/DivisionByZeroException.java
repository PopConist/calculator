package a6.calculator.model;

public class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {
        super("Division by 0");
    }
}
