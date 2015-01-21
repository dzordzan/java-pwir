package cw6;
import java.util.concurrent.Semaphore;
public class Zadanie1 {
	 public static void main(String[] args) {
		/* for(int i = 1; i <= 10; i++) {
				 new Goscie("G"+i).start();
				 try {
					 Thread.sleep(100);
				 } catch(InterruptedException e) {
					 System.out.println("B³¹d");
				 }
		 }*/
		 new Zwierz("Adam").start();
		 new Zwierz("Ania").start();
	 }
}
class Zwierz extends Thread {
	 private static final Semaphore semafor = new Semaphore(1, true);
	 private String nazwa;
	
	 public Zwierz(String nazwa) {
		 this.nazwa = nazwa;
		 //System.out.println("Adam z psem w ogrodzie");
	 }
	
	 @Override
	 public void run() {
		 for (int i=0;i<10;i++){
			 try {
				 semafor.acquire();
				 System.out.println(this.nazwa+" w ogrodzie");
				 sleep((long)(Math.random()*10000));
			
			 } catch (InterruptedException e) {
				 System.out.println("B³¹d");
			 } finally {
				 System.out.println(this.nazwa+" wyszed³ z ogrodu");
				 semafor.release();
			 }
	 	}
	 }
}
