package a6.calculator.model;

/**
 * Class that implements the Operation interface,
 * used to pass addition method.
 */
public class Addition implements Operation{
    StackCalculator calc;

    /**
     * Constructor for addition class, takes in a stackCalculator parameter
     * @param calc
     */
    public Addition(StackCalculator calc){ this.calc = calc; }

    /**
     * Method implemented from the Operations interface, invokes the
     * add method from the StackCalc class.
     * @throws OverflowException
     * @throws NotEnoughArgumentsException
     */
    @Override
    public void apply() throws OverflowException, NotEnoughArgumentsException {
        calc.add();
    }
}
