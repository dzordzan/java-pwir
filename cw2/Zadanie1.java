package cw2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Andrzej Piszczek (c) 2014

public class Zadanie1 extends JFrame {

	/**
	 * @param args
	 */
	private JButton turnOn, turnOff;
	private JPanel buttonsPanel, lightingPanel, statusPanel;
	private JLabel status;
	
	
	public Zadanie1(){
		super("W³¹cz/wy³¹cz œwiat³o");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		turnOn = new JButton("W³¹cz");
		turnOff = new JButton("Wy³¹cz");
		buttonsPanel = new JPanel();
		
		turnOn.addActionListener(new buttonEvent(true));
		turnOff.addActionListener(new buttonEvent(false));
		
		buttonsPanel.add(turnOn);
		buttonsPanel.add(turnOff);
		
		lightingPanel = new JPanel();
		lightingPanel.setBackground(Color.black);
		
		JPanel southWest = new JPanel(new BorderLayout());
		status = new JLabel("Wy³¹czone");
		statusPanel = new JPanel();
		statusPanel.add(status);
		southWest.add(statusPanel,BorderLayout.WEST);
		
		add(buttonsPanel, BorderLayout.NORTH);
		add(lightingPanel, BorderLayout.CENTER);
		add(southWest, BorderLayout.SOUTH);
	}
	private class buttonEvent implements ActionListener {
		private boolean turn;
		public buttonEvent (boolean t){
			this.turn = t;
		}
		public void actionPerformed(ActionEvent e){
			lightingPanel.setBackground(!turn?Color.black:Color.yellow);
			status.setText(turn?"W³¹czone":"Wy³¹czone");
			turnOn.setEnabled(!turn);
			turnOff.setEnabled(turn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zadanie1 window = new Zadanie1();
		window.setVisible(true);
		
	}

}
