package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Situation;
import static model.GlobalConstants.*;

abstract class CalculatorButton extends JButton implements ActionListener {
	protected final String symbol;
	protected final Situation situation;

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

	public void actionPerformed(ActionEvent e) {
		transition();
	}

	// Helper for setting the colour on button border
	public void setColor(Color color) {
		this.setBorder(BorderFactory.createLineBorder(color,MARGIN));
	}

	public String toString() {
		return "Button <" + this.symbol + ">";
	}

	abstract public void transition();
}
