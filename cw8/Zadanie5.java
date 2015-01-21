package cw8;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.*;

@SuppressWarnings("serial")
class JClock5 extends JLabel implements ActionListener {
	private DateFormat df  = DateFormat.getTimeInstance(DateFormat.MEDIUM);
	public JClock5 (TimeZone zone){	

		super( );
		df.setTimeZone(zone);
		setText(df.format(new Date()));
		setHorizontalAlignment(JLabel.LEFT);
		setForeground(Color.red);
		setFont(new Font("Consolas", Font.BOLD, 29));

	    Timer t = new Timer(1000, this);
	    t.start();
		  }

	  public void actionPerformed(ActionEvent ae) {
	    setText(df.format(new Date()));
	  }
}
@SuppressWarnings("serial")
class JPrettyLabel extends JLabel {
	public JPrettyLabel(String text){
		super(text +" - ");
		setHorizontalAlignment(JLabel.RIGHT);
		setForeground(Color.BLUE);
		setFont(new Font("Consolas", Font.BOLD, 29));
		
	}
}
public class Zadanie5 {
	 public static void main(String[] args) {
		 /** The entry main() method */
		 SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 JFrame okno = new JFrame("GUI - Aplikacja");
				 okno.setSize(400, 300);
				 okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				 JPanel p = new JPanel();
				 p.setLayout(new GridLayout(4,2));
				 p.add(new JPrettyLabel("Warszawa"));
				 p.add(new JClock5(TimeZone.getTimeZone("Europe/Warsaw")));
				 p.add(new JPrettyLabel("Tokio"));
				 p.add(new JClock5(TimeZone.getTimeZone("Japan")));
				 p.add(new JPrettyLabel("Moskwa"));
				 p.add(new JClock5(TimeZone.getTimeZone("Europe/Moscow")));
				 p.add(new JPrettyLabel("Nowy Jork"));
				 p.add(new JClock5(TimeZone.getTimeZone("America/New_York")));
				 p.setBackground(Color.black);
				 okno.add(p);
				
				 okno.setVisible(true);
			 }
	 });
		 
		 
		 
		 
 }
}