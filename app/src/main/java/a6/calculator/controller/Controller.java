
package a6.calculator.controller;

import android.widget.Button;
import android.widget.TextView;

import a6.calculator.MainActivity;
import a6.calculator.R;
import a6.calculator.model.*;

public class Controller{
    enum DisplayState { INPUT, STACK, ERROR }

    private final MainActivity mainActivity;
    private final StackCalculator calc;
    private TextView displayText;
    private TextView stackText;
    private DisplayState displayState = DisplayState.INPUT;
    private StringBuilder inputBuffer = new StringBuilder("0");

    public Controller(MainActivity mainActivity, StackCalculator calc) {
        this.mainActivity = mainActivity;
        this.calc = calc;
    }

    public void initButtons() {
        displayText = mainActivity.findViewById(R.id.display);
        stackText = mainActivity.findViewById(R.id.stack);

        updateDisplay();

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
            inputBuffer = new StringBuilder("0");
            displayState = DisplayState.INPUT;
            updateDisplay();
        });

        mainActivity.findViewById(R.id.add).setOnClickListener(v -> performOperation(new Addition(calc)));
        mainActivity.findViewById(R.id.sub).setOnClickListener(v -> performOperation(new Subtraction(calc)));
        mainActivity.findViewById(R.id.mul).setOnClickListener(v -> performOperation(new Multiplication(calc)));
        mainActivity.findViewById(R.id.div).setOnClickListener(v -> performOperation(new Division(calc)));
    }

    private void onDigitPressed(int digit) {
        if (displayState != DisplayState.INPUT) {
            inputBuffer = new StringBuilder("0");
            displayState = DisplayState.INPUT;
        }
        if (inputBuffer.toString().equals("0")) {
            inputBuffer = new StringBuilder(String.valueOf(digit));
        } else {
            inputBuffer.append(digit);
        }
        updateDisplay();
    }

    private void onSignToggle() {
        if (displayState != DisplayState.INPUT) {
            inputBuffer = new StringBuilder("-0");
            displayState = DisplayState.INPUT;
        } else {
            if (inputBuffer.charAt(0) == '-') {
                inputBuffer.deleteCharAt(0);
            } else {
                inputBuffer.insert(0, '-');
            }
        }
        updateDisplay();
    }

    private void onEnterPressed() {
        if (displayState == DisplayState.ERROR) return;

        try {
            int value = Integer.parseInt(inputBuffer.toString());
            calc.push(value);
            displayState = DisplayState.STACK;
            updateDisplay();
        } catch (NumberFormatException e) {
            displayText.setText("Overflow");
            displayState = DisplayState.ERROR;
        }
    }
    private void performOperation(Operation op) {
        if (displayState == DisplayState.INPUT) {
            try {
                int value = Integer.parseInt(inputBuffer.toString());
                calc.push(value);
            } catch (NumberFormatException e) {
                displayText.setText("Overflow");
                displayState = DisplayState.ERROR;
                return;
            }
        }

        try {
            op.apply();
            displayState = DisplayState.STACK;
            updateDisplay();
        } catch (NotEnoughArgumentsException e) {
            displayText.setText("Not enough args");
            displayState = DisplayState.ERROR;
        } catch (DivisionByZeroException e) {
            displayText.setText("Division by 0");
            displayState = DisplayState.ERROR;
        } catch (OverflowException e) {
            displayText.setText("Overflow");
            displayState = DisplayState.ERROR;
        }
    }

    private void updateDisplay() {
        if (displayState == DisplayState.INPUT) {
            displayText.setText(inputBuffer.toString() + "_");
        } else if (!calc.isEmpty()) {
            displayText.setText(String.valueOf(calc.peek()));
        } else {
            displayText.setText("0");
        }

        StringBuilder stackBuilder = new StringBuilder();
        for (int i = calc.size() - 1; i >= 0; i--) {
            stackBuilder.append(calc.get(i)).append(" ");
        }
        stackText.setText(stackBuilder.toString().trim());
    }
}
