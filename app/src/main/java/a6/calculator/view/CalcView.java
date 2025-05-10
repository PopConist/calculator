package a6.calculator.view;

import android.widget.TextView;

import a6.calculator.MainActivity;
import a6.calculator.R;
import a6.calculator.controller.*;
import a6.calculator.model.StackCalculator;

/**
 * Class that holds methods and variables related to the view
 * of the calculator app
 */
public class CalcView {
    private MainActivity mainActivity;
    private static StackCalculator calc;
    public static TextView displayText;
    public static TextView stackText;
    public static StringBuilder inputBuffer = new StringBuilder("0");

    /**
     * Constructor for the CalcView class instantiates MainActivity and
     * StackCalculator objects as well as the displayText and stackText TextViews.
     * @param mainActivity
     * @param calc
     */
    public CalcView(MainActivity mainActivity, StackCalculator calc) {
        this.mainActivity = mainActivity;
        this.calc = calc;
        displayText = mainActivity.findViewById(R.id.display);
        stackText = mainActivity.findViewById(R.id.stack);
    }

    /**
     * Method that updates the stack and display textViews,
     * takes in a DisplayState enum.
     * @param displayState
     */
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
