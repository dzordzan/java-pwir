package cw7;
// Andrzej Piszczek 2014
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class Czytelnik extends Thread {
	 private Ksiazki ksiazki;
	
	 public Czytelnik(Ksiazki ksiazki) {
	 this.ksiazki = ksiazki;
 }
 public void run() {
	 while(true) {
		 ksiazki.odczyt();
		
		 try {
			 Thread.sleep((int)(Math.random()*1000));
		 } catch (InterruptedException e) {
			 System.out.println("B³¹d");
		 }
		 }
	 }
}
class Pisarz extends Thread {
	 private Ksiazki ksiazki;
	
	 public Pisarz(Ksiazki ksiazki) {
		 this.ksiazki = ksiazki;
	 }
	 public void run() {
		 while(true) {
			
			 ksiazki.zapis("Ksiazka id-"+Math.ceil(Math.random()*10));
		
		 try {
			 Thread.sleep(10000);
		 } catch (InterruptedException e) {
			 System.out.println("B³¹d");
		 }
		 }
	 }
}
class Ksiazki {
	 private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	 private Lock rl = rwl.readLock();
	 private Lock wl = rwl.writeLock();
	 private List<String> nazwyKsiazek = new ArrayList<String>();
	
	 public void zapis(String nazwa) {
		 wl.lock();
		 try {
		
			 System.out.println("Zapisuje now¹ ksiazke: " + nazwa);
		
		 try {
			 Thread.sleep(2000);
		 } catch (InterruptedException e) {
			 System.out.println("B³¹d");
		 }
		
		 	this.nazwyKsiazek.add(nazwa);
		 } finally {
			 wl.unlock();
		 }
	 }
	
	 public String odczyt() {
		 rl.lock();
		 try{
			 Random rand = new Random();

			 int randomNum = rand.nextInt((nazwyKsiazek.size()));
			 System.out.println("Czytelnik czyta sobie: " + nazwyKsiazek.get(randomNum));
			 return nazwyKsiazek.get(randomNum);
		 } finally {
			 rl.unlock();
		 }
	 }
}
public class Zadanie3 {

	 public static void main(String[] args) {
		 Ksiazki ksiazki = new Ksiazki();
	
		 new Pisarz(ksiazki).start();
		 new Czytelnik(ksiazki).start();
	 }

}