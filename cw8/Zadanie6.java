package cw8;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

//AND PIS
import javax.swing.*;
class Column extends Thread{
	public int xpos;
	public int ypos;
	public String tempText;
	private static String TEXT = "1234ケジズゼゾ567890123ゼゾシスセソキク45678901234567890なズサザジズゼゾシスセソキクケジズゼゾシス";//"123456789012345678901234567890";
	//private final Font FONT = new JLabel().getFont();
	private Random r = new Random();
	public FontMetrics fm;
	private Canvas c = new Canvas();
	public Column(int xpos, int ypos){
		this.xpos = xpos;
		this.ypos = ypos;
		tempText = TEXT.substring(0, r.nextInt(TEXT.length()-10)+10);
		//Canvas c = new Canvas();
		fm = c.getFontMetrics(new Font("", r.nextInt(2), r.nextInt(10)+10));
		start();
	}
	
	public void run(){
		int fast = r.nextInt(4)+1;
		while (true){
			try {
				sleep(fast);
				ypos += 1;//r.nextInt(2);
	        	if (ypos > 1300){
	        		fast = r.nextInt(4)+1;
	        		ypos = -40;
	        		tempText = TEXT.substring(0, r.nextInt(TEXT.length()-5)+5);
	        		fm = c.getFontMetrics(new Font("", r.nextInt(2), r.nextInt(10)+10));
	        	}
	        	//ypos += fm.getHeight() - fm.getHeight() * TEXT.length();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}
}


class Rain extends JPanel {
 
    Random r = new Random();

    private ArrayList<Column> columns;
    
    public Rain()
    {

      columns = new ArrayList<Column>(); 
       
       for (int i=-5; i<1200; i=i+6)
            	columns.add(new Column(i, r.nextInt(1200)));


        setBackground(Color.black);
    }
    @Override
    public void paintComponent(final Graphics g) {
 
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        

        int tpos = 0;
        for (int x=0; x<columns.size(); x++){
   
        	
        	g.setFont(columns.get(x).fm.getFont());
        	tpos = columns.get(x).fm.getHeight() - columns.get(x).fm.getHeight() * columns.get(x).tempText.length();
	        for (int i = 0; i <  columns.get(x).tempText.length(); i++) {

	            g.drawString(Character.toString(columns.get(x).tempText.charAt(i)), columns.get(x).xpos, columns.get(x).ypos+tpos );
	            
	            tpos += columns.get(x).fm.getHeight();
	        }
        }
        setBackground(Color.black);
 
       
    }
 

}

public class Zadanie6 extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final Random rd = new Random();
                final JFrame okno = new JFrame("GUI");
                okno.setSize(800, 800);
                okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                okno.setVisible(true);
                //);
                final Rain rain = new Rain();
                okno.add(rain);
                
                Timer t = new Timer(5, new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						rain.repaint();
					}
				});
        	    t.start();
                
            }
        });
    }
}