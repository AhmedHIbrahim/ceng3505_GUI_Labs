package com.example.mycalculator;

import android.view.View;
import android.widget.Button;

class Presenter implements View.OnClickListener, CalculatorListener{

CalculatorView calculatorView;
SimpleCalculator calculator;


boolean operatorExpected = false;

boolean isFirstDigit = true;

    public Presenter(CalculatorView view) {
        this.calculatorView = view;

        calculator = new SimpleCalculator(this);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button)v;
        String symbol= (String) btn.getText();
        if(operatorExpected){
            if(symbol.equals("+") || symbol.equals("-")){
                calculator.setOperand(Integer.parseInt(calculatorView.getNumber()));
                calculator.setOperator(symbol);
                isFirstDigit = true;
                return;
            }
        }
        if(symbol.toLowerCase().equals("clear")){
            calculatorView.setNumber("");
            operatorExpected = false;
            boolean isFirstDigit = true;
            calculator.reset();

        }
        else{
            if(isFirstDigit){
                calculatorView.setNumber(symbol);
                isFirstDigit = false;
                operatorExpected = true;
            }else{

                calculatorView.setNumber(calculatorView.getNumber()+symbol);
            }
        }
    }


    @Override
    public void onResultCalculated(int result) {
        calculatorView.setNumber(result+"");

    }
}
