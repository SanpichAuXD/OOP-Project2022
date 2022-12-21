package Charactor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Wave implements Moveable{

    public int speed;
    public int x;
    public int y;
    public int num = 0;
    public int point;
    public String vord;
    Timer timeMove;
    public int upSpeed = 3;
    public int upPoint;

    public Wave(int x, int y, int speed, String vord, int point, int c_point, JPanel page) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.vord = vord;
        this.point = point;
        this.move(page, c_point);
    }

    @Override
    public void move(JPanel page, int c_point) {
        this.timeMove = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (c_point >= 300 + upPoint) {
                    upPoint += 300;
                    upSpeed += 3;
                    x -= (10 + upSpeed);
                } else {
                    x -= (10 + upSpeed);
                }
                page.repaint();
            }
        });
        this.timeMove.start();

    }

}
