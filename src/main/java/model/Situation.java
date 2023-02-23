package model;

import controller.BinOpButton;
import tools.State;

import javax.swing.*;

public class Situation {
    public State state = State.Input1; // init state
    public JLabel display; // where numbers and results are shown
    public BinOpButton binaryOperator;
    public int leftOperand;

    public Situation(JLabel display){
        this.display = display;
    }
}
