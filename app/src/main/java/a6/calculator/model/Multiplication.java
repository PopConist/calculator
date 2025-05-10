package a6.calculator.model;

/**
 * Class that implements the Operation interface,
 * used to pass multiplication method.
 */
public class Multiplication implements Operation{
    StackCalculator calc;

    /**
     * Constructor for Multiplication class, takes in a stackCalculator parameter
     * @param calc
     */
    public Multiplication(StackCalculator calc) {
        this.calc = calc;
    }

    /**
     * Method implemented from the Operations interface, invokes the
     * multiply method from the StackCalc class.
     * @throws OverflowException
     * @throws NotEnoughArgumentsException
     */
    @Override
    public void apply() throws OverflowException, NotEnoughArgumentsException {
        calc.multiply();
    }
}