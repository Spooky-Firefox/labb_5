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

        this.setBackground(BUTTON_COLOR);
        this.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
        this.setFont(FONT);

        // adding an action listener
        this.addActionListener(this);
        this.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(KEYPAD_COLOR,MARGIN), // this is a workaround, since EmptyBorder
                        // isn't transparent and lett the underlying object color be seen
                        //BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN),
                        BorderFactory.createLineBorder(BORDER_COLOR, BORDER_THICKNESS,ROUNDED_BORDER)
                ));
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
