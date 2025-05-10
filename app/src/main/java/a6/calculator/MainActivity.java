package a6.calculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import a6.calculator.controller.Controller;
import a6.calculator.model.StackCalculator;
import a6.calculator.view.CalcView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackCalculator calculator = new StackCalculator();
        CalcView calcView = new CalcView(this, calculator);
        Controller controller = new Controller(this, calculator, calcView);
        controller.initButtons();
    }
}
