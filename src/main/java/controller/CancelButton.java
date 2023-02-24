package controller;

import model.Situation;

public class CancelButton extends CalculatorButton{
    public CancelButton(Situation situation) {
        super("C", situation);
    }

    @Override
    public void transition() {
        switch (this.situation.state) {
            case Input1:
                this.situation.leftOperand = 0;
                break;
            case OpReady:
                this.situation.leftOperand = 0;
                // TODO: släck operator knapp!
                break;
            case Input2:
                this.situation.leftOperand = 0;
                this.situation.rightOperand = 0;
                // TODO: släck operator knapp!
                break;
            case HasResult:
                this.situation.leftOperand = 0;
                // rightOperand bör bli 0:ad av = knappen ist
                break;
        }
    }
}
