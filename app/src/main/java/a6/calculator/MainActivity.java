package a6.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import a6.calculator.model.StackCalculator;

public class MainActivity extends AppCompatActivity {

    private StackCalculator calculator;
    private TextView displayText;
    private TextView stackText;
    private String stackStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new StackCalculator();

        displayText = findViewById(R.id.display);
        stackText = findViewById(R.id.stack);

        Button addButton = findViewById(R.id.add);
        addButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Add clicked");
        });
        Button subButton = findViewById(R.id.sub);
        subButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Sub clicked");
        });
        Button mulButton = findViewById(R.id.mul);
        mulButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Mul clicked");
        });
        Button divButton = findViewById(R.id.div);
        divButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Div clicked");
        });
        Button clrButton = findViewById(R.id.clear);
        clrButton.setOnClickListener(v -> {
            stackText.setText("Stack size: " + calculator.size());
            displayText.setText("Clear stack");
        });
        Button oneButton = findViewById(R.id.one);
        Button twoButton = findViewById(R.id.two);
        Button threeButton = findViewById(R.id.three);
        Button fourButton = findViewById(R.id.four);
        Button fiveButton = findViewById(R.id.five);
        Button sixButton = findViewById(R.id.six);
        Button sevenButton = findViewById(R.id.seven);
        Button eightButton = findViewById(R.id.eight);
        Button nineButton = findViewById(R.id.nine);
        Button signButton = findViewById(R.id.plusminus);
        Button zeroButton = findViewById(R.id.zero);
        Button enterButton = findViewById(R.id.enter);
    }
}
