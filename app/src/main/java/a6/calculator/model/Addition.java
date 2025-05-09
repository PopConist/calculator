package a6.calculator.model;

public class Addition implements Operation{
    StackCalculator calc;

    public Addition(StackCalculator calc){
        this.calc = calc;
    }

    @Override
    public void apply() throws OverflowException, NotEnoughArgumentsException {
        calc.add();
    }
}
