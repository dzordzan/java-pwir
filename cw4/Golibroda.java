package cw4;
// Andrzej Piszczek 2014

// Klasa kolejka na której dzia³aj¹ dwa w¹tki grupa klientów Klienci i jeden fryzjer

class Kolejka {	
	
	// Maksymalny rozmiar kolejki
	private int max = 5;
	// n - iloœæ osób aktualnie w kolejce
	// Pocz¹tek dnia, w kolejce 0 osób
	private int n = 0;
	
	// get'em fryzjer zdejmuje z kolejki nastêpnego klienta
	// synchronizacja wiadomo - ¿eby klient i fryzjer jednoczeœnie nie operowali na zmiennej n
	// w zmiennej "z" znajduje siê ilu klientów juz dziœ obstrzyg³
	synchronized void get(int z) {
		// Dla testów czas drzemki i strzy¿enia
		long start = System.currentTimeMillis();
		// Jeœli w kolejce nie ma nikogo
		if(n<=0){
			try {

				System.out.println ("[Golibroda]: Ucina sobie drzemke.");
				wait();
				System.out.println ("[Golibroda]: Obudzi³ siê z drzemki. Spa³:" + (System.currentTimeMillis()-start)+ " milisekund.");
				
			} catch (InterruptedException e) { }
		}
		
		n = n-1;
		System.out.println("[Golibroda]: Prosi kolejnego klienta ("+ z +" dziœ). W kolejce pozosta³o: " + n );//". Strzyg³ "+ (System.currentTimeMillis()-start)
	
	}
	// Dodaj do kolejki kolejn¹ osobe - robia to klienci 
	synchronized void put() {
		if (n == 0){
			// ObudŸ golibrode 
			// bez znaczenia czy notify czy notifyAll bo i tak tylko jeden w¹tek mo¿e w tej aplikacji czekaæ (golibroda)
			notifyAll();
			
		}
		if( n >= max) {
			// Brak miejsca w poczekalni, koñcz funkcje 
			System.out.println ("[Klient]: Brak miejsca w poczekalni.");
			return;
		}
		// Zwiêksz iloœc ludzi w poczekalni
		n = n +1;
		System.out.println("[Klient]: Zaj¹³ miejsce w poczekalni. Jest ("+n+") w kolejce");

	}
}
// klasa fryzjera
class Fryzjer implements Runnable {
	private Kolejka p;
	Fryzjer(Kolejka p) {
		// Pobiera obiekt kolejki
		this.p = p;
		new Thread(this, "Fryzjer").start();
	}
	public void run() {
		// do stu klientów dziennie, mo¿na by by³o daæ do pêtli while i robiæ w nieskoñczenoœc
		for(int i = 1; i<=100; i++) {
			// Obs³u¿ jednego klienta
			p.get(i);
			try {
				// Fryzjer strzy¿e do 4 sekund minimum 1 sekunde
				// mniej wiêcej z takimi wartoœciami ³atwo mo¿e dojœc do przepe³neinia kolejki lub braku osób w poczekalni
				Thread.sleep((int)(Math.random()*3000 )+1000);
			} catch (InterruptedException e) {}
		}
	}
}
// Klasa kienci - grupa klientów. Nic nie stoi na przeszkodze, ¿eby by³o kilka grup klientów po 100osób, ale nie ma to znaczenia
class Klienci implements Runnable {
	private Kolejka p;
	Klienci(Kolejka p) {
		this.p = p;
	new Thread(this, "Klienci").start();
	}
	public void run() {
		for(int i = 1; i<=100; i++) {
			p.put();
			
			try {
				// klient przychodzi do 5 sekund
				Thread.sleep((int)(Math.random() * 5000));
				
			} catch (InterruptedException e) { }
		}
	}
}



public class Golibroda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Kolejka p = new Kolejka();
		
		// najpierw przychodza klienci potem fryzjer
		new Klienci(p);
		
		new Fryzjer(p);

		//new Klienci(p);
	

	}

}