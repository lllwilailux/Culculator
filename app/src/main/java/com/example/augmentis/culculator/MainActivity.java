package com.example.augmentis.culculator;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.math.BigInteger;

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

        Celsius = (RadioButton) findViewById(R.id.RbCelsius_id);
        Fahrenheit = (RadioButton) findViewById(R.id.RbFahrenheit_id);

        Bin = (RadioButton) findViewById(R.id.RbBin);
        Dec = (RadioButton) findViewById(R.id.RbDec);
        Hex = (RadioButton) findViewById(R.id.RbHex);
        Oct = (RadioButton) findViewById(R.id.RbOct);


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


        temperature = (RadioGroup) findViewById(R.id.temperature);
        temperature.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (showResult.getText().length() > 0) {
                    setEnabledconvertDigit(false);
                    Float inputValue = Float.parseFloat(showResult.getText().toString());
                    if (checkedId == R.id.RbCelsius_id) {
                        showResult.setText(String.valueOf(convertToCelsius(inputValue)));
                    }
                    if (checkedId == R.id.RbFahrenheit_id) {
                        showResult.setText(String.valueOf(convertToFahrenhrit(inputValue)));
                    }
                }
            }
        });

        convertDigit = (RadioGroup) findViewById(R.id.convertDigit);
        convertDigit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (showResult.getText().toString().length() > 0) {
                    String inputValue = showResult.getText().toString();
                    if (checkedId == R.id.RbHex) {
                        showResult.setText(convertDigit(inputValue,digiTemp,16));
                        digiTemp = 16;
                    }
                    if (checkedId == R.id.RbBin) {
                        showResult.setText(convertDigit(inputValue,digiTemp,2));
                        digiTemp = 2;
                    }
                    if (checkedId == R.id.RbOct) {
                        showResult.setText(convertDigit(inputValue,digiTemp,8));
                        digiTemp = 8;
                    }
                    if (checkedId == R.id.RbDec) {
                        showResult.setText(convertDigit(inputValue,digiTemp,10));
                        digiTemp = 10;
                    }
                }
            }
        });

        distanceBetween = (RadioGroup) findViewById(R.id.diatanceBetween);
        distanceBetween.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (showResult.getText().toString().length() > 0) {
                    setEnabledconvertDigit(false);
                    Float inputValue = Float.parseFloat(showResult.getText().toString());
                    if (checkedId == R.id.RbMiles){
                        showResult.setText(String.valueOf(convertToMiles(inputValue)));
                    }
                    if (checkedId == R.id.RbKilometer) {
                        showResult.setText(String.valueOf(convertToKilimeters(inputValue)));
                    }
                }
            }
        });

    }

    private void setEnabledconvertDigit(boolean enabled) {
        for (int i = 0; i < convertDigit.getChildCount(); i++) {
            convertDigit.getChildAt(i).setEnabled(enabled);
        }
    }

    private float convertToFahrenhrit(float celsius) {
        return (float) ((celsius * 1.8000) + 32);
    }

    private float convertToCelsius(float fahrenheit) {
        return (float) ((fahrenheit - 32.0) / 1.8000);
    }

    private String convertDigit(String s, int from, int to) {
        return new BigInteger(s.trim(), from).toString(to);
    }

    private float convertToKilimeters(float miles) {
        return (float) (miles * 1.609344);
    }

    private float convertToMiles(float kilometers) {
        return (float) (kilometers * 0.621371192);
    }

    public void insert(String s) {
        str = str + s;
        num = Float.valueOf(str).intValue();
        showResult.setText(str);
    }

    public void reset() {
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
