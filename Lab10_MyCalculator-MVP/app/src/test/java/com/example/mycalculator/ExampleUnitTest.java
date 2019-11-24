package com.example.mycalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void test_Calculator() {
        CalculatorListener listener = new MockCalculatorListener(); //will be ın test Package
        SimpleCalculator calc = new SimpleCalculator(listener);     //in development Package

        calc.setOperand(72);

        calc.setOperator("+");

        calc.setOperand(6);



        assertEquals(78,((MockCalculatorListener) listener).result);

        calc.setOperator("-");

        calc.setOperand(3);

        assertEquals(75,((MockCalculatorListener) listener).result);




    }
}