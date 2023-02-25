package controller;

import model.Situation;

import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton{
    private IntBinaryOperator operator;
    public BinOpButton(String symbol, Situation situation, IntBinaryOperator operator) {
        super(symbol, situation);
        this.operator = operator;
    }

    @Override
    public void transition() {
        //TODO
    }
}
