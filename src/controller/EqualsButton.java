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
				this.situation.binaryOperator.setColor(KEYPAD_COLOR);
				this.situation.display.setText(this.situation.display.getText());
				break;
			case Input2:
				Integer result = this.situation.binaryOperator.operator.applyAsInt(
						this.situation.leftOperand, Integer.parseInt(this.situation.display.getText()));
				this.situation.display.setText(result.toString());
				this.situation.binaryOperator.setColor(KEYPAD_COLOR);
				this.situation.state = State.HasResult;
				break;
		}
	}
}
