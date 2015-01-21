package cw8;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

//Andrzej Piszczek (c) 2014

class Okno extends JFrame {

	JButton przycisk, przycisk2, przycisk3, przycisk4;
	JProgressBar pasek, pasek2, pasek3, pasek4;
	Boolean w,w2,w3,w4;
	
public Okno(String nazwa) {
		 super(nazwa);
		 w=false;
		 w2=false;
		 w3=false;
		 w4=false;
		 przycisk = new JButton("Start");
		 przycisk2 = new JButton("Start2");
		 przycisk3 = new JButton("Start3");
		 przycisk4 = new JButton("Start4");
		 pasek = new JProgressBar();
		 pasek2 = new JProgressBar();
		 pasek3 = new JProgressBar();
		 pasek4 = new JProgressBar();
		
		 JPanel panel = new JPanel();
		 panel.setLayout(new GridLayout(4,2));
		 panel.add(przycisk);panel.add(pasek);
		 panel.add(przycisk2);panel.add(pasek2);
		 panel.add(przycisk3);panel.add(pasek3);
		 panel.add(przycisk4);panel.add(pasek4);
		
		 przycisk.addActionListener(new ObslugaZdarzen());
		 przycisk2.addActionListener(new ObslugaZdarzen2());
		 przycisk3.addActionListener(new ObslugaZdarzen3());
		 przycisk4.addActionListener(new ObslugaZdarzen4());
		 add(panel);
		
		 setSize(400, 100);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true);
 }

	 private class ObslugaZdarzen implements ActionListener {
	
		 public void actionPerformed(ActionEvent e) {
			 if (w)
				 return;
			 pasek.setValue(0);
			 w = true;
			 pasek.setStringPainted(true);
		
		 new Thread(new Runnable() {
			 public void run() {
				 for (int i = 0; i <= 100; i++) {
					 final int postep = i;
					 SwingUtilities.invokeLater(new Runnable() {
						 public void run() {
							 pasek.setValue(postep);
						 }
					 });
					 try {
						 Thread.sleep(1000);
					 }
					 	catch(Exception e) { }
				}
				 w = false;
				 }
				 }).start();
			}
	
	}
	 private class ObslugaZdarzen2 implements ActionListener {
			
		 public void actionPerformed(ActionEvent e) {
			 if (w2)
				 return;
			 
			 pasek2.setValue(0);
			 pasek2.setStringPainted(true);
			 w2 = true;
		
		 new Thread(new Runnable() {
			 public void run() {
				 for (int i = 0; i <= 100; i++) {
					 final int postep = i;
					 SwingUtilities.invokeLater(new Runnable() {
						 public void run() {
							 pasek2.setValue(postep);
						 }
					 });
					 try {
						 Thread.sleep(100);
					 }
					 	catch(Exception e) { }
					 }
				 w2 = false;
				 }
				 }).start();
				 }
	
	}
	 private class ObslugaZdarzen3 implements ActionListener {
			
		 public void actionPerformed(ActionEvent e) {
			 if (w3)
				 return;
			 pasek3.setValue(0);
			 pasek3.setStringPainted(true);
			 w3 = true;
		
		 new Thread(new Runnable() {
			 public void run() {
				 for (int i = 0; i <= 100; i++) {
					 final int postep = i;
					 SwingUtilities.invokeLater(new Runnable() {
						 public void run() {
							 pasek3.setValue(postep);
						 }
					 });
					 try {
						 Thread.sleep(800);
					 }
					 	catch(Exception e) { }
					 }
				 w3 = false;
				 }
				 }).start();
				 }
	
	}
	 private class ObslugaZdarzen4 implements ActionListener {
			
		 public void actionPerformed(ActionEvent e) {
			 if (w4)
				 return;
			 pasek4.setValue(0);
			 pasek4.setStringPainted(true);
			 w4 = true;
		
		 new Thread(new Runnable() {
			 public void run() {
				 for (int i = 0; i <= 100; i++) {
					 final int postep = i;
					 SwingUtilities.invokeLater(new Runnable() {
						 public void run() {
							 pasek4.setValue(postep);
						 }
					 });
					 try {
						 Thread.sleep(500);
					 }
					 	catch(Exception e) { }
					 }
				 w4 = false;
				 }
				 }).start();
				 }
	
	}

}
public class Zadanie1 {

	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
		 public void run() {
			 new Okno("Pasek postêpu");
		 }
	 });
	 }
}
