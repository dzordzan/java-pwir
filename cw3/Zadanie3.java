package cw3;
class Watek3 extends Thread {
	private String nazwa;
	public Watek3(String nazwa) {
		this.nazwa = nazwa;
	}
	public void run() {
		
		//System.out.println();
		for (int i=0;i<5;i++){
			System.out.print("W¹tek: "+nazwa);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("W¹tek: "+nazwa+" Zosta³em przerwany!");
				e.printStackTrace();
			}
		}
	}
}
public class Zadanie3 {
	public static void main(String [] args) {
		Watek3[] tablicaWatkow = new Watek3[10];
		for (int i=0;i<10;i++){
			tablicaWatkow[i] = new Watek3("W"+i);
			tablicaWatkow[i].start();
		}
		tablicaWatkow[4].interrupt();
	}
}