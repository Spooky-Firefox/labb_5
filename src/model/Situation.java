package model;

import javax.swing.*;

import controller.BinOpButton;

/**
 * Contains variabels and the state if the calculator such ass left operand, selected operator and display
 */
public class Situation {
    public State state = State.Input1; // Tillstånd för miniräknaren (se Håkans tillståndsdiagram)
    public final JLabel display;             // Visar första/andra talen när de slås in, sedan summan efter = knappen
    public BinOpButton binaryOperator; // Vilken av de 4 räknesätten (operator)
    public int leftOperand;            // Första talet

    /**
     * Creates the Situation with the given display
     * @param display the display
     */
    public Situation(JLabel display){
        this.display = display;
    }
}
