package controller;

import model.State;
import model.Situation;

/**
 * A Button which allows to add/increase the value of the display
 */
public class DigitButton extends CalculatorButton{
	/**
	 * Creates a DigitButton with the symbol, and is also which add/increases the displays value
	 * @param symbol the text to show to the user as well as the thing to add/increases the displays value with
	 * @param situation the state of the application
	 */
	public DigitButton(String symbol, Situation situation) {
		super(symbol, situation);
	}

	/**
	 * I DON'T WANT TO WRITE MORE JAVADOC!
	 * if state is Input1 or Input2
	 * add/increases the displays value with symbol
	 * and if display is 0, replace instead of add.
	 * if state is OpReady change state to Input2 and set display to symbol
	 * if state is HasResult change state to Input1 and set display to symbol
	 */
	@Override
	public void transition() {
		switch (this.situation.state) {
			case Input1, Input2:
				String text = this.situation.display.getText();
					if (text.equals("0")) {
						if (this.symbol.equals("0")) {
							break;
						}
						this.situation.display.setText(this.symbol);
						break;
					}
				this.situation.display.setText(text + this.symbol);
				break;

			case OpReady:
				this.situation.display.setText(this.symbol);
				this.situation.state = State.Input2;
				break;

			case HasResult:
				this.situation.display.setText(this.symbol);
				this.situation.state = State.Input1;
				break;
		}
	}
}
