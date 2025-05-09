
package a6.calculator.controller;

import android.widget.Button;
import android.widget.TextView;

import a6.calculator.MainActivity;
import a6.calculator.R;
import a6.calculator.model.*;

public class Controller{
    private final MainActivity mainActivity;
    private final StackCalculator calc;
    private final a6.calculator.view.calcView calcView;
    public DisplayState displayState = DisplayState.INPUT;

    public Controller(MainActivity mainActivity, StackCalculator calc, a6.calculator.view.calcView calcView) {
        this.mainActivity = mainActivity;
        this.calc = calc;
        this.calcView = calcView;
    }

    public void initButtons() {

        a6.calculator.view.calcView.updateDisplay(displayState);

        int[] digitIds = {
            R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four,
            R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine
        };

        for (int i = 0; i < digitIds.length; i++) {
            int digit = i;
            Button btn = mainActivity.findViewById(digitIds[i]);
            btn.setOnClickListener(v -> onDigitPressed(digit));
        }

        mainActivity.findViewById(R.id.plusminus).setOnClickListener(v -> onSignToggle());
        mainActivity.findViewById(R.id.enter).setOnClickListener(v -> onEnterPressed());
        mainActivity.findViewById(R.id.clear).setOnClickListener(v -> {
            calc.clear();
            calcView.inputBuffer = new StringBuilder("0");
            displayState = DisplayState.INPUT;
            a6.calculator.view.calcView.updateDisplay(displayState);
        });

        mainActivity.findViewById(R.id.add).setOnClickListener(v -> performOperation(new Addition(calc)));
        mainActivity.findViewById(R.id.sub).setOnClickListener(v -> performOperation(new Subtraction(calc)));
        mainActivity.findViewById(R.id.mul).setOnClickListener(v -> performOperation(new Multiplication(calc)));
        mainActivity.findViewById(R.id.div).setOnClickListener(v -> performOperation(new Division(calc)));
    }

    private void onDigitPressed(int digit) {
        if (displayState != DisplayState.INPUT) {
            calcView.inputBuffer = new StringBuilder("0");
            displayState = DisplayState.INPUT;
        }
        if (calcView.inputBuffer.toString().equals("0")) {
            calcView.inputBuffer = new StringBuilder(String.valueOf(digit));
        } else {
            calcView.inputBuffer.append(digit);
        }
        calcView.updateDisplay(displayState);
    }

    private void onSignToggle() {
        if (displayState != DisplayState.INPUT) {
            calcView.inputBuffer = new StringBuilder("-0");
            displayState = DisplayState.INPUT;
        } else {
            if (calcView.inputBuffer.charAt(0) == '-') {
                calcView.inputBuffer.deleteCharAt(0);
            } else {
                calcView.inputBuffer.insert(0, '-');
            }
        }
        calcView.updateDisplay(displayState);
    }

    private void onEnterPressed() {
        if (displayState == DisplayState.ERROR) return;

        try {
            int value = Integer.parseInt(a6.calculator.view.calcView.inputBuffer.toString());
            calc.push(value);
            displayState = DisplayState.STACK;
            a6.calculator.view.calcView.updateDisplay(displayState);
        } catch (NumberFormatException e) {
            calcView.displayText.setText("Overflow");
            displayState = DisplayState.ERROR;
        }
    }
    private void performOperation(Operation op) {
        if (displayState == DisplayState.INPUT) {
            try {
                int value = Integer.parseInt(calcView.inputBuffer.toString());
                calc.push(value);
            } catch (NumberFormatException e) {
                calcView.displayText.setText("Overflow");
                displayState = DisplayState.ERROR;
                return;
            }
        }

        try {
            op.apply();
            displayState = DisplayState.STACK;
            calcView.updateDisplay(displayState);
        } catch (NotEnoughArgumentsException e) {
            calcView.displayText.setText("Not enough args");
            displayState = DisplayState.ERROR;
        } catch (DivisionByZeroException e) {
            calcView.displayText.setText("Division by 0");
            displayState = DisplayState.ERROR;
        } catch (OverflowException e) {
            calcView.displayText.setText("Overflow");
            displayState = DisplayState.ERROR;
        }
    }
}
