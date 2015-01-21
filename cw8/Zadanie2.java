package cw8;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.*;

class JClock extends JLabel implements ActionListener {
	static DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
	public JClock (){	
		
		super("" + df.format(new Date()));
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.red);
		setFont(new Font("Consolas", Font.BOLD, 29));

	    Timer t = new Timer(1000, this);
	    t.start();
		  }

	  public void actionPerformed(ActionEvent ae) {
	    setText(df.format(new Date()));
	  }
}


public class Zadanie2 {
	 public static void main(String[] args) {
		 /** The entry main() method */
		 SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 JFrame okno = new JFrame("GUI - Aplikacja");
				 okno.setSize(400, 200);
				 okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				 JPanel p = new JPanel();
				 p.setLayout(new BorderLayout());
				// okno.setLayout(new BorderLayout());
				 p.add(new JClock(), BorderLayout.CENTER);
				 //p.add(new JStart(), BorderLayout.SOUTH);
				 //p.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
				 p.setBackground(Color.black);
				 okno.add(p);
				
				 okno.setVisible(true);
			 }
	 });
		 
		 
		 
		 
 }
}