package a6.calculator.controller;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

import a6.calculator.R;

import a6.calculator.MainActivity;
import a6.calculator.model.StackCalculator;

public class Controller {
    MainActivity mainActivity;
    StackCalculator calculator;
    private TextView displayText;
    private TextView stackText;
    public Controller(MainActivity mainActivity, StackCalculator calculator) {
        this.mainActivity = mainActivity;
        this.calculator = calculator;
    }
    public void initButtons(){
        displayText = mainActivity.findViewById(R.id.display);
        stackText = mainActivity.findViewById(R.id.stack);

        Button addButton = mainActivity.findViewById(R.id.add);
        addButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Add clicked");
        });
        Button subButton = mainActivity.findViewById(R.id.sub);
        subButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Sub clicked");
        });
        Button mulButton = mainActivity.findViewById(R.id.mul);
        mulButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Mul clicked");
        });
        Button divButton = mainActivity.findViewById(R.id.div);
        divButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Div clicked");
        });
        Button clrButton = mainActivity.findViewById(R.id.clear);
        clrButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Clear stack");
        });
        Button oneButton = mainActivity.findViewById(R.id.one);
        Button twoButton = mainActivity.findViewById(R.id.two);
        Button threeButton = mainActivity.findViewById(R.id.three);
        Button fourButton = mainActivity.findViewById(R.id.four);
        Button fiveButton = mainActivity.findViewById(R.id.five);
        Button sixButton = mainActivity.findViewById(R.id.six);
        Button sevenButton = mainActivity.findViewById(R.id.seven);
        Button eightButton = mainActivity.findViewById(R.id.eight);
        Button nineButton = mainActivity.findViewById(R.id.nine);
        Button signButton = mainActivity.findViewById(R.id.plusminus);
        Button zeroButton = mainActivity.findViewById(R.id.zero);
        Button enterButton = mainActivity.findViewById(R.id.enter);
    }
}
