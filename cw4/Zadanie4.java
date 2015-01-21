package cw4;
// Andrzej Piszczek 2014

import java.util.*;
class Towar {
	private int kod;
	private double cena;	
	public Towar() {
		kod = (int)(Math.random() * 100000);
		cena = (Math.random() * 1000);
	}
	public String toString() {
		return "Kod towaru:" + kod + " Cena: " + cena;
	}
}
class Pojemnik {
	private LinkedList<Towar> lista;
	//private Towar towar;

	private int max = 10;

	
	Pojemnik(){
		lista = new LinkedList<Towar>();
		
	}
	synchronized int get() {
		if(lista.size()<=0){
			try {
				System.out.println ("Konsument: czekam na produkcj�...");
				wait();
			} catch (InterruptedException e) { }
		}
		System.out.println("Konsumpcja: ("+lista.size()+") "+lista.removeLast().toString());
		
		
		//notify();
		return 0;
	}
	synchronized void put(int n) {
	if( lista.size() >= max) {
	try {
		System.out.println ("Producent: czekam na konsumpcj�...");
		wait(); 
	} catch (InterruptedException e) {}
	}

	Towar t = new Towar();
	this.lista.add(t);
	System.out.println("Produkcja: ("+lista.size()+") "+t.toString());
	
	// Po dodaniu produktu powiadom drugi czekaj�cy w�tek, �e mo�e pobra� z listy 
	// Co je�li jest kilku producent�w i czekaj�cym w�tkiem jest w�tek, kt�ry ma doda� do listy
	// a b�dzie ona przepe�niona ?? 
	// Albo je�li "wepcha�o" si� kilka w�tk�w dodawania przed konsumpcje i jest wi�cej
	// produkt�w dost�pnych, a tylko jeden w�tek zostaje odpauzowany (a mog�by by to by� 2 naraz)
	
	
	notify();
}
}
class Producent implements Runnable {
	private Pojemnik p;
	Producent(Pojemnik p) {
		this.p = p;
		new Thread(this, "Producent").start();
	}
	public void run() {
		for(int i = 1; i<=10; i++) {
			p.put(i);
			try {
				Thread.sleep((int)(Math.random() * 500));
			} catch (InterruptedException e) {}
		}
	}
}
class Konsument implements Runnable {
	private Pojemnik p;
	Konsument(Pojemnik p) {
		this.p = p;
	new Thread(this, "Konsument").start();
	}
	public void run() {
		for(int i = 1; i<=10; i++) {
			p.get();
			
			try {
				Thread.sleep((int)(Math.random() * 500));
				
			} catch (InterruptedException e) { }
		}
	}
}



public class Zadanie4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Pojemnik p = new Pojemnik();

		new Producent(p);
		new Konsument(p);
		new Konsument(p);
		new Konsument(p);
		// TODO Auto-generated method stub

	}

}
