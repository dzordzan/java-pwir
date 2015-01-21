package cw1;
// Andrzej Piszczek (c) 2014
class Timer {
	private long start, stop;

	public Timer() {
		start = System.currentTimeMillis();
	}
	
	public void stopTimer(){
		stop = System.currentTimeMillis();
		//return start - stop;
	}

	@Override
	public String toString() {
		return "Czas ¿ycia klasy to:" +
				(stop - start);
	}
	
	
}
public class zad1 {
	

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method sadasstub
		Timer klasa1 = new Timer();
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		klasa1.stopTimer();
		System.out.print(klasa1.toString());
	}

}
