package a6.calculator.model;

public class Division implements Operation {
    StackCalculator calc;

    public Division(StackCalculator calc) {
        this.calc = calc;
    }

    @Override
    public void apply() throws OverflowException, NotEnoughArgumentsException, DivisionByZeroException {
        calc.divide();
    }
}
