package cw4;
// Andrzej Piszczek 2014

// Klasa kolejka na kt�rej dzia�aj� dwa w�tki grupa klient�w Klienci i jeden fryzjer

class Kolejka {	
	
	// Maksymalny rozmiar kolejki
	private int max = 5;
	// n - ilo�� os�b aktualnie w kolejce
	// Pocz�tek dnia, w kolejce 0 os�b
	private int n = 0;
	
	// get'em fryzjer zdejmuje z kolejki nast�pnego klienta
	// synchronizacja wiadomo - �eby klient i fryzjer jednocze�nie nie operowali na zmiennej n
	// w zmiennej "z" znajduje si� ilu klient�w juz dzi� obstrzyg�
	synchronized void get(int z) {
		// Dla test�w czas drzemki i strzy�enia
		long start = System.currentTimeMillis();
		// Je�li w kolejce nie ma nikogo
		if(n<=0){
			try {

				System.out.println ("[Golibroda]: Ucina sobie drzemke.");
				wait();
				System.out.println ("[Golibroda]: Obudzi� si� z drzemki. Spa�:" + (System.currentTimeMillis()-start)+ " milisekund.");
				
			} catch (InterruptedException e) { }
		}
		
		n = n-1;
		System.out.println("[Golibroda]: Prosi kolejnego klienta ("+ z +" dzi�). W kolejce pozosta�o: " + n );//". Strzyg� "+ (System.currentTimeMillis()-start)
	
	}
	// Dodaj do kolejki kolejn� osobe - robia to klienci 
	synchronized void put() {
		if (n == 0){
			// Obud� golibrode 
			// bez znaczenia czy notify czy notifyAll bo i tak tylko jeden w�tek mo�e w tej aplikacji czeka� (golibroda)
			notifyAll();
			
		}
		if( n >= max) {
			// Brak miejsca w poczekalni, ko�cz funkcje 
			System.out.println ("[Klient]: Brak miejsca w poczekalni.");
			return;
		}
		// Zwi�ksz ilo�c ludzi w poczekalni
		n = n +1;
		System.out.println("[Klient]: Zaj�� miejsce w poczekalni. Jest ("+n+") w kolejce");

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
		// do stu klient�w dziennie, mo�na by by�o da� do p�tli while i robi� w niesko�czeno�c
		for(int i = 1; i<=100; i++) {
			// Obs�u� jednego klienta
			p.get(i);
			try {
				// Fryzjer strzy�e do 4 sekund minimum 1 sekunde
				// mniej wi�cej z takimi warto�ciami �atwo mo�e doj�c do przepe�neinia kolejki lub braku os�b w poczekalni
				Thread.sleep((int)(Math.random()*3000 )+1000);
			} catch (InterruptedException e) {}
		}
	}
}
// Klasa kienci - grupa klient�w. Nic nie stoi na przeszkodze, �eby by�o kilka grup klient�w po 100os�b, ale nie ma to znaczenia
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