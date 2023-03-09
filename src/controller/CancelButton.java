package controller;

import model.State;
import model.Situation;
import static model.GlobalConstants.KEYPAD_COLOR;

/**
 * A button which clears the display and deselects the chosen operator
 *
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class CancelButton extends CalculatorButton {

	/**
	 * Creates a CancelButton
	 * @param situation the state of the application
	 */
	public CancelButton(Situation situation) {
		super("C", situation);
	}

	/**
	 * Clears the display and changes state to Input1 while clearing active BinOpButton
	 */
	@Override
	protected void transition() {
		// Clears the display
		this.situation.display.setText("0");
		this.situation.state = State.Input1;
		if (this.situation.binaryOperator != null) {
			this.situation.binaryOperator.setColor(KEYPAD_COLOR);
		}
	}
}
