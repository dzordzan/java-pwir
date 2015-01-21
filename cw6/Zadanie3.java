package cw6;
// Andrzej Piszczek 2014
import java.util.concurrent.Semaphore;
public class Zadanie3 {
	 public static void main(String[] args) {

		 new Litera("A").start();
		 new Litera("B").start();
		 new Litera("C").start();
	 }
}
class Litera extends Thread {
	 private static final Semaphore sA = new Semaphore(1, true);
	 private static final Semaphore sB = new Semaphore(0, true);
	 private static final Semaphore sC = new Semaphore(0, true);
	 private String nazwa;
	
	 public Litera(String nazwa) {
		 this.nazwa = nazwa;

	 }
	
	 @Override
	 public void run() {
		 for (int i=0;i<100;i++){
			 try {
				 
				 if (this.nazwa == "A") sA.acquire();
				 if (this.nazwa == "B") sB.acquire();
				 if (this.nazwa == "C") sC.acquire();
				 System.out.print(this.nazwa);
				 sleep((long)(Math.random()*1000));
			 } catch (InterruptedException e) {
				 System.out.println("B³¹d");
			 } finally {

				 if (this.nazwa == "A") sB.release();
				 if (this.nazwa == "B") sC.release();
				 if (this.nazwa == "C") sA.release();
				 
			 }
	 	}
	 }
}
