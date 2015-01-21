package cw5;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// (c) 2014 Andrzej Piszczek

class hostChecker implements Runnable {
	String hostName;
	public  hostChecker(String hostName){
	
		this.hostName = hostName;
	}

	@Override
	public void run() {
		 Socket socket = null;
		 boolean reachable = false;
		 try {
			  socket = new Socket(hostName, 80);
			  reachable = true;
		 } catch (UnknownHostException e) {
		 } catch (IOException e) { 
		 } finally { 
		  if (socket != null) 
		  try { 
			  socket.close(); 
		  } catch(IOException e) {}
		 }
		 
		 System.out.println("["+hostName+"] "+(reachable?"aktywny":"nieaktywny")); 
		
	}
}
public class Zadanie1 {

 
	public static void main(String[] args) {
		String[] hosty = {"mam.pl","z.pl","o2.pl", "fxxa2.pl", 
				"xxaa2.pl","onet.pl"
				, "gazeta.pl", "o2.p",
				"z222z.pl", "pudelek.pl", 
				"facebook.com","xxaa2.pl",};
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i=0; i<hosty.length; i++){

			executor.execute(new hostChecker(hosty[i]));
		 }
		 executor.shutdown();

	}
 	
}
 

