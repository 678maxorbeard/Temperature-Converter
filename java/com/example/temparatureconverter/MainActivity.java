package com.example.temparatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputTemp;
    private TextView outputTemp;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputTemp = findViewById(R.id.inputTemp);
        outputTemp = findViewById(R.id.outputTemp);
        convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void convertTemperature() {
        String input = inputTemp.getText().toString();
        if (!input.isEmpty()) {
            double temp = Double.parseDouble(input);
            String result;
            if (inputTemp.getHint().equals("Enter Celsius")) {
                result = String.format("%.2f", (temp * 9/5) + 32) + " °F";
            } else {
                result = String.format("%.2f", (temp - 32) * 5/9) + " °C";
            }
            outputTemp.setText(result);
        } else {
            outputTemp.setText("Please enter a temperature.");
        }
    }
}
