package controller;

import model.Situation;
import tools.State;

import java.util.function.IntBinaryOperator;

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
				// this is for color change
				this.setColor(ACTIVE_COLOR);
				// TODO go to OpReady save Display value to leftOperand and Clear Display
				// code goes here
				this.situation.leftOperand = Integer.parseInt(this.situation.display.getText());


				this.situation.state = State.OpReady;


				break;
			case Input2, OpReady:
				// this is for color change
				this.situation.binaryOperator.setColor(KEYPAD_COLOR);
				this.setColor(ACTIVE_COLOR);

				// TODO Switch current operator
				// code goes here

				break;
		}

		this.situation.binaryOperator = this;
	}
}
