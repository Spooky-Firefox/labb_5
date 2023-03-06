package controller;

import static tools.GlobalConstants.KEYPAD_COLOR;

import model.Situation;

public class DigitButton extends CalculatorButton{
    public DigitButton(String symbol, Situation situation) {
        super(symbol, situation);
    }

    @Override
    public void transition() {
    	switch (this.situation.state) {
    		case Input1:
    			this.situation.display.setText(super.symbol);
    			break;
    		case OpReady:
                this.situation.display.setText("0");
                // clear color of selected operator
                this.situation.binaryOperator.setColor(KEYPAD_COLOR);
                // TODO change state to Input1
                break;
    		case Input2:
                this.situation.display.setText(super.symbol);
                // clear color of selected operator
                this.situation.binaryOperator.setColor(KEYPAD_COLOR);
                // TODO change state to Input1
                break;
            case HasResult:
                this.situation.display.setText("0");
                // TODO change state to Input1
                break;
    	
    	}

    }
}
