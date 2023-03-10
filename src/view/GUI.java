package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import controller.*;
import model.Situation;

import static model.GlobalConstants.*;

/**
 * A class representing a calculator GUI, with buttons and display, with its own state
 *
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class GUI extends JFrame {
	/**
	 * Creates the GUI and displays it on the screen
	 */
	public GUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add canvas to JFrame
		JPanel canvas = new JPanel(new GridBagLayout());
		this.add(canvas);

		// create constraints for the layoutmaneger
		GridBagConstraints gcd = new GridBagConstraints();
		gcd.fill = GridBagConstraints.BOTH; // set so all components fill space as default
		gcd.weightx = 0.8; // fill 100% of empty space in x
		gcd.weighty = 0.8;

		// add the display (with default number)
		JLabel display = new JLabel("0");
		display.setFont(FONT);
		display.setBorder(
			BorderFactory.createLineBorder(BORDER_COLOR,BORDER_THICKNESS,ROUNDED_BORDER)
		);
		display.setHorizontalAlignment(SwingConstants.RIGHT); // set text to right

		// add display att grid pos 0,0
		gcd.gridx = 0;
		gcd.gridy = 0;
		canvas.add(display,gcd);

		// creating situation
		Situation sit = new Situation(display);

		// create a keypad
		JPanel keyPad = new JPanel(new GridLayout(4,4));
		keyPad.setBackground(KEYPAD_COLOR); // cant be seen, se CalculatorButton

		// add keyPad att grid pos 0,1
		gcd.gridx = 0;
		gcd.gridy = 1;
		canvas.add(keyPad,gcd);

		// creating all buttons
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

		// adding buttons (using standard keypad rows)
		keyPad.add(digits.get(7)); keyPad.add(digits.get(8)); keyPad.add(digits.get(9)); keyPad.add(divButton);
		keyPad.add(digits.get(4)); keyPad.add(digits.get(5)); keyPad.add(digits.get(6)); keyPad.add(mulButton);
		keyPad.add(digits.get(1)); keyPad.add(digits.get(2)); keyPad.add(digits.get(3)); keyPad.add(subButton);
		keyPad.add(digits.get(0)); keyPad.add(equButton); keyPad.add(canButton); keyPad.add(addButton);

		this.pack();
		setVisible(true);
	}
}
