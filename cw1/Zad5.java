package cw1;
import java.util.Arrays;
//Andrzej Piszczek (c) 2014
class Student5 implements Comparable<Student5>{
	private String imie, nazwisko;
	private int nrAlbumu;
	public Student5(String imie, String nazwisko, int nrAlbumu) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nrAlbumu = nrAlbumu;
	}


@Override
	public String toString() {
		return "Student [imie=" + imie + ", nazwisko=" + nazwisko
				+ ", nrAlbumu=" + nrAlbumu + "]";
	}

public int compareTo(Student5 other) {
   int cNazwisko;
   int cImie;
   cNazwisko = this.nazwisko.compareTo(other.nazwisko);
	if (cNazwisko == 0){
		cImie = this.imie.compareTo(other.imie);
		if (cImie == 0){
			if (this.nrAlbumu == other.nrAlbumu)
				
	            return 0;
	        else if (this.nrAlbumu > other.nrAlbumu)
	            return 1;
	        else
	            return -1;
		} else
			return cImie;
	} else 
		return cNazwisko;
		
    }
}
public class Zad5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student5[] lista = new Student5[4];
		 
		lista[0] = new Student5("Jan", "Kowalski", 432187);
		lista[1] = new Student5("Adam", "Nowak", 332132);
		lista[2] = new Student5("Joanna", "Wyszek", 632165);
		lista[3] = new Student5("Ania", "Nowak", 321419);
		
		for (int i=0; i<lista.length; i++)
			System.out.println(lista[i].toString());
		Arrays.sort(lista);
		System.out.println("Po sortowaniu:");
		for (int i=0; i<lista.length; i++)
			System.out.println(lista[i].toString());
        //System.out.print(lista.toString());
		// TODO Auto-generated method stub

	}

}
