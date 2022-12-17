package display;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Element.EleButton;
import Element.EleLabel;
import java.util.ArrayList;
import java.util.Collections;

public class HighScore extends JPanel {
		private static final long serialVersionUID = 1L;
		public long point;
                public Display dis;
                private int cnt;

		public HighScore() {
			//----
		}
                
		public HighScore(ActionListener main, ArrayList keepScore) {
			try {
                            this.setBackground(new Color(241, 98, 69));
                            this.setBounds(0,0,1000,600);
                            this.setFocusable(true);
                            this.setLayout(null);
                            Collections.reverse(keepScore);
                            for(int i=0; i<keepScore.size(); i++){
                                EleLabel showPoint = new EleLabel( "Rank " + (i+1)+" Score : " +keepScore.get(i),30,300,100+cnt,1000,100);
                                showPoint.setForeground(Color.white);
                                this.add(showPoint);
                                cnt+= 50;
                            }
                                
                            
                            EleButton menu = new EleButton("Home",15,380,500,200,50);
                            menu.addActionListener(main);
                            
                            
                            this.add(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}


