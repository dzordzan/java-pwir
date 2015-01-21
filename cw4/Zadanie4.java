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
				System.out.println ("Konsument: czekam na produkcjê...");
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
		System.out.println ("Producent: czekam na konsumpcjê...");
		wait(); 
	} catch (InterruptedException e) {}
	}

	Towar t = new Towar();
	this.lista.add(t);
	System.out.println("Produkcja: ("+lista.size()+") "+t.toString());
	
	// Po dodaniu produktu powiadom drugi czekaj¹cy w¹tek, ¿e mo¿e pobraæ z listy 
	// Co jeœli jest kilku producentów i czekaj¹cym w¹tkiem jest w¹tek, który ma dodaæ do listy
	// a bêdzie ona przepe³niona ?? 
	// Albo jeœli "wepcha³o" siê kilka w¹tków dodawania przed konsumpcje i jest wiêcej
	// produktów dostêpnych, a tylko jeden w¹tek zostaje odpauzowany (a mog³by by to byæ 2 naraz)
	
	
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
