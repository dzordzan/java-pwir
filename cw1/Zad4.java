package cw1;
import java.util.Arrays;
//Andrzej Piszczek (c) 2014
class Student implements Comparable<Student>{
	private String imie, nazwisko;
	private int nrAlbumu;
	public Student(String imie, String nazwisko, int nrAlbumu) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nrAlbumu = nrAlbumu;
	}
	
  public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getNrAlbumu() {
		return nrAlbumu;
	}

	public void setNrAlbumu(int nrAlbumu) {
		this.nrAlbumu = nrAlbumu;
	}

@Override
	public String toString() {
		return "Student [imie=" + imie + ", nazwisko=" + nazwisko
				+ ", nrAlbumu=" + nrAlbumu + "]";
	}

public int compareTo(Student other) {
        if (this.nrAlbumu == other.nrAlbumu)
            return 0;
        else if (this.nrAlbumu > other.nrAlbumu)
            return 1;
        else
            return -1;
    }
}
public class Zad4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student[] lista = new Student[4];
		 
		lista[0] = new Student("Jan", "Kowalski", 432187);
		lista[1] = new Student("Adam", "Nowak", 332132);
		lista[2] = new Student("Joanna", "Wyszek", 632165);
		lista[3] = new Student("Ania", "Nowak", 321419);
		
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
