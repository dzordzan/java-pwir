package cw6;
import java.util.concurrent.Semaphore;

public class zad1 {
	 public static void main(String[] args) {

		 new Filozof("test");
		 }
	 }

class Widelec {
	private boolean dirty;
	public Widelec(){
		this.dirty = false;
	}
	public boolean check(){
		return this.dirty;
	}
	public void setClean(){
		this.dirty = false;
	}
	public void setDirty(){
		this.dirty = true;
	}
}
class Filozof extends Thread {
	private static final Semaphore semafor = new Semaphore(2, true);
	private String nazwa;

	 public Filozof(String nazwa) {
		 Widelec [] widelce = new Widelec[5];
		 for(int i = 0; i < 5; i++) {
			 widelce[i] = new Widelec();
		 }
		 
		 this.nazwa = nazwa;

	 }
	
	 @Override
	 public void run() {
		 System.out.println("Goœæ " + nazwa +
				 " przyby³ do hotelu. Aktualna dostêpnoœæ pokoi: " 
				 + semafor.availablePermits() + " Aktualna kolejka: " 
				 + semafor.getQueueLength());
		 try {
			 semafor.acquire();
			 System.out.println("Goœæ: " + nazwa + " zaj¹³ pokój");
			 sleep((long)(Math.random()*10000));
		
		 } catch (InterruptedException e) {
			 System.out.println("B³¹d");
		 } finally {
			 System.out.println("Goœæ: " + nazwa + " opuœci³ pokój");
			 semafor.release();
		 }
		 }
}