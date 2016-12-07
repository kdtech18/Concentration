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
import java.util.List;

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
	List<ImageIcon> imageIconsRandom = new ArrayList<ImageIcon>();
	
	// variables
	String image1, image2;
	int index1, index2;
	int click = 1;
	boolean match = false;
	
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
		
		newGame.addActionListener(this);
		
		mainPanel.add(center, BorderLayout.CENTER);
		mainPanel.add(east, BorderLayout.EAST);
		addCards();
		addGameimages();
		east.add(newGame, BorderLayout.NORTH);
		east.add(matches, BorderLayout.SOUTH);
		
		
		add(mainPanel);
		validate();
		}
	
	public void addCards()
		{
		center.setLayout(board);
		for (int i = 0; i < cards.length; i++)
			{
			cards[i] = new JButton(orig);
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
		
		for (int i = 0; i<16; i++)
			{
			int num = (int)(Math.random() * images.size());
			imageIconsRandom.add(new ImageIcon(images.get(num)));
			images.remove(num);
				
			}
		/*for (int i = 0; i < images.size(); i++)
			{
				randomImages.add(images.get((int)(Math.random() * 15) + 1));
			}
		for (int i = 0; i < randomImages.size(); i++)
			{
				imageIconsRandom.add(new ImageIcon(randomImages.get(i)));
			}*/
		}
	
	public void actionPerformed(ActionEvent e)
		{
		Object source = e.getSource();
		if (source == newGame)
			{
			for (int i = 0; i < cards.length; i++)
				{
					cards[i] = new JButton(orig);
					cards[i].setEnabled(true);
				}
			}
		
		for (int i = 0; i < cards.length; i++)
			{
			if(source == cards[i])
				{
				if(click == 3)
					{
					click = 1;
					cards[index1].setIcon(orig);
					cards[index2].setIcon(orig);
					}
				if(click == 2)
					{
					cards[i].setIcon(imageIconsRandom.get(i));
					image2 = imageIconsRandom.get(i).getDescription();
					System.out.print(image1);
					index2 = i;
					System.out.print(index1);
					match = checkMatch(image1, image2);
					if(match)
						{
						cards[index1].setEnabled(false);
						cards[index2].setEnabled(false);
						numMatches++;
						matches.setText("Matches: " + numMatches);
						}
					else
						click++;
					}
				if(click == 1)
					{
					cards[i].setIcon(imageIconsRandom.get(i));
					image1 = imageIconsRandom.get(i).getDescription();
					System.out.print(image1);
					index1 = i;
					System.out.print(index1);
					click++;
					}
					
					
				}
			}
		}
	
	public boolean checkMatch(String str1, String str2)
		{
		
		return str1.equals(str2);
		}
	
	public static void main(String[] args)
		{
		Concentration app = new Concentration();
			
		}// end main method
	}
