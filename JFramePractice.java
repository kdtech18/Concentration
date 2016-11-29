/* JFramePractice.java
   Kenton Duprey
   Java Graphics II G
   Mr. Blondin
   11/15/2016
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;

public class JFramePractice
    {
    public static void main(String[] args)
        {
        JFrame aFrame = new JFrame("This is my first frame.");
        JLabel alabel = new JLabel("Kenton Duprey");
        JButton pressBtn = new JButton("Press Me");
        FlowLayout flow = new FlowLayout();
        
        // setSize(width, height)
        aFrame.setSize(450, 450);
        
        // set title
        aFrame.setTitle("This is a set title");
        
        // set layout
        aFrame.setLayout(flow);
        
        // set if resizable
        aFrame.setResizable(false);
        
        // adds label
        aFrame.add(alabel);
        
        // adds button
        aFrame.add(pressBtn);
        
        // sets default close operation
        aFrame.setDefaultCloseOperation(aFrame.EXIT_ON_CLOSE);
        
        // sets to visible
        aFrame.setVisible(true);
        
        }// end main method
    }