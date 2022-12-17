package Charactor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Wave {

    Random rand = new Random();
    public int speed;
    public int x;
    public int y;
    public double num = 0;
    public String vord;
    Timer timeMove;

    public Wave(int x, int y, int speed,String vord, JPanel page) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.vord = vord; 
        this.move(page);
    }

    public void move(JPanel page) {
        this.timeMove = new Timer(speed, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x -= 10;
                page.repaint();
                
            }
        });
        this.timeMove.start();
               
    }

   public BufferedImage getImage() {
        BufferedImage image = null;
        String path;
        if (this.x < 1000){
         path = svapImage();
        }
        else{
             path = "img\\tree.png";
        }
        try {
            image = ImageIO.read(new File(path));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public String svapImage() {

        String path = "img\\heart.png";
//        if (num%2 == 0){
//            path = "img\\zom1.png";
//        }
//        num += 1;
//        System.out.println(num);
        return path;
    }
}
