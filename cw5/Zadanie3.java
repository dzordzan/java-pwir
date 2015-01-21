package cw5;
// Andrzej Piszczek 2014
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



class Zadanie implements Callable<Integer>{
	 private int poczatek;
	 private int koniec;
	 private int[] tablica;
		
	 public Zadanie(int[] tablica, int poczatek, int koniec){
		 this.poczatek = poczatek;
		 this.koniec = koniec;
		 this.tablica = tablica;
	 }
	 public Integer call() throws Exception {
		 int wynik = 0;
	 
		 for(int i = poczatek ; i < koniec; i++){
			 wynik += tablica[i];
			 try {
				 Thread.sleep(10);
			 } catch (InterruptedException e) {
				 System.out.println("B³¹d");
			 }
			}
		 System.out.println("Liczy³em sumê od zakresu: " + poczatek + " do zakresu: " + 
			koniec + " Wynik: " + wynik); 
		 return wynik;
	 	}
}
public class Zadanie3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		 Stoper time = new Stoper();
		 time.start();
		 int suma = 0;
		 int[] tablicaLiczb = new int[1000];
		 
		 for (int i = 0; i < tablicaLiczb.length; i++) {
			 tablicaLiczb[i] = (int)(Math.random()*11);
		 }
		 ExecutorService executor = Executors.newFixedThreadPool(10); 
		 
		 Zadanie[] zadania = new Zadanie[10];
		 Future<Integer>[] futures = new Future[10];
		 int podzial = tablicaLiczb.length / zadania.length;
		 for (int i = 0; i < zadania.length; i++) {
			 zadania[i] = new Zadanie(tablicaLiczb, (i * podzial), ((i+1) * podzial));
			 futures[i] = executor.submit(zadania[i]); 

		 }
		 for (int i = 0; i < futures.length; i++) {
			 try {
				 suma += futures[i].get();
			 } catch ( InterruptedException | ExecutionException ex) {
	
				 System.out.println("B³¹d");
			 }
		 }
		 executor.shutdown();
		 
		 while(!executor.isTerminated()) {}
		 
		 System.out.println("Wszystkie w¹tki zakoñczy³y pracê."); 
		 System.out.println("Wynik to: "+ suma);
		 time.stop();
		 System.out.println("Czas dzia³ania to: "+time.toString());
		 }

		}
