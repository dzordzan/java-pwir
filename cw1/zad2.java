package cw1;
import java.util.Scanner;
//Andrzej Piszczek (c) 2014
class Licznik {
	private int ilosc=0;

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc() {
		this.ilosc++;
	}
	
}


public class zad2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String imie; 
		
	    Scanner odczyt = new Scanner(System.in); 
	    imie = odczyt.nextLine();
	    odczyt.close();
	    
		Licznik licznikSpacji = new Licznik();
		
		for (int i=0; i<imie.length(); i++){
			if (imie.charAt(i)== '\u0020')
				licznikSpacji.setIlosc();
		}
		System.out.print("Iloœæ spacji to: "+ licznikSpacji.getIlosc());
	}

}
