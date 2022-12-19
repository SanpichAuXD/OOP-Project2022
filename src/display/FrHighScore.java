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
import javax.swing.JTextArea;

public class FrHighScore extends JPanel {

    private static final long serialVersionUID = 1L;
    public long point;

    private int cnt;
    private String keep;
    EleLabel showPoint;

    public FrHighScore() {
        //----
    }

    public FrHighScore(ActionListener main, ArrayList<Score> keepScore) {
        try {
            this.setBackground(new Color(241, 98, 69));
            this.setBounds(0, 0, 1000, 600);
            this.setFocusable(true);
            this.setLayout(null);
          
            Collections.sort(keepScore);
            System.out.println("Have" + keepScore.size());

            EleLabel title = new EleLabel("Hall of Frame", 30, 380, 0, 1000, 100);
            title.setForeground(Color.white);
            this.add(title);

            EleLabel headerRank = new EleLabel("Ranking", 22, 230, 50, 1000, 100);
            headerRank.setForeground(Color.white);
            this.add(headerRank);

            EleLabel headerName = new EleLabel("Name", 22, 450, 50, 1000, 100);
            headerName.setForeground(Color.white);
            this.add(headerName);

            EleLabel headerScore = new EleLabel("Score", 22, 670, 50, 1000, 100);
            headerScore.setForeground(Color.white);
            this.add(headerScore);

            for (int i = 0; i < keepScore.size(); i++) {
                System.out.println("create");
                showPoint = new EleLabel("Rank " + (i + 1) + keepScore.get(i).getName() + " Score : " + keepScore.get(i).getPoint(), 30, 300, 100 + cnt, 1000, 100);

                showPoint.setForeground(Color.white);
                this.add(showPoint);
                keep += "\n" + showPoint.getText();
                cnt += 50;
            }

            EleButton menu = new EleButton("Home", 15, 380, 500, 200, 50);
            menu.addActionListener(main);
            this.add(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getKeep() {
        return keep;
    }

}
