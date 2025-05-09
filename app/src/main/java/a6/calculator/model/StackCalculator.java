package a6.calculator.model;

import java.util.LinkedList;
import java.util.EmptyStackException;
import java.lang.Math;

public class StackCalculator extends LinkedList<Integer>{

    public void add() throws NotEnoughArgumentsException, OverflowException {
        if (size() < 2) {
            throw new NotEnoughArgumentsException();
        }
        int b = pop();
        int a = pop();
        try {
            int result = Math.addExact(a, b);
            push(result);
        } catch (ArithmeticException e) {
            throw new OverflowException();
        }
    }

    public void subtract() throws NotEnoughArgumentsException, OverflowException {
        if (size() < 2) {
            throw new NotEnoughArgumentsException();
        }
        int b = pop();
        int a = pop();
        try {
            int result = Math.subtractExact(a, b);
            push(result);
        } catch (ArithmeticException e) {
            throw new OverflowException();
        }
    }

    public void multiply() throws NotEnoughArgumentsException, OverflowException {
        if (size() < 2) {
            throw new NotEnoughArgumentsException();
        }
        int b = pop();
        int a = pop();
        try {
            int result = Math.multiplyExact(a, b);
            push(result);
        } catch (ArithmeticException e) {
            throw new OverflowException();
        }
    }

    public void divide() throws NotEnoughArgumentsException, DivisionByZeroException, OverflowException {
        if (size() < 2) {
            throw new NotEnoughArgumentsException();
        }
        int b = pop();
        int a = pop();
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        try {
            int result = Math.floorDiv(a, b);
            push(result);
        } catch (ArithmeticException e) {
            throw new OverflowException();
        }
    }
}