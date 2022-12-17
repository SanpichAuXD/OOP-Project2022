package display;

import Element.EleButton;
import Element.EleLabel;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;//JPanel


public class FrH2P extends JPanel{
       private static final long serialVersionUID = 1L;
       private Image image;

    public FrH2P(ActionListener main) {
         try {
         this.setBackground(new Color(17, 17, 51));        
         this.setBounds(0,0,1000,600);
         this.setFocusable(true);
         this.setLayout(null);
         
          
          EleLabel nameGame = new EleLabel("Dev VS Zombs",40,450,60,300,200);
          nameGame.setForeground(Color.white);
          
          EleLabel howPlay1 = new EleLabel("\"you must type the word on the zombie’s head",20,100,200,800,200);
          howPlay1.setForeground(Color.white);
          howPlay1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          EleLabel howPlay2 = new EleLabel("in the text box below correctly",20,100,220,800,200);
          howPlay2.setForeground(Color.white);
          howPlay2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          EleLabel howPlay3 = new EleLabel("before the zombie enters the devs’ territory.\"",20,100,240,800,200);
          howPlay3.setForeground(Color.white);          
          howPlay3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

          EleButton home = new EleButton("Home",15,380,500,150,30);
          home.addActionListener(main);
          
                            
         this.add(nameGame);
         this.add(howPlay1);        
         this.add(howPlay2);        
         this.add(howPlay3);
         this.add(home);
         } catch (Exception e){
             e.printStackTrace();
         }
        
    }// </editor-fold> 
}