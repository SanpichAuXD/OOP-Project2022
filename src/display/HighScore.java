package display;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Element.EleButton;
import Element.EleLabel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HighScore extends JPanel {
		private static final long serialVersionUID = 1L;
		public long point;
                public Display dis;
                private int cnt;
                private String keep = "";
                EleLabel showPoint;
		public HighScore() {
			//----
		}
                
		public HighScore(ActionListener main, ArrayList keepScore) {
			try {
                            this.setBackground(new Color(241, 98, 69));
                            this.setBounds(0,0,1000,600);
                            this.setFocusable(true);
                            this.setLayout(null);
                            Collections.sort(keepScore);
                            Collections.reverse(keepScore);
                            
                            for(int i=0; i<keepScore.size(); i++){
                                showPoint = new EleLabel( "Rank " + (i+1)+" Score : " +keepScore.get(i),30,300,100+cnt,1000,100);
                                showPoint.setForeground(Color.white);
                                showPoint.setText(showPoint.getText()+"\n");
                                this.add(showPoint);
                                keep += "\n" + showPoint.getText();
//                                System.out.println(showPoint);
//                                System.out.println(showPoint.getText());
                                cnt+= 50;
                            }
//                            dis.saveFile(keep);
                            System.out.println(showPoint.getText());
                            System.out.println("555555");
                            System.out.println(keep);
                            EleButton menu = new EleButton("Home",15,380,500,200,50);
                            menu.addActionListener(main);
                            this.add(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
                
                
                
}


