package a6.calculator.model;

/**
 * Interface that houses the apply method.
 */
@FunctionalInterface
public interface Operation {
    /**
     * Method used by classes that Implement the Operation interface
     * @throws NotEnoughArgumentsException
     * @throws OverflowException
     * @throws DivisionByZeroException
     */
    void apply() throws NotEnoughArgumentsException, OverflowException, DivisionByZeroException;
}
