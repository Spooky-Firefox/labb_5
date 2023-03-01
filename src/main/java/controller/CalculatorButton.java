package controller;

import model.Situation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static tools.GlobalConstants.*;

abstract class CalculatorButton extends JButton implements ActionListener {
    private String symbol;
    protected Situation situation;

    public CalculatorButton(String symbol, Situation situation) {
        // initialize parent with symbol as visible text
        super(symbol);
        this.symbol = symbol;
        this.situation = situation;

        // set color to gray
        // TODO make Color.Gray a constant
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
        this.setFont(FONT);

        // adding an action listener
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        transition();
    }

    public void setColor(Color color) {
        super.setBackground(color);
    }

    public String toString() {
        return "Button <" + this.symbol + ">";
    }

    abstract public void transition();
}
