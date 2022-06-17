package com.edu.myappcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb1, rb2, rb3, rb4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.txtx_value1);
        et2 = (EditText) findViewById(R.id.txt_value2);
        tv1 = (TextView) findViewById(R.id.txt_resultado);
        rb1 = (RadioButton) findViewById(R.id.rb_sumar);
        rb2 = (RadioButton) findViewById(R.id.rb_restar);
        rb3 = (RadioButton) findViewById(R.id.rb_multiplicar);
        rb4 = (RadioButton) findViewById(R.id.rb_dividir);
    }
    //metohd for the buton calculate
    public  void calculate(View view){
        String value1s = et1.getText().toString();
        String value2s = et2.getText().toString();
        int value1 = Integer.parseInt(value1s);
        int value2 = Integer.parseInt(value2s);
        if (rb1.isChecked()== true){
            int suma = value1 + value2;
            String rsult = String.valueOf(suma);
            tv1.setText(rsult);
        }else if(rb2.isChecked()==true ){
            int suma = value1 - value2;
            String rsult = String.valueOf(suma);
            tv1.setText(rsult);
        }else if (rb3.isChecked()){
            int suma = value1 * value2;
            String rsult = String.valueOf(suma);
            tv1.setText(rsult);
        }else if (rb4.isChecked()==true){
            if (value1 > value2){
                int suma = value1 / value2;
                String rsult = String.valueOf(suma);
                tv1.setText(rsult);
            }else {
                Toast.makeText(this, "el primer valor debe ser mayor que el segundo", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "El resultado es entero", Toast.LENGTH_SHORT).show();
            }
        }
    }
}