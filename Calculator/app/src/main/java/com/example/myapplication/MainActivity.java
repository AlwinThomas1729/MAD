
package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String input = ""; // Holds the current input
    private String operator = ""; // Holds the current operator
    private double result = 0; // Stores the current result
    private boolean isNewOperation = true; // Tracks if a new operation has started

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Initialize buttons
        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);

        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSub = findViewById(R.id.btn_sub);
        Button btnMul = findViewById(R.id.btn_mul);
        Button btnDiv = findViewById(R.id.btn_div);

        Button btnClr = findViewById(R.id.btn_clr);
        Button btnEq = findViewById(R.id.btn_eq);

        // Number button listeners
        btn0.setOnClickListener(v -> appendNumber("0"));
        btn1.setOnClickListener(v -> appendNumber("1"));
        btn2.setOnClickListener(v -> appendNumber("2"));
        btn3.setOnClickListener(v -> appendNumber("3"));
        btn4.setOnClickListener(v -> appendNumber("4"));
        btn5.setOnClickListener(v -> appendNumber("5"));
        btn6.setOnClickListener(v -> appendNumber("6"));
        btn7.setOnClickListener(v -> appendNumber("7"));
        btn8.setOnClickListener(v -> appendNumber("8"));
        btn9.setOnClickListener(v -> appendNumber("9"));

        // Operator button listeners
        btnAdd.setOnClickListener(v -> applyOperator("+"));
        btnSub.setOnClickListener(v -> applyOperator("-"));
        btnMul.setOnClickListener(v -> applyOperator("*"));
        btnDiv.setOnClickListener(v -> applyOperator("/"));

        // Clear button
        btnClr.setOnClickListener(v -> clear());

        // Equal button
        btnEq.setOnClickListener(v -> showResult());
    }

    private void appendNumber(String num) {
        if (isNewOperation) {
            input = ""; // Clear the input if starting a new operation
            isNewOperation = false;
        }
        input += num;
        display.setText(input);
    }

    private void applyOperator(String op) {
        if (!input.isEmpty()) {
            double currentInput = Double.parseDouble(input);

            // Perform the previous operation before setting a new operator
            if (!operator.isEmpty()) {
                result = performOperation(result, currentInput, operator);
            } else {
                result = currentInput; // Set the first number as the result
            }

            display.setText(String.valueOf(result));
            input = ""; // Clear input for the next operand
            operator = op; // Update the operator
            isNewOperation = true; // Ready for the next input
        }
    }

    private double performOperation(double operand1, double operand2, String op) {
        switch (op) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return operand1;
                }
            default:
                return operand1;
        }
    }

    private void showResult() {
        if (!input.isEmpty() && !operator.isEmpty()) {
            double currentInput = Double.parseDouble(input);
            result = performOperation(result, currentInput, operator);
            display.setText(String.valueOf(result));
            input = ""; // Reset input
            operator = ""; // Reset operator
            isNewOperation = true; // Ready for a new operation
        }
    }

    private void clear() {
        input = "";
        operator = "";
        result = 0;
        display.setText("");
        isNewOperation = true;
    }
}
