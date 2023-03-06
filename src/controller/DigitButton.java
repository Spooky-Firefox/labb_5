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
    		case Input1, Input2:
    			if (this.situation.display.getText()=="0") {
    				this.situation.display.setText(super.symbol);
    				break;
    			}
    			else {
    			this.situation.display.setText(this.situation.display.getText()+ super.symbol);
    			break;
    			}
    		case OpReady:
                this.situation.display.setText(this.situation.display.getText()+ super.symbol);
                break;
    	
    	}

    }
}
