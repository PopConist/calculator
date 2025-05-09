package a6.calculator.model;

@FunctionalInterface
public interface Operation {
    void apply() throws NotEnoughArgumentsException, OverflowException, DivisionByZeroException;
}
