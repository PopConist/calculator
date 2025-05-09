package a6.calculator.view;

import android.widget.TextView;

import a6.calculator.MainActivity;
import a6.calculator.R;
import a6.calculator.controller.*;
import a6.calculator.model.StackCalculator;


public class calcView {
    private MainActivity mainActivity;
    private static StackCalculator calc;
    public static TextView displayText;
    public static TextView stackText;
    public static StringBuilder inputBuffer = new StringBuilder("0");
    public calcView(MainActivity mainActivity, StackCalculator calc) {
        this.mainActivity = mainActivity;
        this.calc = calc;
        displayText = mainActivity.findViewById(R.id.display);
        stackText = mainActivity.findViewById(R.id.stack);
    }

    public static void updateDisplay(DisplayState displayState) {
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
