package controller;

import model.Situation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class CalculatorButton extends JButton implements ActionListener {
    private String symbol;
    protected Situation situation;

    public CalculatorButton(String symbol, Situation situation) {
        // initialize parent with symbol as visible text
        super(symbol);
        this.symbol = symbol;
        this.situation = situation;

        // set color to gray
        this.setBackground(Color.gray);
        // TODO get rid of magic numbers
        this.setPreferredSize(new Dimension(20, 20));
        // TODO beter font handling, like a constant variable containing a font
        this.setFont(new Font("Arial", 0, 15));

        // adding an action listener
        this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        transition();
    }

    public void setColor(Color color){
        super.setBackground(color);
    }

    public String toString(){
        return "Button <" + this.symbol + ">";
    }
    abstract public void transition();
}
