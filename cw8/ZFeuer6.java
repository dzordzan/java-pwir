package cw8;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

class Pozycja{
	int x,y,move,dlugosc,index;
	public Pozycja(int x){
		this.x=x;		
		move=(int)(Math.random()*500);;
		dlugosc=(int)(5+Math.random()*30);
		//index=(int)(Math.random()*9);		
		index=3;
	}
	
	public int getIndex(){
		return index;
	}
	public void setIndex(int index){
		this.index=index;
	}
	
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x=x;
	}	
	
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y=y;
	}
	
	public int getDlugosc(){
		return dlugosc;
	}
	public void setDlugosc(int dlugosc){
		this.dlugosc=dlugosc;
	}
	
	public int getMove(){
		return move;
	}
	public void setMove(int move){
		this.move=move;
	}	
	public void zwiekszMove(int move){
		this.move+=move;
	}
}

class Panelek6 extends JPanel{
	
	final static int SIZE = 18;
	final static int WIDTH = 1200;
	final static int HEIGHT = 800;
	int index=0;
	private static final char[] tab = {'&', '$', '@', '#', '%', '5', '6', '7', '8', '9'};
	private Thread watek1;
	private Pozycja[] pozycje;
	private Font czcionka = new Font ("Arial", Font.BOLD, SIZE);
	private Color color = new Color(0,230,0);	
	
	public Panelek6(){
		pozycje = new Pozycja[WIDTH/SIZE];				
		for(int i=0; i<WIDTH/SIZE; i++){
			pozycje[i]=new Pozycja(i*SIZE);	
		}			
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	    	    
	    
	    g.setFont(czcionka);
	    g.setColor(color);
	    setBackground(Color.BLACK);
	    
	    for(int j=0; j<WIDTH/SIZE; j++){			
			pozycje[j].setY(0);	    	
			for(int i=0; i<pozycje[j].getDlugosc(); i++){			
		    	g.drawChars(tab,index,1,pozycje[j].getX(),pozycje[j].getY()+pozycje[j].getMove());	    	
		    	pozycje[j].setY(pozycje[j].getY()+SIZE+2);
		    }
		}
	    
	    	    
	    	    	    
	    Runnable r = new Runnable(){
	    	public void run(){	    		
	    		SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						for(int i=0; i<WIDTH/SIZE; i++){
							pozycje[i].zwiekszMove(1);							
							//index=(int)(Math.random()*6);
							//System.out.println (getY());
							if(pozycje[i].getMove()>=HEIGHT+SIZE*pozycje[i].getDlugosc()){
								pozycje[i].setDlugosc((int)(5+Math.random()*30));
								pozycje[i].setMove(0-pozycje[i].getDlugosc()*SIZE);
							}		
						}
				
						try{
							Thread.sleep(1);
						}
						catch (InterruptedException e){}
						repaint();
					}
			});
	    		
	    	}	    	
	    };	    
	    
	    watek1 = new Thread(r);	    
	    watek1.start();
	    
	}	
}

class Okno6 extends JFrame{	
	
		
	public Okno6(String nazwa){
		super(nazwa);
		
				
		final Panelek6 panel = new Panelek6();	
				
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				add(panel);							
			}
		});		
		
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
		
}	


public class ZFeuer6 { 
   
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Okno6 okienko = new Okno6("MATRIX");				
			}
		});    	
    }
}
