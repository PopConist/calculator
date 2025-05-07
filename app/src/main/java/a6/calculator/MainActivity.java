package a6.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import a6.calculator.controller.Controller;
import a6.calculator.model.StackCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackCalculator calculator = new StackCalculator();
        Controller controller = new Controller(this, calculator);

        controller.initButtons();
    }
}
