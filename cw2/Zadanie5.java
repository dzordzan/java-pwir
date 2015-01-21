package cw2;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// (c) 2014 Andrzej Piszczek

class Window extends JFrame{
	public Window(String title ){
		super(title);
		setSize(350, 310);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new GridLayout(1,2,5,5));
		
	}
}

class Label extends JLabel{
	public Label(String text){
		super(text);
		if (text=="%")
			setHorizontalAlignment(JLabel.LEFT);else
		setHorizontalAlignment(JLabel.RIGHT);
	}
}
class Row extends JPanel{
	public Row(int row){
		super();
		setLayout(new GridLayout(1,row));
	}
}
public class Zadanie5 {

	
	private JCheckBox years, cb_months, monthly, quarterly, equals, falling;
	private JButton count;
	private JTextField loan, nominalRate, tf_months, creditCost, interest;
	
	private class buttonCount implements ActionListener {
		

		public void actionPerformed(ActionEvent e){
			//kwota zaci�gnietego kredytu
			int S = Integer.parseInt(loan.getText());
			// oprocentowanie
			Double r = Double.parseDouble(nominalRate.getText())/100;
			// ilosc rat w roku
			int m = (monthly.isSelected())?12:4;
			// ile lat bedziemy splacac
			int n = (years.isSelected())?Integer.parseInt(tf_months.getText())*m:Integer.parseInt(tf_months.getText())*m/12;
			Double q = 1 + (r / m);
			Double x = Math.pow(q, n);
			Double rata = S * x*(q-1)/(x-1);
			
			//System.out.println("S:"+S + " n:"+n+" r:"+r+" m:"+m+" x:"+x+" q:"+q);
			Double cz_kapitalowa =  (double) (S/n);
			Double cz_odsetkowa = S*r/m;
			interest.setText(Double.toString(rata));
			creditCost.setText(Double.toString(rata*n-S));
			//JOptionPane.showMessageDialog(null, Double.toString(rata));
			/*
			cz�� kapita�owa = pocz�tkowa kwota kredytu/ilo�� wszystkich rat
			cz�� odsetkowa = kwota kredytu pozosta�a do sp�aty * oprocentowanie w skali roku/ilo�� rat w roku
			rata =  cz�� kapita�owa + cz�� odsetkowa
			Wz�r na obliczenie raty sta�ej kredytu:
			
			rata = S * q^n * (q-1)/(q^n-1)
			S � kwota zaci�gni�tego kredytu
			n � ilo�� rat
			q � wsp�czynnik r�wny 1 + (r / m), gdzie q^n � �q� do pot�gi �n�
			r � oprocentowanie kredytu
			m � ilo�� rat w okresie dla kt�rego obowi�zuje oprocentowanie �r�. 
			Najcz�ciej oprocentowanie podawanej jest w skali roku, a raty p�acone s� co miesi�c, wi�c �m� wtedy jest r�wne 12.
			*/
		}
	}
		
	public Zadanie5(){
		JPanel labels = new JPanel();
		JPanel options = new JPanel();
		options.setSize(300,300);
		Window window = new Window("Kalkulator kredytowy");
		GridLayout gridLayout = new GridLayout(8,1,10,10);
		
		labels.setLayout(gridLayout);
		options.setLayout(gridLayout);
	
		Row row0 = new Row(3);
		Row row1 = new Row(3);
		Row row2 = new Row(2);
		Row row3 = new Row(3);
		Row row4 = new Row(2);
		
		loan = new JTextField("100000", 10);//,
		nominalRate = new JTextField("3.5", 5);
		tf_months = new JTextField("12", 3);//, 
		creditCost = new JTextField("", 10);
		interest = new JTextField("", 10);
		years = new JCheckBox("lata", true);
		cb_months = new JCheckBox("miesi�ce");
		
		monthly = new JCheckBox("miesi�czna", true);
		quarterly = new JCheckBox("kwartalna");
		equals = new JCheckBox("r�wne", true);
		falling = new JCheckBox("malej�ce");
		
		count = new JButton("Oblicz");
		count.addActionListener(new buttonCount());
		
		row0.add(nominalRate);
		row0.add(new Label("%"));
		row1.add(years);
		row1.add(cb_months);
		row1.add(tf_months);
		row2.add(monthly);
		row2.add(quarterly);
		row3.add(equals);
		row3.add(falling);
		row4.add(count);
		row4.add(new JLabel(""));
		options.add(loan);
		options.add(row0);
		options.add(row1);
		options.add(row2);
		options.add(row3);
		options.add(row4);
		options.add(creditCost);
		options.add(interest);
		
		labels.add(new Label("Kwota kredytu"));
		labels.add(new Label("Oprocentowanie nominalne"));
		labels.add(new Label("Okres kredytowania"));
		labels.add(new Label("Kapitalizacja"));
		labels.add(new Label("Raty"));
		labels.add(new Label(""));
		labels.add(new Label("Koszt kredytu"));
		labels.add(new Label("Odsetki"));
		
		window.add(labels);
		window.add(options);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		new Zadanie5();
		//super();
	}

}
