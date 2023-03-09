package model;

import javax.swing.*;

import controller.BinOpButton;

/**
 * Contains variabels and the state if the calculator such ass left operand, selected operator and display
 */
public class Situation {
    /**
     * A variable representing the current state of the calculator using a Enum
     */
    public State state = State.Input1; // Tillstånd för miniräknaren (se Håkans tillståndsdiagram)
    /**
     * The display (JLabel) associated with the calculator
     */
    public final JLabel display;             // Visar första/andra talen när de slås in, sedan summan efter = knappen
    /**
     * The currently selected BinOPButton
     */
    public BinOpButton binaryOperator; // Vilken av de 4 räknesätten (operator)
    /**
     * The left operand used for calculating the result
     */
    public int leftOperand;            // Första talet

    /**
     * Creates the Situation with the given display
     * @param display the display
     */
    public Situation(JLabel display){
        this.display = display;
    }
}
