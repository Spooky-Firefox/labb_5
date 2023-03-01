package view;

import controller.BinOpButton;
import controller.CancelButton;
import controller.DigitButton;
import controller.EqualsButton;
import model.Situation;
import tools.GlobalConstants;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;

import static tools.GlobalConstants.FONT;

public class GUI extends JFrame {
    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel canvas = new JPanel(new GridBagLayout());
        // create constraints for the layoutmangor
        GridBagConstraints gcd = new GridBagConstraints();
        gcd.fill = GridBagConstraints.BOTH; // set so all componets fill space as default
        gcd.weightx = 0.8; // fill 100% of empty space in x
        gcd.weighty = 0.8;

        canvas.setBackground(new Color(230, 208, 222)); // color is for debug

        // add canvas to Jframe
        this.add(canvas);

        // add the display
        JLabel display = new JLabel("1234");
        display.setFont(FONT);
        display.setBackground(new Color(255, 204, 153)); // color is for debugging
        display.setOpaque(true);
        display.setHorizontalAlignment(SwingConstants.RIGHT); // set text to right


        //  add display att grid pos 0,0
        gcd.gridx = 0;
        gcd.gridy = 0;
        canvas.add(display,gcd);

        // create a keypad
        JPanel keyPad = new JPanel(new GridLayout(4,4));
        keyPad.setBackground(new Color(213, 232, 212));

        // add keyPad att grid pos 0,1
        gcd.gridx = 0;
        gcd.gridy = 1;
        canvas.add(keyPad,gcd);

        // creating situation

        Situation sit = new Situation(display);

        // creating all buttons

        //
        ArrayList<JButton> digits = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            digits.add(new DigitButton(String.valueOf(i),sit));
        }
        JButton divButton = new BinOpButton("/", sit, (x, y) -> x/y);
        JButton mulButton = new BinOpButton("*", sit, (x, y) -> x*y);
        JButton subButton = new BinOpButton("-", sit, (x, y) -> x-y);
        JButton addButton = new BinOpButton("+", sit, (x, y) -> x+y);
        JButton equButton = new EqualsButton(sit);
        JButton canButton = new CancelButton(sit);

        // adding buttons
        keyPad.add(digits.get(7)); keyPad.add(digits.get(8)); keyPad.add(digits.get(9)); keyPad.add(divButton);
        keyPad.add(digits.get(4)); keyPad.add(digits.get(5)); keyPad.add(digits.get(6)); keyPad.add(mulButton);
        keyPad.add(digits.get(1)); keyPad.add(digits.get(2)); keyPad.add(digits.get(3)); keyPad.add(subButton);
        keyPad.add(digits.get(0)); keyPad.add(canButton); keyPad.add(equButton); keyPad.add(addButton);

        this.pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }
}
