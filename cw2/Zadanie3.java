package cw2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Andrzej Piszczek (c) 2014

public class Zadanie3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
	private JButton bDot, bEqual, bPlus, bSlash, bMinus, bMultiply; 
	private JTextField tResult;
	private JPanel buttonsPanel, textPanel;
	private Float input1, input2;
	private String operation ="";
	class Buttons extends JPanel {
		
		 public Buttons() {
			GridLayout gridLayout = new GridLayout(4,4,5,5);
			setLayout(gridLayout);
			b1 = new JButton("1");
			b2 = new JButton("2");
			b3 = new JButton("3");
			b4 = new JButton("4");
			b5 = new JButton("5");
			b6 = new JButton("6");
			b7 = new JButton("7");
			b8 = new JButton("8");
			b9 = new JButton("9");
			b0 = new JButton("0");
			bDot = new JButton(".");
			bEqual = new JButton("=");
			bPlus = new JButton("+");
			bSlash = new JButton("/");
			bMinus = new JButton("-");
			bMultiply = new JButton("*");
			add(b7);add(b8);add(b9);add(bSlash);
			add(b4);add(b5);add(b6);add(bMultiply);
			add(b1);add(b2);add(b3);add(bMinus);
			add(b0);add(bDot);add(bEqual);add(bPlus);
			b1.addActionListener(new buttonEvent("1"));
			b2.addActionListener(new buttonEvent("2"));
			b3.addActionListener(new buttonEvent("3"));
			b4.addActionListener(new buttonEvent("4"));
			b5.addActionListener(new buttonEvent("5"));
			b6.addActionListener(new buttonEvent("6"));
			b7.addActionListener(new buttonEvent("7"));
			b8.addActionListener(new buttonEvent("8"));
			b9.addActionListener(new buttonEvent("9"));
			b0.addActionListener(new buttonEvent("0"));
			bDot.addActionListener(new buttonEvent("."));
			
			bPlus.addActionListener(new buttonEventA("+"));
			bMinus.addActionListener(new buttonEventA("-"));
			bSlash.addActionListener(new buttonEventA("/"));
			bMultiply.addActionListener(new buttonEventA("*"));
			
			bEqual.addActionListener(new buttonEventR());

			
			}
		 private class buttonEvent implements ActionListener {
				private String number;
				public buttonEvent (String n){
					this.number = n;
				}
				public void actionPerformed(ActionEvent e){
					tResult.setText(tResult.getText()+number);
				}
			}		 
		 private class buttonEventA implements ActionListener {
				private String number;
				public buttonEventA (String n){
					this.number = n;
				}
				public void actionPerformed(ActionEvent e){
					if (operation != "")
						bEqual.doClick();
						//JOptionPane.showMessageDialog(null, "Wykonuje tylko jedno dzia³anie!"); else {
					operation = number;
					input1 = Float.parseFloat(tResult.getText());
					tResult.setText(tResult.getText()+number); 
					//	}
				}
			}
		 private class buttonEventR implements ActionListener {
				private Float result;

				public void actionPerformed(ActionEvent e){
					input2 = Float.parseFloat(tResult.getText().substring(tResult.getText().indexOf(operation)+1));
					
					if (operation == "+") result=input1+input2; else 
						if (operation == "-") result=input1-input2; else
							if (operation == "/") result=input1/input2; else 
								if (operation == "*") result=input1*input2; 
								
							
					tResult.setText(String.valueOf(result));
					input1 = result;
					//input2 = 0.00;
					operation = "";
				}
			}

	}
	
	public Zadanie3(){
		super("Kalkulator");
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		

		Buttons buttons = new Buttons();
		buttonsPanel = new JPanel();
		buttonsPanel.add(buttons);
	
		textPanel = new JPanel();
		tResult = new JTextField(16);
		tResult.setHorizontalAlignment(JTextField.RIGHT);
		textPanel.add(tResult);
		
		add(buttonsPanel, BorderLayout.CENTER);
		add(textPanel, BorderLayout.NORTH);

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zadanie3 window = new Zadanie3();
		window.setVisible(true);
		
	}

}
