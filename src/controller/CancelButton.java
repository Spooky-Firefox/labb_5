package controller;

import model.Situation;
import tools.State;

import static tools.GlobalConstants.KEYPAD_COLOR;

public class CancelButton extends CalculatorButton {
    public CancelButton(Situation situation) {
        super("C", situation);
    }

    @Override
    public void transition() {
        switch (this.situation.state) {
            case Input1:
                // set display to display 0
                this.situation.display.setText("0");
                break;
            case OpReady:
                // set display to display 0
                this.situation.display.setText("0");
                // clear color of selected operator
                this.situation.binaryOperator.setColor(KEYPAD_COLOR);
                // TODO change state to Input1
                this.situation.state = State.Input1;
                break;
            case Input2:
                // set display to display 0
                this.situation.display.setText("0");
                // clear color of selected operator
                this.situation.binaryOperator.setColor(KEYPAD_COLOR);
                // TODO change state to Input1
                this.situation.state = State.Input1;
                break;
            case HasResult:
                // set display to display 0
                this.situation.display.setText("0");
                // TODO change state to Input1
                this.situation.state = State.Input1;
                break;
        }
    }
}
