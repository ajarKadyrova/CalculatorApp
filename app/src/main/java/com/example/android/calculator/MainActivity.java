package com.example.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.calculator.MESSAGE";
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayResult (Double res){
            String answer;
            Intent intent = new Intent(this, ShowResultActivity.class);
            answer = new DecimalFormat("#.###").format(res);
            String message = answer;
            intent.putExtra(EXTRA_MESSAGE,message);
            startActivity(intent);
            result = 0;
    }

    public void divideAction(View view){
        TextView sign = (TextView) findViewById(R.id.showSign);
        sign.setText("÷");
        EditText num1 = (EditText) findViewById(R.id.firstNumber);
        EditText num2 = (EditText) findViewById(R.id.secondNumber);
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();
        if(n1.matches("") || n2.matches("")){
            Toast.makeText(this, "Enter both number fields", Toast.LENGTH_SHORT).show();
        }
        else {
            Double number1 = Double.parseDouble(n1);
            Double number2 = Double.parseDouble(n2);
            if (number2 == 0) {
                Intent intent = new Intent(this, ShowResultActivity.class);
                String message = "Cannot divide by 0";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
            else {
                result = number1 / number2;
                displayResult(result);
            }
        }
    }

    public void multiplyAction(View view){
        TextView sign = (TextView) findViewById(R.id.showSign);
        sign.setText("×");
        EditText num1 = (EditText) findViewById(R.id.firstNumber);
        EditText num2 = (EditText) findViewById(R.id.secondNumber);
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();
        if(n1.matches("") || n2.matches("")){
            Toast.makeText(this, "Enter both number fields", Toast.LENGTH_SHORT).show();
        }
        else {
            Double number1 = Double.parseDouble(n1);
            Double number2 = Double.parseDouble(n2);
            result = number1 * number2;
            displayResult(result);
        }
    }

    public void additionAction(View view){
        TextView sign = (TextView) findViewById(R.id.showSign);
        sign.setText("+");
        EditText num1 = (EditText) findViewById(R.id.firstNumber);
        EditText num2 = (EditText) findViewById(R.id.secondNumber);
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();
        if(n1.matches("") || n2.matches("")){
            Toast.makeText(this, "Enter both number fields", Toast.LENGTH_SHORT).show();
        }
        else {
            Double number1 = Double.parseDouble(n1);
            Double number2 = Double.parseDouble(n2);
            result = number1 + number2;
            displayResult(result);
        }
    }

    public void subtractAction(View view){
        TextView sign = (TextView) findViewById(R.id.showSign);
        sign.setText("−");
        EditText num1 = (EditText) findViewById(R.id.firstNumber);
        EditText num2 = (EditText) findViewById(R.id.secondNumber);
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();
        if(n1.matches("") || n2.matches("")){
            Toast.makeText(this, "Enter both number fields", Toast.LENGTH_SHORT).show();
        }
        else {
            Double number1 = Double.parseDouble(n1);
            Double number2 = Double.parseDouble(n2);
            result = number1 - number2;
            displayResult(result);
        }
    }
}