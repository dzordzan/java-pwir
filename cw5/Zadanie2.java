package cw5;
// Andrzej Piszczek 2014
import java.util.concurrent.*;

class Klient implements Runnable {
	String clientName;
	Klient(String clientName) {
		this.clientName = clientName;
		//new Thread(this, clientName).start();
	}
	public void run() {
		
			try {
				// klient "siedzi" w restauracji 5-6 sekund
				System.out.println ("[Klient]: "+ clientName + " wchodzi. ");
				//System.out.println ("[Klient]: "+ clientName);
				Thread.sleep((int)(Math.random()* 1000 + 5000));
				System.out.println ("[Klient]: "+ clientName + " wychodzi.");
				
				
			} catch (InterruptedException e) { }
		}
	
}

public class Zadanie2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		for(int i = 1; i<=20; i++) {
			executor.execute(new Klient("K"+i));
		}
		
		executor.shutdown();

	}

}