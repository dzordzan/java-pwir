package cw9.z2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.*;
//Andrzej Piszczek (c) 2015

public class Zadanie2 extends JFrame {
	private JProgressBar pasek;
	private JTextArea pole;
	private int postep = 0;

	public Zadanie2() {
		super("Test klasy SwingWorker");
		this.setLayout(new BorderLayout());
		pasek = new JProgressBar();
		pasek.setStringPainted(true);
		JPanel panel = new JPanel();
		pole = new JTextArea(10, 40);
		JScrollPane sp = new JScrollPane(pole);
		panel.add(new JLabel("Aktualny stan obliczeñ: "));
		panel.add(pasek);
		add(panel, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
		Zadanie zadanie = new Zadanie();

		zadanie.addPropertyChangeListener(new Obsluga());
		zadanie.execute();
	}

	private class Zadanie extends SwingWorker<Integer, String> {
		@Override
		protected Integer doInBackground() throws Exception {
			int wynik = 0;
			for (int i = 0; i <= 100; i++) {
				try {
					wynik += i;
					publish("Aktualny wynik: " + wynik);
					setProgress(i);
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("B³¹d");
				}
			}
			return wynik;
		}

		@Override
		protected void process(java.util.List<String> lista) {
			for (String wiadomosc : lista) {
				pole.append(wiadomosc + "\n");
			}
		}

		@Override
		protected void done() {
			try {
				int wynik = get();
				pole.append("Wynik koñcowy: " + wynik);
			} catch (Exception e) {
				System.out.println("B³¹d");
			}
		}
	}

	private class Obsluga implements PropertyChangeListener {
		public void propertyChange(PropertyChangeEvent e) {
			if ("progress".equals(e.getPropertyName())) {
				pasek.setValue((Integer) (e.getNewValue()));
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Zadanie2();
			}
		});
	}
}