/* Concentration.java
   Kenton Duprey and Ian McMurray
   Java Graphics II G
   Mr. Blondin
   11/29/2016
*/


import javax.swing.*;
import java.awt.*;

public class Concentration extends JFrame
	{
		JPanel mainPanel = new JPanel();
		JPanel center = new JPanel();
		JPanel east = new JPanel();
		
		BorderLayout border = new BorderLayout();
		GridLayout board = new GridLayout(4, 4, 1, 1);
		
	public Concentration()
	{
	    super("Concentration");
	    setSize(450, 450);
	    setVisible(true);
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    mainPanel.setLayout(border);
	    
	    mainPanel.add(center, BorderLayout.CENTER);
	    mainPanel.add(east, BorderLayout.EAST);
	    
	}
		
		
	
	
	}
