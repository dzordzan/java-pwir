package cw6;
import java.util.concurrent.Semaphore;

class SprawdzajParking extends Thread {
	private Semaphore semafor;
	 public SprawdzajParking(final Semaphore semafor) {
		 this.semafor = semafor;
		 setDaemon(true);
	 }
	 public void run() {
		 while (true) {
			 System.out.println(
					 (semafor.availablePermits()==0)?"[INFO] Brak miejsc w parkingu. W kolejce aut "+
					 semafor.getQueueLength():"[INFO] Wolnych miejsc na parkingu: "+semafor.availablePermits() );
			 try {
				 sleep(1000);
			 } catch (InterruptedException e) {}
		 }
	 }
	}


public class Zadanie2 {
	 public static void main(String[] args) {
		 final Semaphore semafor = new Semaphore(20, true);
		 new SprawdzajParking(semafor).start();

		 for(int i = 1; i <= 100; i++) {
				 new Car(semafor, "C"+i).start();
				 try {
					 Thread.sleep(100);
				 } catch(InterruptedException e) {
					 System.out.println("B��d");
				 }
		 }

	 }
}
class Car extends Thread {
	 
	 private String nazwa;
	 private Semaphore semafor;
	 public Car(final Semaphore semafor, String nazwa) {
		 this.nazwa = nazwa;
		 this.semafor = semafor;

	 }
	
	 @Override
	 public void run() {
		Boolean check = semafor.tryAcquire();
		 if (!check){
			 if ( Math.random()*100 > 75){
				 System.out.println("Kierowca "+this.nazwa+" to popierdoli�, jedzie na inny parking.");
				 return;}
			System.out.println("Kierowca "+this.nazwa+" zajmuje miejsce w kolejce.");	
		 } 
				 
					 
		try {
			// i tutaj pojawia si� problem, �eby to by�o poprawnie trzebaby�oby sobie stworzy�
			// jak�� funkcje kt�ra wy�wietla�a by info, bo tak to jest problem z dublowaniem kodu 
			// po elsa'ch (kt�rych tutaj nie ma, bo zrobi�em nie-poprawnie robi�c na szybko zmienn� check
			// przez co u�ycie semafor�w i atomowych dost�p�w o dupe rozbi� bo tak na prawd�
			// mi�dzy stworzeniem zmiennej check i ponownym jej sprawdzeniem pare linijek ni�ej
			// mog�o si� ju� co� zmieni�, taki offtop
			 if (!check)
				semafor.acquire(); 
		 					
			 System.out.println(this.nazwa+" wjecha� na parking. Pozosta�o wolnych miejsc: "+ semafor.availablePermits());
			 sleep((long)(Math.random()*4500));
			
		
		 } catch (InterruptedException e) {
			 System.out.println("B��d");
		 } finally {
			 System.out.println(this.nazwa+" wyjecha� z parkingu");
			 semafor.release();
		 }
		}
	 	
	 
}
