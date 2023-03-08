package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Situation;
import static model.GlobalConstants.*;

/**
 * An abstract class that provides the functionality required to drive a simple button
 */
abstract class CalculatorButton extends JButton implements ActionListener {
	protected final String symbol;
	protected final Situation situation;

	/**
	 * Creates a calculator button instance with the given symbol as the text show to the user
	 * @param symbol the text to show to the user
	 * @param situation the state of the application
	 */
	public CalculatorButton(String symbol, Situation situation) {
		// initialize parent with symbol as visible text
		super(symbol);
		this.symbol = symbol;
		this.situation = situation;
		this.setFocusPainted(false);
		this.setBackground(BUTTON_COLOR);
		this.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
		this.setFont(FONT);

		// adding an action listener
		this.addActionListener(this);
		this.setBorder(BorderFactory.createLineBorder(KEYPAD_COLOR,MARGIN));
	}

	/**
	 * runns each time the button is pressed, calls the transition method
	 * @param e the event to be processed
	 */
	public void actionPerformed(ActionEvent e) {
		transition();
	}

	// Helper for setting the colour on button border

	/**
	 * Sets the border color off the button useful for sowing if something is active or not
	 * @param color the color to sett the button border to
	 */
	public void setColor(Color color) {
		this.setBorder(BorderFactory.createLineBorder(color,MARGIN));
	}

	/**
	 * return a string with formatted string containing the buttons symbol
	 * @return a formatted string
	 */
	public String toString() {
		return "Button <" + this.symbol + ">";
	}

	/**
	 * a method that is called when the button is pressed, its purpose is often to modify state
	 */
	abstract public void transition();
}
