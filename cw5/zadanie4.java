package cw5;
// Andrzej Piszczek 2014
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class CheckRange implements Callable<Integer>{
	 private int start;
	 private int end;
	 private long number;
		
	 public CheckRange(int start, int end, long number){
		 this.end = end;
		 this.start = start;
		 this.number = number;
	 }
	 public Integer call() throws Exception {
		 int wynik = 0;
	 
		 for(int i = start ; i < end; i++){
			// System.out.println(number + "; " + i + "; " + end);
			 if (number%i==0){
				 
				 wynik = i;
			 }
				 
	 	}
		return wynik;
}
}


public class zadanie4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
	
		 
		 int MAX_THREADS = 10;
		 int CHECK_RANGE = 10;
		 System.out.println("Podaj liczbê do sprawdzenia:");
		 //Scanner input = new Scanner(System.in);
		 long number = new Scanner(System.in).nextLong();
		 
		 Stoper time = new Stoper();
		 time.start();
		 double max = Math.sqrt(number);
		 
		 // max iloœæ w¹tków
		 // wielkoœc tablicy w zale¿noœci od rangi liczb jak¹ sprawdzamy
		 
		 int arraySize = (int)Math.ceil(max/CHECK_RANGE);
		 System.out.println("Iloœæ przedzia³ów: "+ arraySize);
		 ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS); 
		 CheckRange[] checker = new CheckRange[arraySize];
		 Future<Integer>[] futures = new Future[arraySize];
		 
		 int i = 0;
		 int x = 2;
		 while ( x < max ){
			 
			 checker[i] = new CheckRange(x, ((x+CHECK_RANGE)>max)?(int)Math.ceil(max):x+CHECK_RANGE, number);
			 futures[i] = executor.submit(checker[i]); 
			 x += CHECK_RANGE;
			 i++;
		 }
		
		 for ( i = 0; i < futures.length; i++) {
			 try {
			
				 if (futures[i].get()>0){
					 System.out.println("Podana liczba nie jest liczb¹ pierwsz¹. Pierwszy dzielnik to: "+ futures[i].get());
					 executor.shutdownNow();
					 break;
				 }
			 } catch ( InterruptedException | ExecutionException ex) {
	
				 System.out.println("B³¹d");
			 }
		 }
		 executor.shutdown();
		 
		 while(!executor.isTerminated()) {}
		 

		 time.stop();
		 System.out.println("Czas dzia³ania to: "+time.toString());
		 }

		}
