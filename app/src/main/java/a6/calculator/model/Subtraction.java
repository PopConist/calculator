package a6.calculator.model;

public class Subtraction implements Operation {
    StackCalculator calc;

    public Subtraction(StackCalculator calc) {
        this.calc = calc;
    }

    @Override
    public void apply() throws OverflowException, NotEnoughArgumentsException {
        calc.subtract();
    }
}
