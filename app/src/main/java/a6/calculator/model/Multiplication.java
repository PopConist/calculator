package a6.calculator.model;

public class Multiplication implements Operation{
    StackCalculator calc;

    public Multiplication(StackCalculator calc) {
        this.calc = calc;
    }

    @Override
    public void apply() throws OverflowException, NotEnoughArgumentsException {
        calc.multiply();
    }
}