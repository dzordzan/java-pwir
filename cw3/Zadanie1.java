package cw3;
class Watek implements Runnable {
	private String nazwa;
	public Watek(String nazwa) {
		this.nazwa = nazwa;
	}
	public synchronized void run() {

		//System.out.println();
		for (int i=0;i<5;i++){
			System.out.print("W¹tek: "+nazwa);
			System.out.println(" | W¹tek: "+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
public class Zadanie1 {
	public static void main(String [] args) {
		Thread[] tablicaWatkow = new Thread[10];
		
		//Watek[] tablicaWatkow = new Watek[10];
		
		for (int i=0;i<10;i++){
			tablicaWatkow[i] = new  Thread(new Watek("W"+i));
			tablicaWatkow[i].setName("W_setName_"+i);
			tablicaWatkow[i].start();
		}
	}
}