package cw4;


class Watek extends Thread {
	private String nazwa;
	public Watek(String nazwa) {
		this.nazwa = nazwa;
	}
	public void run() {
		
		for (int i=0;i<5;i++){
			System.out.print("W¹tek: "+nazwa);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Zadanie1 {
	public static void main(String [] args) {
		Watek[] tablicaWatkow = new Watek[10];
		tablicaWatkow[0] = new Watek("W1");
		tablicaWatkow[0].start();
	}
}