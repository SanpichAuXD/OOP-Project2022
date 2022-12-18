package display;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Element.EleButton;
import Element.EleLabel;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.border.EmptyBorder;

public class HighScore_oak extends JPanel {

    private static final long serialVersionUID = 1L;
    public long point;
    public Display dis;
    private int cnt;

    public HighScore_oak() {
        //----
    }

    public HighScore_oak(ActionListener main, ArrayList keepScore) {
        try {
            this.setBackground(new Color(241, 98, 69));
            this.setBounds(0, 0, 1000, 600);
            this.setFocusable(true);
            this.setLayout(null);
            Collections.reverse(keepScore);

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
//                                EleLabel showPoint = new EleLabel("Rank " + (i+1)+" Score : " +keepScore.get(i),30,300,100+cnt,1000,100);
//                                showPoint.setForeground(Color.white);
//                                this.add(showPoint);
                String Rank = "Rank " + (i + 1);
                EleLabel showRank = new EleLabel(Rank, 20, 270 - (Rank.length() * 5), 100 + cnt, 1000, 100);
                showRank.setForeground(Color.white);
                this.add(showRank);
                
                String Name = "Ri";
                EleLabel showName = new EleLabel(Name, 20, 475 - (Name.length() * 5), 100 + cnt, 1000, 100);
                showName.setForeground(Color.white);
                this.add(showName);
                
                String Score ="" + keepScore.get(i) ;
                EleLabel showScore = new EleLabel(Score, 20, 700 - (Score.length() * 5), 100 + cnt, 1000, 100);
                showScore.setForeground(Color.white);
                this.add(showScore);
                cnt += 30;
            }

            EleButton menu = new EleButton("Home", 15, 380, 500, 200, 50);
            menu.addActionListener(main);

            this.add(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
