package cw3;
class Watek2 implements Runnable {

	private String nazwa;
	public Watek2(String nazwa) {
		this.nazwa = nazwa;
	}
	public void run() {
		
		System.out.println();
		for (int i=0;i<5;i++){
			//System.out.print("W¹tek: "+nazwa);
			System.out.println("W¹tek: "+ Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class Zadanie2 {
	public static void main(String [] args) {
		//Watek[] tablicaWatkow = new Watek[10];
		Thread[] tablicaWatkow = new Thread[10];

		for (int i=0;i<10;i++){
			tablicaWatkow[i] = new Thread(new Watek2("W"+i));
			tablicaWatkow[i].setName("W"+i);
			tablicaWatkow[i].start();
		}
	}
}