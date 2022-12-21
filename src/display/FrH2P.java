package display;
import Element.EleButton;
import Element.EleLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrH2P extends JPanel {
    private static final long serialVersionUID = 1L;
    public FrH2P(ActionListener main) {
        try {
            this.setBackground(new Color(17, 17, 51));
            this.setBounds(0, 0, 1000, 600);
            this.setFocusable(true);
            this.setLayout(null);
            EleLabel h2p = new EleLabel("How To Play", 40, 0, 60, 1000, 200);
            h2p.setForeground(Color.white);
            h2p.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            EleLabel howPlay1 = new EleLabel("\"You must type the word on the zombie's head", 18, 0, 180, 1000, 200);
            howPlay1.setForeground(Color.white);
            howPlay1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            EleLabel howPlay2 = new EleLabel("into the text box below correctly", 18, 0, 200, 1000, 200);
            howPlay2.setForeground(Color.white);
            howPlay2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            EleLabel howPlay3 = new EleLabel("before the zombie enters to harm the devs.", 18, 0, 220, 1000, 200);
            howPlay3.setForeground(Color.white);
            howPlay3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            EleLabel howPlay4 = new EleLabel("You can fend off the zombie for a maximum of three times.\"", 18, 0, 240, 1000, 200);
            howPlay4.setForeground(Color.white);
            howPlay4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            EleButton home = new EleButton("Home", 15, 425, 500, 150, 30);
            home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            home.addActionListener(main);
            this.add(h2p);
            this.add(howPlay1);
            this.add(howPlay2);
            this.add(howPlay3);
            this.add(howPlay4);
            this.add(home);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawRoundRect(200, 50, 600, 500, 0, 0);
    }
}
