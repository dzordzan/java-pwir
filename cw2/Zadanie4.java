package cw2;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

//Andrzej Piszczek (c) 2014

public class Zadanie4 extends JFrame {

	/**
	 * @param args
	 */

	private JTextField tResult;
	private JPanel slidersPanel, textPanel, colorPanel;
	private Slider slider1, slider2, slider3;

	class Slider extends JSlider {
		public Slider(){
			super(JSlider.HORIZONTAL, 0, 255, 0);
			setMinorTickSpacing(10);
			setMajorTickSpacing(50);
			setPaintTicks(true);
			setPaintLabels(true);
		}
	}
	class Sliders extends JPanel {
		
		 public Sliders() {
			GridLayout gridLayout = new GridLayout(6,1,5,5);
			setLayout(gridLayout);
			
			slider1 = new Slider();
			slider2 = new Slider();
			slider3 = new Slider();
			add(new JLabel("SUWAKI R-G-B (0-255)"));
			add(slider1);
			add(slider2);
			add(slider3);
			slider1.addChangeListener(new sliderEvent(0));
			slider2.addChangeListener(new sliderEvent(1));
			slider3.addChangeListener(new sliderEvent(2));
			
			add(new JLabel("Kod koloru"));
			tResult = new JTextField(5);
			
			add(tResult);
			}
		 
		 private class sliderEvent implements ChangeListener {
				private int m_index, r, g, b;
				public sliderEvent (int index){
					m_index = index;

				   
				}
				public void stateChanged(ChangeEvent e) {
			        JSlider source = (JSlider)e.getSource();
			        if (!source.getValueIsAdjusting()) {
			            int fps = (int)source.getValue();
			            
					r = colorPanel.getBackground().getRed();
					g = colorPanel.getBackground().getGreen();
					b = colorPanel.getBackground().getBlue();
					if (m_index==0) r = fps; else
						if (m_index==1) g = fps; else
							if(m_index==2) b =fps;
					tResult.setText(String.format("#%02x%02x%02x", r, g, b));
					colorPanel.setBackground(new Color(r,g,b));
				}
				}

			}


	}
	
	public Zadanie4(){
		super("Kolory RGB");
		setSize(240, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		

		Sliders sliders = new Sliders();
		slidersPanel = new JPanel();
		slidersPanel.add(sliders);
		
		//colorPanel.HEIGHT= 50;
		colorPanel = new JPanel();
		colorPanel.setBackground(new Color(0, 0, 0));
		
		
		add(slidersPanel, BorderLayout.NORTH);
		add(colorPanel, BorderLayout.CENTER);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zadanie4 window = new Zadanie4();
		window.setVisible(true);
		
	}

}
