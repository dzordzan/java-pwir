package cw2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Andrzej Piszczek (c) 2014

public class Zadanie2 extends JFrame {

	/**
	 * @param args
	 */
	private JButton count;
	private JList<Double> currencyBase, currencyTo;
	private JPanel buttonsPanel, currencyPanel, resultPanel;
	private JLabel result;
	private JTextField value;
	
	// {x/USD, x/EUR, x/PLN} x- waluta bazowa
	private double[] PLN = {0.3, 0.24, 1};
	private double[] EUR = {1.28, 1, 4.28};
	private double[] USD = {1, 0.78, 3.29};
	
	public Zadanie2(){
		super("Kalkulator walut");
		setSize(300, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	
	    
		count = new JButton("Przelicz");
		buttonsPanel = new JPanel();
		count.addActionListener(new buttonEvent());
		value = new JTextField(10);
		
		buttonsPanel.add(new JLabel("Podaj kwote: "));
		
		buttonsPanel.add(value);
		buttonsPanel.add(count);
		
		String[] selections = { "USD", "EUR" , "PLN" };
		currencyBase = new JList(selections);
		currencyBase.setSelectedIndex(0);
		currencyTo = new JList(selections);
		currencyTo.setSelectedIndex(1);
		currencyPanel = new JPanel();
		currencyPanel.add(new JLabel("Przelicz z: "));
		currencyPanel.add(currencyBase);
		currencyPanel.add(new JLabel(" na "));
		currencyPanel.add(currencyTo);

		
		result = new JLabel("0.00");
		resultPanel = new JPanel();
		resultPanel.add(result);
		
		add(currencyPanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.SOUTH);
	}
	private class buttonEvent implements ActionListener {
	
		public void actionPerformed(ActionEvent e){
			Double res = new Double (0.0);
			switch (currencyBase.getSelectedIndex()) {
				case 0:  res = new Double(USD[0]*USD[currencyTo.getSelectedIndex()]); break;
				case 1:  res = new Double(EUR[1]*EUR[currencyTo.getSelectedIndex()]); break;
				case 2:  res = new Double(PLN[2]*PLN[currencyTo.getSelectedIndex()]); break;
				
			}
			res = res*(Double.parseDouble(value.getText()));
			result.setText(res.toString());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zadanie2 window = new Zadanie2();
		window.setVisible(true);
		
	}

}
