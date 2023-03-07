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
		// Clears the display
		this.situation.display.setText("0");
		this.situation.state = State.Input1;
		if (this.situation.binaryOperator != null) {
			this.situation.binaryOperator.setColor(KEYPAD_COLOR);
		}
	}
}
