package controller;

import model.State;
import model.Situation;
import static model.GlobalConstants.KEYPAD_COLOR;

public class CancelButton extends CalculatorButton {
	public CancelButton(Situation situation) {
		super("C", situation);
	}

	@Override
	public void transition() {
		// Clears the display
		this.situation.display.setText("0");
		this.situation.state = State.Input1;
		if (this.situation.binaryOperator != null) {
			this.situation.binaryOperator.setColor(KEYPAD_COLOR);
		}
	}
}
