package cw8;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

@SuppressWarnings("serial")
class JClock4 extends JLabel implements ActionListener {
	static DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM);

	private Calendar lastDate;
	public JClock4 (){	
		super();
		
		lastDate = Calendar.getInstance();
		lastDate.setTime(new Date());
		lastDate.add(Calendar.SECOND, 1); 

		setText(df.format(lastDate.getTime()));
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.red);
		setFont(new Font("Consolas", Font.BOLD, 29));


		  }

	  public void actionPerformed(ActionEvent ae) {
		  lastDate.add(Calendar.SECOND, 1);  
		  setText(df.format(lastDate.getTime()));
	  }
}


public class Zadanie4 {
	 public static void main(String[] args) {
		 /** The entry main() method */
		 SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 JFrame okno = new JFrame("GUI - Aplikacja");
				 okno.setSize(400, 200);
				 okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 
				 JClock4 clock = new JClock4();
				 final Timer clockTimer = new Timer(1000, clock);
				 
				
				 JPanel p = new JPanel();
				 p.setLayout(new BorderLayout());
				 p.add(clock, BorderLayout.CENTER);
				 
				 JPanel southPanel = new JPanel();
				 	southPanel.setLayout(new GridLayout(1,2));
				 	
				 	JButton startButton = new JButton("Start");
				 	JButton stopButton = new JButton("Stop");
				 	
				 	startButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							clockTimer.start();
						}
					});
				 	
				 	stopButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							clockTimer.stop();
						}
					});
				 	southPanel.add(startButton);
				 	southPanel.add(stopButton);
				 	
				 	

				 p.add(southPanel, BorderLayout.SOUTH);
				 p.setBackground(Color.black);
				 
				 okno.add(p);
				 okno.setVisible(true);
			 }
	 });
		 
		 
		 
		 
 }
}