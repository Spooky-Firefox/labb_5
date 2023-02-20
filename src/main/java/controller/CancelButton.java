package controller;

import model.Situation;

public class CancelButton extends CalculatorButton{
    public CancelButton(Situation situation) {
        super("C", situation);
    }

    @Override
    public void transition() {
        // TODO
    }
}
