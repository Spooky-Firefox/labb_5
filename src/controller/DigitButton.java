package controller;

import static tools.GlobalConstants.KEYPAD_COLOR;
import tools.State;
import model.Situation;

public class DigitButton extends CalculatorButton{
	public DigitButton(String symbol, Situation situation) {
		super(symbol, situation);
	}

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
