package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonAdd;
    Button buttonSubstract;
    Button buttonMul;
    Button buttonDiv;
    Button buttonClear;
    Button buttonEqual;
    String result;
    String tillOp;
    String tmp;
    String operator;
    TextView resultTextView;
    TextView ansTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initControlListener();
    }

    private void initControlListener() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("9");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearButtonClicked();
            }
        });
        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onOperatorButtonClicked("-");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("+");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("*");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("/");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualButtonClicked();
            }
        });

    }

    private void onEqualButtonClicked() {
        int res = 0;
        try {
            int number = Integer.valueOf(tmp);
            int length = tillOp.length();
            String num2 = resultTextView.getText().toString().substring(length);
            int number2 = Integer.valueOf(num2);
            switch (operator) {
                case "+":
                    res = number + number2;
                    break;
                case "/":
                    res = number / number2;
                    break;
                case "-":
                    res = number - number2;
                    break;
                case "*":
                    res = number * number2;
                    break;
            }
            result = String.valueOf(res);
            resultTextView.setText(result);
        } catch (ArithmeticException e){
            Toast.makeText(this,"Denominator cannot be zero", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void onOperatorButtonClicked(String operator) {
        tmp = resultTextView.getText().toString();
        //onClearButtonClicked();
        this.operator = operator;
        result = result + operator;
        resultTextView.setText(result);
        tillOp = result;
    }

    private void onClearButtonClicked() {

        int clearedLength = result.length();
        result = result.substring(0, clearedLength-1 );
        resultTextView.setText(result);
    }

    private void onNumberButtonClicked(String pos) {
        result = resultTextView.getText().toString();
        result = result + pos;
        resultTextView.setText(result);
    }

    private void initControl() {
        button0 = (Button)findViewById(R.id.zero);
        button1 = (Button)findViewById(R.id.one);
        button2 = (Button)findViewById(R.id.two);
        button3 = (Button)findViewById(R.id.three);
        button4 = (Button)findViewById(R.id.four);
        button5 = (Button)findViewById(R.id.five);
        button6 = (Button)findViewById(R.id.six);
        button7 = (Button)findViewById(R.id.seven);
        button8 = (Button)findViewById(R.id.eight);
        button9 = (Button)findViewById(R.id.nine);

        buttonAdd = (Button)findViewById(R.id.plus);
        buttonClear = (Button)findViewById(R.id.clear);
        buttonSubstract = (Button)findViewById(R.id.minus);
        buttonMul = (Button)findViewById(R.id.star);
        buttonDiv = (Button)findViewById(R.id.slash);
        buttonEqual = (Button)findViewById(R.id.equal);

        resultTextView = (TextView)findViewById(R.id.input);
        ansTextView = (TextView)findViewById(R.id.result);
    }
}