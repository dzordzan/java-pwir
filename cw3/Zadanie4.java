package cw3;
class Watek4 extends Thread {
	private String tekst, napis;
	private int liczbaTabluacji;
	
	public Watek4(String tekst, int liczbaTabulacji){
		napis = "";
		this.tekst = tekst;
		this.liczbaTabluacji = liczbaTabulacji;
		for (int i=0;i<liczbaTabulacji;i++)
			napis = napis+"\t";
		napis = napis + tekst;
	}
	public void run() {
		
		//System.out.println();
		for (int i=0;i<500;i++){
			for(int x=0; x < napis.length(); x++) 
				System.out.print (napis.charAt(x));
			System.out.println (i);
			yield();
			/*try {
				//sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
}
public class Zadanie4 {
	public static void main(String [] args) {
		Watek4 marek = new Watek4("Marek", 1);
		marek.start();
		try {
			marek.join();
		} catch (InterruptedException e) {}
		Watek4 kasia = new Watek4("Kasia", 2);
		kasia.start();
		try {
			kasia.join();
		} catch (InterruptedException e) {}
		Watek4 andrzej = new Watek4("Andrzej", 3);
		andrzej.start();
		try {
			andrzej.join();
		} catch (InterruptedException e) {}

		Watek4 natalia = new Watek4("Natalia", 4);
		natalia.start();


	}
}