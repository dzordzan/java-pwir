package cw4;
// Andrzej Piszczek 2014

class Schowek {
	 private int wartosc;
	 
	 public synchronized int zmien() {
		 wartosc += 10;
		 wartosc -= 10;
		 return wartosc;
	 }
	 public String toString() {
		 return ("Aktualna wartoœæ przechowywana w schowku: " + wartosc);
	 }
}


	class Zmiennik implements Runnable {
		private Schowek s;
		Zmiennik(Schowek s) {
			this.s = s;
			new Thread(this).start();
		}
		public void run() {
		for(int i = 1; i<=100; i++) {
			s.zmien();
			
			System.out.println(s.toString());
			try {
			Thread.sleep((int)(Math.random() * 10));
			} catch (InterruptedException e) {}
			}
		}
		}


	public class Zadanie3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Schowek schowek1 = new Schowek();

		new Zmiennik(schowek1);
		new Zmiennik(schowek1);
		new Zmiennik(schowek1);
		new Zmiennik(schowek1);
	}

}
