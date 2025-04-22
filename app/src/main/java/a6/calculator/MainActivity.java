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
    }
}
