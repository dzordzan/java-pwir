package cw7;
// Andrzej Piszczek 2014

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

class Pojemnik {
	private ReentrantLock r1;
	private Boolean isEmpty=true;
	public Pojemnik (){
		this.r1 = new ReentrantLock(true);
	}
	 
	void put (int id ){
		r1.lock(); 
		try {
			//Sprawdzenie na koñcu na wszelki wypadek czy pojemnik by³ pusty jak produkowaliœmy
			System.out.println("[Producent] Produkuje towar id: "+ id +". Czy by³ pusty - "+isEmpty);
			isEmpty=false;
			try {
				Thread.sleep((int)(Math.random() * 50));
			} catch (InterruptedException e) {}

		} finally{
			r1.unlock();
		}
		
	}
	void get (int id){
		r1.lock();
		try {
			System.out.println("[Konsument] Konsumuje towar id: "+ id+". Czy by³ pusty - "+isEmpty);
			isEmpty=true;
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {}
		} finally
		{
			r1.unlock();
			
		}
	
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
			p.get(i);

		}
	}
}



public class Zadanie1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pojemnik p = new Pojemnik();

		new Producent(p);
		new Konsument(p);
		// TODO Auto-generated method stub

	}

}
