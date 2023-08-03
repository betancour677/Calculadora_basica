package com.example.calculadora;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1EditText, num2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.et_primernum);
        num2EditText = findViewById(R.id.et_segnum);
        resultTextView = findViewById(R.id.et_resultado);

        Button addBtn = findViewById(R.id.suma);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    performOperation('+');
                } else {
                    showAlert("Por favor, complete ambos campos.");
                }
            }
        });

        Button subtractBtn = findViewById(R.id.resta);
        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                performOperation('-');
            } else {
                showAlert("Por favor, complete ambos campos.");
            }
            }


        });

        Button multiplyBtn = findViewById(R.id.multiplicacion);
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    performOperation('*');
                } else {
                    showAlert("Por favor, complete ambos campos.");
                }
            }
        });

        Button divideBtn = findViewById(R.id.division);
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    performOperation('/');
                } else {
                    showAlert("Por favor, complete ambos campos.");
                }
            }
        });

        Button exitBtn = findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
        private boolean validateFields() {
            String num1 = num1EditText.getText().toString().trim();
            String num2 = num2EditText.getText().toString().trim();

            return !num1.isEmpty() && !num2.isEmpty();
        }
    private void performOperation(char operator) {
        double num1 = Double.parseDouble(num1EditText.getText().toString());
        double num2 = Double.parseDouble(num2EditText.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultTextView.setText("Error: División entre cero");
                    return;
                }
                break;
        }

        resultTextView.setText(String.valueOf(result));
    }
    private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alerta")
                .setMessage(message)
                .setPositiveButton("Aceptar", null)
                .show();
    }
}
