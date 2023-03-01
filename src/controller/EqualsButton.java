package controller;

import model.Situation;

public class EqualsButton extends CalculatorButton{
    public EqualsButton(Situation situation) {
        super("=", situation);
    }

    @Override
    public void transition() {
        //TODO
    }
}
