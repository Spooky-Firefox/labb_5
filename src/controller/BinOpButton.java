package controller;

import java.util.function.IntBinaryOperator;

import model.State;
import model.Situation;
import static model.GlobalConstants.ACTIVE_COLOR;
import static model.GlobalConstants.KEYPAD_COLOR;

/**
 * A button which purpose is the give state a method to apply operations on data, and as well as change state
 */
public class BinOpButton extends CalculatorButton{
	/**
	 * A variable containing a IntBinaryOperator used for appalling the buttons operation
	 */
	public final IntBinaryOperator operator; // same thing as a private with a public getter method

	/**
	 * Creates BinOpButton with the given Text, situation and the operator
	 * @param symbol the text to show to the user
	 * @param situation the state of the application
	 * @param operator the IntBinaryOperator describing the operation
	 */
	public BinOpButton(String symbol, Situation situation, IntBinaryOperator operator) {
		super(symbol, situation);
		this.operator = operator;
	}

	/**
	 * Changes the state of Situation if Input1 or HasResult
	 * ass well save the value in display to situation left operand.
	 * including setting situation binaryOperator to the clicked button
	 * if state is Input2 or OpReady change operator active operator
	 */
	@Override
	protected void transition() {
		switch (this.situation.state) {
			case Input1, HasResult:
				// Switch to next state and store value
				this.setColor(ACTIVE_COLOR);
				this.situation.state = State.OpReady;
				this.situation.leftOperand = Integer.parseInt(
					this.situation.display.getText()
				);
				break;

			case Input2, OpReady:
				// Clear old button colour and set new one as active
				this.situation.binaryOperator.setColor(KEYPAD_COLOR);
				this.setColor(ACTIVE_COLOR);
				break;
		}

		// Updates operator to the one that was pressed (ie. this button currently running)
		this.situation.binaryOperator = this;
	}
}
