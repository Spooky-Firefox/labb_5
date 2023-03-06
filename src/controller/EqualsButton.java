package controller;

import static tools.GlobalConstants.KEYPAD_COLOR;
//import tools.State;
import model.Situation;
import tools.State;

public class EqualsButton extends CalculatorButton{
    public EqualsButton(Situation situation) {
        super("=", situation);
    }

    @Override
    public void transition() {
    	switch (this.situation.state) {
        case Input1, OpReady, HasResult:
            this.situation.display.setText(this.situation.display.getText()); //kanske inte behöver denna ens
            break;
        case Input2:
            this.situation.display.setText("0");
            this.situation.binaryOperator.setColor(KEYPAD_COLOR);
            this.situation.state = State.HasResult;
            break;
    }
}
}
