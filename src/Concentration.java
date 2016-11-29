/* Concentration.java
   Kenton Duprey and Ian McMurray
   Java Graphics II G
   Mr. Blondin
   11/29/2016
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Concentration extends JFrame implements ActionListener
	{
		JPanel mainPanel = new JPanel();
		JPanel center = new JPanel();
		JPanel east = new JPanel();
		
		BorderLayout border = new BorderLayout();
		GridLayout board = new GridLayout(4, 4, 1, 1);
		
		int numMatches;
		JButton newGame = new JButton("Start!");
		JLabel matches = new JLabel("Matches: " + numMatches);
		JButton[] cards = new JButton[16];
		
	public Concentration()
	{
	    super("Concentration");
	    setSize(450, 450);
	    setVisible(true);
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    mainPanel.setLayout(border);
	    
	    mainPanel.add(center, BorderLayout.CENTER);
	    mainPanel.add(east, BorderLayout.EAST);
	    
	    center.setLayout(board);
	    east.add(newGame, BorderLayout.NORTH);
	    east.add(matches, BorderLayout.CENTER);
	    
	    addCards();
	    
	    add(mainPanel);
	    validate();
	}
	
	public void addCards()
		{
			center.setLayout(board);
		for (int i = 0; i < cards.length; i++)
			{
				center.add(cards[i]);
				cards[i].addActionListener(this);
			}
			
		}
	
	public void actionPerformed(ActionEvent e)
		{
			
		}
	
	public static void main(String[] args)
		{
			Concentration app = new Concentration();
		}// end main method
	}
