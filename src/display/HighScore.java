package display;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Element.EleButton;
import Element.EleLabel;

public class HighScore extends JPanel {
		private static final long serialVersionUID = 1L;
		public long point;
		public HighScore() {
			//----
		}
                
		public HighScore(long point,ActionListener main) {
			try {
                            this.point = point;
                            this.setBackground(new Color(241, 98, 69));
                            this.setBounds(0,0,1000,600);
                            this.setFocusable(true);
                            this.setLayout(null);

                            EleLabel showPoint = new EleLabel("Total : "+this.point,30,400,200,200,100);
                            showPoint.setForeground(Color.white);
                            
                            EleButton menu = new EleButton("Home",15,380,300,200,50);
                            menu.addActionListener(main);
                            
                            this.add(showPoint);
                            this.add(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
