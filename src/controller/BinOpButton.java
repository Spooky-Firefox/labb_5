package controller;

import java.util.function.IntBinaryOperator;

import model.Situation;
import tools.State;

import static tools.GlobalConstants.ACTIVE_COLOR;
import static tools.GlobalConstants.KEYPAD_COLOR;

public class BinOpButton extends CalculatorButton{
	public IntBinaryOperator operator;

	public BinOpButton(String symbol, Situation situation, IntBinaryOperator operator) {
		super(symbol, situation);
		this.operator = operator;
	}

	@Override
	public void transition() {
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
