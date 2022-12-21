package display;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import Element.EleButton;
import Element.EleLabel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

public class FrHighScore extends JPanel {
    private static final long serialVersionUID = 1L;
    public long point;
    private int cnt;
    EleLabel showPoint_r;
    EleLabel showPoint_n;
    EleLabel showPoint_s;

    public FrHighScore() {}
    public FrHighScore(ActionListener main, ArrayList<Score> keepScore) {
        try {
            this.setBackground(new Color(17, 17, 51));
            this.setBounds(0, 0, 1000, 600);
            this.setFocusable(true);
            this.setLayout(null);
            Collections.sort(keepScore);
            EleLabel title = new EleLabel("Hall of Frame", 30, 380, 0, 1000, 100);
            title.setForeground(Color.white);
            this.add(title);
            EleLabel headerRank = new EleLabel("Ranking", 20, 200, 70, 200, 100);
            headerRank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            headerRank.setForeground(Color.white);
            this.add(headerRank);
            EleLabel headerName = new EleLabel("Name", 20, 400, 70, 200, 100);
            headerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            headerName.setForeground(Color.white);
            this.add(headerName);
            EleLabel headerScore = new EleLabel("Score", 20, 600, 70, 200, 100);
            headerScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            headerScore.setForeground(Color.white);
            this.add(headerScore);
            EleButton home = new EleButton("Home", 15, 425, 525, 150, 30);
            home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            home.addActionListener(main);
            this.add(home);
            for (int i = 0; i < 7; i++) {
                if (!keepScore.isEmpty() && keepScore.size() > i) {
                    showPoint_r = new EleLabel("" + (i + 1), 20, 200, 125 + cnt, 200, 100);
                    showPoint_r.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    showPoint_r.setForeground(Color.white);
                    this.add(showPoint_r);
                }
                showPoint_n = new EleLabel(keepScore.get(i).getName(), 20, 400, 125 + cnt, 200, 100);
                showPoint_n.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                showPoint_n.setForeground(Color.white);
                this.add(showPoint_n);

                showPoint_s = new EleLabel(keepScore.get(i).getPoint() + "", 20, 600, 125 + cnt, 200, 100);
                showPoint_s.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                showPoint_s.setForeground(Color.white);
                this.add(showPoint_s);
                cnt += 50;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawLine(200, 150, 800, 150);
        g.drawRoundRect(200, 90, 600, 420, 0, 0);
    }

}
