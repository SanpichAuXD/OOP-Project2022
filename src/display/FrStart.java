/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package display;

/**
 *
 * @author user
 */
import Element.EleButton;
import Element.EleLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;//JPanel

public class FrStart extends JPanel {
    
    private static final long serialVersionUID = 1L;

    public FrStart(ActionListener main) {
        try {           
            this.setBackground(new Color(17, 17, 51));
            this.setBounds(0, 0, 1000, 600);
            this.setFocusable(true);
            this.setLayout(null);
           
            EleLabel nameGame = new EleLabel("Dev VS Zombs", 40, 350, 100, 300, 200);
            nameGame.setForeground(Color.white);

            EleButton start = new EleButton("Start", 15, 380, 300, 200, 50);
            start.addActionListener(main);

            EleButton howtoplay = new EleButton("How To Play", 15, 380, 400, 200, 50);
            howtoplay.addActionListener(main);

            this.add(nameGame);
            this.add(start);
            this.add(howtoplay);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// </editor-fold>  

    

}
