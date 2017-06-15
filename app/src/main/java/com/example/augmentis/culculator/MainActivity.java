package com.example.augmentis.culculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText showResult;
    Character op = 'q';
    float num = 0, numtemp = 0;
    int digiTemp = 10;
    String str = "";
    RadioButton Celsius, Fahrenheit, Bin, Dec, Hex, Oct;
    RadioGroup temperature, convertDigit, distanceBetween;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnClear, btnDecimal, btnPlus, btnMinus, btnMulti, btnDivide, btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showResult = (EditText) findViewById(R.id.editText);

        btn1 = (Button) findViewById(R.id.Btn1_id);
        btn2 = (Button) findViewById(R.id.Btn2_id);
        btn3 = (Button) findViewById(R.id.Btn3_id);
        btn4 = (Button) findViewById(R.id.Btn4_id);
        btn5 = (Button) findViewById(R.id.Btn5_id);
        btn6 = (Button) findViewById(R.id.Btn6_id);
        btn7 = (Button) findViewById(R.id.Btn7_id);
        btn8 = (Button) findViewById(R.id.Btn8_id);
        btn9 = (Button) findViewById(R.id.Btn9_id);
        btn0 = (Button) findViewById(R.id.Btn0_id);

        btnClear = (Button) findViewById(R.id.Btnclear_id);
        btnDecimal = (Button) findViewById(R.id.Btndecimal_id);
        btnCalculate = (Button) findViewById(R.id.Btnequal_id);

        btnPlus = (Button) findViewById(R.id.Btnplus_id);
        btnMinus = (Button) findViewById(R.id.Btnminus_id);
        btnMulti = (Button) findViewById(R.id.Btnmulti_id);
        btnDivide = (Button) findViewById(R.id.Btndivide_id);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("0");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '+';
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '-';
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '*';
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '/';
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperature.clearCheck();
                convertDigit.clearCheck();
                distanceBetween.clearCheck();
                digiTemp = 10;
                reset();
            }
        });


    }

    public void insert(String s) {
        str = str + s;
        num = Float.valueOf(str).intValue();
        showResult.setText(str);
    }

    public void reset(){
        str = "";
        op = 'q';
        num = 0;
        numtemp = 0;
        showResult.setText("");
    }

    public void perform() {
        str = "";
        numtemp = num;
    }

    public void calculate() {
        if (op == '+')
            num = numtemp + num;
        else if (op == '-')
            num = numtemp - num;
        else if (op == '*')
            num = numtemp * num;
        else if (op == '/')
            num = numtemp / num;
        showResult.setText("" + num);
    }
}
