package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity implements CalculatorView{
EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Presenter presenter = new Presenter(this);
        txt = findViewById(R.id.txtNumber);
        TableLayout table = findViewById(R.id.table);

        for(int i = 0; i<table.getChildCount();i++){
            TableRow row = (TableRow) table.getChildAt(i); //Cast to TableRow because ıt resturns a vıew
            for(int j = 0; j<row.getChildCount();j++){
                Button btn = (Button) row.getChildAt(j); //Cast to Button because ıt resturns a vıew
                btn.setOnClickListener(presenter); //pass view as a parameter

            }
        }
    }
    @Override
    public void setNumber(String number){
        txt.setText(number);
    }
    @Override
    public String getNumber(){
        return txt.getText().toString();
    }
}
