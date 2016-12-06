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
import java.util.ArrayList;

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
		
		ImageIcon orig = new ImageIcon("imageOriginal.gif");
		
		ArrayList<String> images = new ArrayList<String>();
		ArrayList<String> randomImages = new ArrayList<String>();
		ArrayList<ImageIcon> imageIconsRandom = new ArrayList<ImageIcon>();
		
	public Concentration()
	{
	    super("Concentration");
	    setSize(450, 450);
	    setVisible(true);
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    mainPanel.setLayout(border);
	    
	    Font font = new Font(Font.SANS_SERIF, 1, 18);
	    matches.setFont(font);
	    newGame.setFont(font);
	    
	    mainPanel.add(center, BorderLayout.CENTER);
	    mainPanel.add(east, BorderLayout.EAST);
		addCards();
	    east.add(newGame, BorderLayout.NORTH);
	    east.add(matches, BorderLayout.SOUTH);
	    addGameimages();
	
	    add(mainPanel);
	    validate();
	}
	
	public void addCards()
		{
			center.setLayout(board);
		for (int i = 0; i < cards.length; i++)
			{
				cards[i] = new JButton(imageIconsRandom.get(i));
				center.add(cards[i]);
				cards[i].addActionListener(this);
			}
		for (int i = 0; i < 8; i++)
			{
			for (int x = 0; x < 2; x++)
				{
					images.add(new String("image" + i + ".gif"));
				}
			}
		
		}
		
	public void addGameimages()
		{
		for (int i = 0; i < images.size(); i++)
			{
				randomImages.add(images.get((int)(Math.random() * 15) + 1));
			}
		for (int i = 0; i < randomImages.size(); i++)
			{
				imageIconsRandom.add(new ImageIcon(randomImages.get(i)));
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
