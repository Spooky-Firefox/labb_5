package model;

import javax.swing.*;

import controller.BinOpButton;

public class Situation {
    public State state = State.Input1; // Tillstånd för miniräknaren (se Håkans tillståndsdiagram)
    public final JLabel display;             // Visar första/andra talen när de slås in, sedan summan efter = knappen
    public BinOpButton binaryOperator; // Vilken av de 4 räknesätten (operator)
    public int leftOperand;            // Första talet

    public Situation(JLabel display){
        this.display = display;
    }
}
