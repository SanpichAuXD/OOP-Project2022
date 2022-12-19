package display;


import Element.EleButton;
import Element.EleLabel;
import Element.Element;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;//JPanel
import javax.swing.border.EmptyBorder;

public class FrStart extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image img =  null;
    JTextField tf_n ;
    public FrStart(ActionListener main) {
        try {
            this.setBackground(new Color(17, 17, 51));
            this.setBounds(0, 0, 1000, 600);
            this.setFocusable(true);
            this.setLayout(null);
            
            
            
            
            EleLabel nameGame = new EleLabel("Dev VS Zombie", 40, 335, 60, 400, 200);
            nameGame.setForeground(Color.white);

            
            EleButton start = new EleButton("Start", 15, 380, 300, 200, 50);
            start.addActionListener(main);

            EleButton howtoplay = new EleButton("How To Play", 15, 380, 400, 200, 50);
            howtoplay.addActionListener(main);
            
            EleButton highScore = new EleButton("High Score", 15, 380, 470, 200, 50);
            highScore.addActionListener(main);

            tf_n = new JTextField();
            tf_n.setBorder(new EmptyBorder(5, 0, 5, 0));
            tf_n.setFont(Element.getFont(25));
            tf_n.setBounds(325, 225, 300, 30);
            
            
            this.add(nameGame);
            this.add(tf_n);
            
            this.add(start);
            this.add(howtoplay);
            this.add(highScore);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// </editor-fold>  
    public void paintComponent(Graphics g) {
        try {
            
            img = ImageIO.read(new File("img\\bgstart.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrStart.class.getName()).log(Level.SEVERE, null, ex);
        }

          super.paintComponent(g);
          g.drawImage(img, 0, 8, null);
          g.setColor(new Color(17, 17, 51));
          g.fillRoundRect(307, 127, 360, 70, 25, 25);
        
}
    

}