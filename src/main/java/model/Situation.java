package model;

import controller.BinOpButton;
import tools.State;

import javax.swing.*;

public class Situation {
    public State state = State.Input1; // Tillstånd för miniräknaren (se Håkans tillståndsdiagram)
    public JLabel display;             // Visar första/andra talen när de slås in, sedan summan efter = knappen
    public BinOpButton binaryOperator; // Vilken av de 4 räknesätten (operator)
    public int leftOperand;            // Första talet
    public int RightOperand;           // Andra talet (efter att operatorn ovan har valts)

    public Situation(JLabel display){
        this.display = display;
    }
}
