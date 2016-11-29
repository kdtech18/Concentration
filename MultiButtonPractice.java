/* MultiButtonPractice.java
   Kenton Duprey
   Java Graphics II G
   Mr. Blondin
   11/23/2016
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;

public class MultiButtonPractice extends JFrame implements ActionListener
	{
		JPanel mainPnl = new JPanel();
		JPanel northPnl = new JPanel();
		JPanel centerPnl = new JPanel();
		JPanel eastPnl = new JPanel();
		
		BorderLayout border = new BorderLayout();
		GridLayout centerLyt = new GridLayout(4, 3, 2, 2);
		GridLayout eastLyt = new GridLayout(4, 1, 2, 2);
		
		String[] numbers = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0", ".", "="};
		String[] operators = {"+", "-", "*", "/"};
		
		JButton[] numBtn = new JButton[12];
		JButton[] opBtn = new JButton[4];
		
		JTextField outputFld = new JTextField();
		
		String outputStr = "";
		double num1;
		double num2;
		String operator = "";
		int decCount = 0;
	
	public MultiButtonPractice()
		{
			super("My Calculator");
			setSize(450, 450);
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			makeButtons();
			mainPnl.setLayout(border);
			
			mainPnl.add(centerPnl, BorderLayout.CENTER);
			mainPnl.add(outputFld, BorderLayout.NORTH);
			mainPnl.add(eastPnl, BorderLayout.EAST);
			
			add(mainPnl);
			
			validate();
		}
	
	public void makeButtons()
		{
			centerPnl.setLayout(centerLyt);
		for (int i = 0; i < numBtn.length; i++)
			{
				numBtn[i] = new JButton(numbers[i]);
				centerPnl.add(numBtn[i]);
				numBtn[i].addActionListener(this);
			}
		
			eastPnl.setLayout(eastLyt);
		for (int i = 0; i < opBtn.length; i++)
			{
				opBtn[i] = new JButton(operators[i]);
				eastPnl.add(opBtn[i]);
				opBtn[i].addActionListener(this);
			}
		}
	public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
		
		for (int i = 0; i < 10; i++)
			{
				if (source == numBtn[i])
					{
						// show this change (Sting not needed)
						// outputStr += numBtn[i].getText();
						outputFld.setText(outputFld.getText() + numBtn[i].getText());
						break;
					}
			}
		
		for (int i = 0; i < opBtn.length; i++)
			{
				if (source == opBtn[i])
					{
						num1 = Double.parseDouble(outputFld.getText());
						outputFld.setText("");
						operator = opBtn[i].getText();
						decCount = 0;
						break;
					}
			}
			
		if (source == numBtn[10] && decCount == 0)
			{
				decCount++;
				outputFld.setText(outputFld.getText() + numBtn[10].getText());
			}
		if (source == numBtn[11])
			{
				num2 = Double.parseDouble(outputFld.getText());
				if (operator.equals("+"))
					outputFld.setText("" + (num1 + num2));
				else if (operator.equals("-"))
					outputFld.setText("" + (num1 - num2));
				else if (operator.equals("*"))
					outputFld.setText("" + (num1 * num2));
				else if (operator.equals("/"))
					outputFld.setText("" + (num1 / num2));
			}
		}
		
		
	
	public static void main(String[] args)
		{
			MultiButtonPractice gui = new MultiButtonPractice();
			
		}// end main method
	}