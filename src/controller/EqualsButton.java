package controller;

import model.State;
import model.Situation;
import static model.GlobalConstants.KEYPAD_COLOR;

public class EqualsButton extends CalculatorButton{
	public EqualsButton(Situation situation) {
		super("=", situation);
	}

	@Override
	public void transition() {
		// Do nothing for any state except Input2
		if (this.situation.state != State.Input2) {
			return;
		}

		Integer result = this.situation.binaryOperator.operator.applyAsInt(
			this.situation.leftOperand, Integer.parseInt(this.situation.display.getText())
		);
		this.situation.display.setText(result.toString());
		this.situation.binaryOperator.setColor(KEYPAD_COLOR);
		this.situation.state = State.HasResult;
	}
}
