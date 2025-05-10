package a6.calculator.model;

/**
 * Class that implements the Operation interface,
 * used to pass division method.
 */
public class Division implements Operation {
    StackCalculator calc;

    /**
     * Constructor for division class, takes in a stackCalculator parameter
     * @param calc
     */
    public Division(StackCalculator calc) {
        this.calc = calc;
    }

    /**
     * Method implemented from the Operations interface, invokes the
     * divide method from the StackCalc class.
     * @throws OverflowException
     * @throws NotEnoughArgumentsException
     * @throws DivisionByZeroException
     */
    @Override
    public void apply() throws OverflowException, NotEnoughArgumentsException, DivisionByZeroException {
        calc.divide();
    }
}
