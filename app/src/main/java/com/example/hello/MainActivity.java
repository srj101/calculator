package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView outputTextView;
    public Double memoryNumber= 0.0;
    public Double firstNumber = 0.0;
    public Double secondNumber = 0.0;

    public String currentOperation = "+";


    public void showError(String error) {
        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
    }

    public void appendText(String value){
        if(outputTextView.getText().toString().equals("0")){
            outputTextView.setText("");
        }
        outputTextView.setText(outputTextView.getText().toString()+value);
    }

    public void setResult(String value){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputTextView = findViewById(R.id.res);
    }

    public void calculate(View view) {
        Double finalValue = 0.0;
        try {
            secondNumber = Double.parseDouble(outputTextView.getText().toString());

            switch(currentOperation){
                case "+":
                    finalValue = firstNumber + secondNumber;
                    outputTextView.setText(String.valueOf(finalValue));
                    break;
                case "-":
                    finalValue = firstNumber - secondNumber;
                    outputTextView.setText(String.valueOf(finalValue));
                    break;
                case "*":
                    finalValue = firstNumber*secondNumber;
                    outputTextView.setText(String.valueOf(finalValue));
                    break;
                case "/":
                    finalValue = firstNumber/secondNumber;
                    outputTextView.setText(String.valueOf(finalValue));
                    break;
            }

        }catch (Exception e){
            showError(e.getMessage().toString());
        }
        firstNumber = finalValue;
    }

    public void addPoint(View view) {
        if (outputTextView.getText().toString().contains(".")){
            return;
        }
        appendText(".");
    }

    public void addition(View view) {
        String value = outputTextView.getText().toString();
        if (value=="." || value.length() ==0){
            return;
        }
        else {
            try {

                firstNumber =  Double.parseDouble(value);

                outputTextView.setText("0");
                currentOperation = "+";
            }catch (Exception e){
                showError(e.getMessage().toString());
            }
        }
    }



    public void memoryClear(View view) {
    }

    public void memoryRead(View view) {
    }

    public void memoryStore(View view) {
    }

    public void addWithMemory(View view) {
    }

    public void diffWithMemory(View view) {
    }

    public void delete(View view) {
        String value = outputTextView.getText().toString();
        if (value.length()==0){
            return;
        }
        outputTextView.setText(value.substring(0, value.length() - 1));

        try {
            firstNumber = Double.parseDouble(value.substring(0, value.length() - 1));
        }catch (Exception e){
            showError(e.getMessage().toString());
        }
    }

    public void clearScreen(View view) {
        outputTextView.setText("0");

    }

    public void clearAll(View view) {
        memoryNumber = 0.0;
        firstNumber = 0.0;
        secondNumber = 0.0;
        outputTextView.setText("0");
    }

    public void togglePlusMinus(View view) {
        String value = outputTextView.getText().toString();
        if (value=="." || value.length() ==0){
            return;
        }
        try {
            firstNumber = Double.parseDouble(value);

            firstNumber*=-1;

            outputTextView.setText(String.valueOf(firstNumber));
        }catch (Exception e){
            showError(e.getMessage().toString());
        }
    }

    public void rootOperate(View view) {
        String value = outputTextView.getText().toString();
        if (value=="." || value.length() ==0){
            return;
        }

            try {
                firstNumber = Double.parseDouble(value);
                firstNumber = Math.sqrt(firstNumber);
                outputTextView.setText(String.valueOf(firstNumber));
            }catch (Exception e){
                showError(e.getMessage().toString());
            }

    }

    public void addNumber(View view) {
        int viewId = view.getId();
        Button numberBtn = findViewById(viewId);
        appendText(numberBtn.getText().toString());
    }


    public void percentOperate(View view) {
    }

    public void mulOperate(View view) {
        String value = outputTextView.getText().toString();
        if (value=="." || value.length() ==0){
            return;
        }
        else {
            try {
                firstNumber = Double.parseDouble(value);
                outputTextView.setText("0");
                currentOperation = "*";
            }catch (Exception e){
                showError(e.getMessage().toString());
            }
        }
    }

    public void inverseOperate(View view) {
        try {
            String value = outputTextView.getText().toString();
            firstNumber = 1.0/Double.parseDouble(value);
            outputTextView.setText(String.valueOf(firstNumber));
        }catch (Exception e){
            showError(e.getMessage().toString());
        }
    }

    public void subtract(View view) {
        String value = outputTextView.getText().toString();
        if (value=="." || value.length() ==0){
            return;
        }
        else {
            try {
                firstNumber = Double.parseDouble(value);
                outputTextView.setText("0");
                currentOperation = "-";
            }catch (Exception e){
                showError(e.getMessage().toString());
            }
        }
    }

    public void divideOpeate(View view) {
        String value = outputTextView.getText().toString();
        if (value=="." || value.length() ==0){
            return;
        }
        else {
            try {
                firstNumber = Double.parseDouble(value);
                outputTextView.setText("0");
                currentOperation = "/";
            }catch (Exception e){
                showError(e.getMessage().toString());
            }
        }
    }
}