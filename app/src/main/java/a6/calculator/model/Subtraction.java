package a6.calculator.model;

/**
 * Class that implements the Operation interface,
 * used to pass subtraction method.
 */
public class Subtraction implements Operation {
    StackCalculator calc;

    /**
     * Constructor for Subtraction class, takes in a stackCalculator parameter
     * @param calc
     */
    public Subtraction(StackCalculator calc) {
        this.calc = calc;
    }

    /**
     * Method implemented from the Operations interface, invokes the
     * subtract method from the StackCalc class.
     * @throws OverflowException
     * @throws NotEnoughArgumentsException
     */
    @Override
    public void apply() throws OverflowException, NotEnoughArgumentsException {
        calc.subtract();
    }
}
