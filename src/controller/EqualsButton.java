package controller;

import model.State;
import model.Situation;
import static model.GlobalConstants.KEYPAD_COLOR;

/**
 * A class that set the display to the calculated value
 */
public class EqualsButton extends CalculatorButton{

	/**
	 * Creates a EqualsButton
	 * @param situation the state of the application
	 */
	public EqualsButton(Situation situation) {
		super("=", situation);
	}

	/**
	 * If the state is Input2 calculate the result of the operations with the value in leftOperand and display with
	 * the selected BinOpButtons operation, sets the display and changes state to HasResult
	 * if the state is not Input2 do nothing
	 */
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
