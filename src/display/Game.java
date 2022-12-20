package display;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Charactor.*;
import Element.Element;
import event.Event;
import java.awt.geom.RoundRectangle2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Game extends JPanel implements DocumentListener {
    private static final long serialVersionUID = 1L;
    private static int speed = 20, dogSize = 150, waveHeight = 70;
    private static int base = 520, xStart = 1000;
    private int point = 0;
    private boolean correct1, correct2, correct3;
    private double cnt = 0;
    private Image img1, img2, img3,img4,img5,img6,img7,img8 = null;
    private Random rand = new Random();
    private ArrayList<String> bank;
    private Dev dog1 = new Dev(150, base - 100);
    private Dev dog2 = new Dev(150, base - 200);
    private Dev dog3 = new Dev(150, base - 300);
    private Dev dog4 = new Dev(150, base - 400);
    private Dev dog5 = new Dev(150, base - 500);
    private Display display;
    private ArrayList<Wave> waveSet1 = makeWave1(2);
    private ArrayList<Wave> waveSet2 = makeWave2(2);
    private ArrayList<Wave> waveSet3 = makeWave3(2);

    public Game() {
        this.setBounds(0, 0, 1000, 600);
        this.setLayout(null);
        this.setFocusable(true);
         try {
             img1 =  ImageIO.read(new File("img\\zom0.png"));
            img2 =  ImageIO.read(new File("img\\zom1.png"));
             img3 =  ImageIO.read(new File("img\\zom2.png"));
            img4 =  ImageIO.read(new File("img\\zom3.png"));
             img5 =  ImageIO.read(new File("img\\zom4.png"));
            img6 =  ImageIO.read(new File("img\\zom5.png"));
             img7 =  ImageIO.read(new File("img\\zom6.png"));
             img8 =  ImageIO.read(new File("img\\zom7.png"));
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            this.drawBackground(g2);
            //---POINT----
            g2.setFont(Element.getFont(20));
            g2.setColor(new Color(17, 17, 51));
            g2.fillRoundRect(745, 13, 150, 40, 10, 10);
            g2.setColor(Color.white);
            g2.drawString("Point : " + point, 750, 40);
            //--- dog --
            g2.setColor(Color.RED);
            drawDogHealth(g2);
            g2.drawImage(dog1.getImage(), dog1.x, dog1.y, dogSize, dogSize, null);
            g2.drawImage(dog2.getImage(), dog2.x, dog2.y, dogSize, dogSize, null);
            g2.drawImage(dog3.getImage(), dog3.x, dog3.y, dogSize, dogSize, null);
            g2.drawImage(dog4.getImage(), dog4.x, dog4.y, dogSize, dogSize, null);
            g2.drawImage(dog5.getImage(), dog5.x, dog5.y, dogSize, dogSize, null);
            //----Wave----
            for (Wave item : waveSet1) {
                drawWave(item, g2);
            }
            for (Wave item : waveSet2) {
                drawWave(item, g2);
            }
            for (Wave item : waveSet3) {
                drawWave(item, g2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawBackground(Graphics2D g2) throws IOException {
        g2.drawImage(ImageIO.read(new File("img\\bg-game2.png")), 0, 0, 1000, 600, null);
    }

    private void drawDogHealth(Graphics2D g2) {
        try {
            g2.setColor(new Color(17, 17, 51));
            g2.fillRoundRect(5, 10, 255, 40, 10, 10);
            g2.drawImage(ImageIO.read(new File("img\\heart.png")), 10, 20, 20, 20, null);
            g2.setStroke(new BasicStroke(18.0f));
            g2.setColor(new Color(241, 98, 69));
            g2.drawLine(60, 30, 60 + dog1.health, 30);
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(6.0f));
            g2.drawRect(50, 20, 200, 20);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createWave(int set) {
        int n1 = rand.nextInt(1, 29);
        int fars = rand.nextInt(200, 250);
        ArrayList<String> bank1 = createBank(1);
        ArrayList<String> bank2 = createBank(2);
        ArrayList<String> bank3 = createBank(3);
        switch (set) {
            case 1 ->
                waveSet1.add(new Wave(xStart + fars, base, 0, bank1.get(n1), bank1.get(n1).length(), point, this));
            case 2 ->
                waveSet2.add(new Wave(xStart + fars, base - 185, 0, bank2.get(n1), bank2.get(n1).length(), point, this));
            case 3 ->
                waveSet3.add(new Wave(xStart + fars, base - 375, 0, bank3.get(n1), bank3.get(n1).length(), point, this));
        }
    }

    private ArrayList makeWave1(int size) {
        bank = createBank(1);
        ArrayList<Wave> waveSet = new ArrayList<>();
        int far = 100;
        for (int i = 0; i < size; i++) {
            int n1 = rand.nextInt(1, 29);
            waveSet.add(new Wave(xStart + far, base, speed, bank.get(n1), bank.get(n1).length(), point, this));
            far = far + rand.nextInt(200, 300);
        }
        return waveSet;
    }

    private ArrayList makeWave2(int size) {
        bank = createBank(2);
        ArrayList<Wave> waveSet = new ArrayList<>();
        int far = 0;
        for (int i = 0; i < size; i++) {
            int n1 = rand.nextInt(1, 29);
            waveSet.add(new Wave(xStart + far, base - 185, speed, bank.get(n1), bank.get(n1).length(), point, this));
            far = far + rand.nextInt(200, 300);
        }
        return waveSet;
    }

    private ArrayList makeWave3(int size) {
        ArrayList<Wave> waveSet = new ArrayList<>();
        bank = createBank(3);
        int far = 200;
        for (int i = 0; i < size; i++) {
            int n1 = rand.nextInt(1, 29);
            waveSet.add(new Wave(xStart + far, base - 375, speed, bank.get(n1), bank.get(n1).length(), point, this));
            far = far + rand.nextInt(200, 300);
        }
        return waveSet;
    }

    public ArrayList createBank(int i) {

        try {
            bank = GetVo.getWords("vocab" + i + ".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bank;
    }

    private void drawWave(Wave wave, Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics(g2.getFont());
        g2.setColor(new Color(17, 17, 51));
        g2.fillRoundRect((wave.x - 4 + waveHeight / 2) - fm.stringWidth(wave.vord) / 2, (wave.y - waveHeight) - 20, fm.stringWidth(wave.vord) + 8, 24,10,10);
        g2.setColor(Color.white);
        g2.drawString(wave.vord, (wave.x + waveHeight / 2) - fm.stringWidth(wave.vord) / 2, (wave.y - waveHeight));
        g2.drawImage(svap(), wave.x, (wave.y - waveHeight), waveHeight, waveHeight + 10, null);
        if (Event.checkHit(dog1, wave)) {
            g2.setColor(new Color(240, 98, 69));
            g2.setStroke(new BasicStroke(15.0f));
            g2.draw(new RoundRectangle2D.Double(5, 5, 975, 542, 0, 15));
            dog1.health -= 60;
            display.playSoundEffect();
            wave.x += 1500;
            if (dog1.health <= 0) {
                display.endGame(this.point);
                dog1.health = new Dev().health;
                this.point = 0;
                display.playGameOver();
            }
        }
    }

    public boolean check1() {
        java.util.Iterator<Wave> it = waveSet1.iterator();
        while (it.hasNext()) {
            Wave current = it.next();
            if (current.vord.equals(display.tf.getText()) && current.x < 950) {
                it.remove();
                point += current.point * 10;
                correct1 = true;
            }
        }
        return false;
    }

    public boolean check2() {
        java.util.Iterator<Wave> it = waveSet2.iterator();
        while (it.hasNext()) {
            Wave current = it.next();
            if (current.vord.equals(display.tf.getText()) && current.x < 950) {
                it.remove();
                point += current.point * 10;
                correct2 = true;
            }
        }
        return false;
    }

    public boolean check3() {
        java.util.Iterator<Wave> it = waveSet3.iterator();
        while (it.hasNext()) {
            Wave current = it.next();
            if (current.vord.equals(display.tf.getText()) && current.x < 950) {
                it.remove();
                point += current.point * 10;
                correct3 = true;
            }
        }
        return false;
    }

    public void changedUpdate(DocumentEvent e) {
    }

    public void removeUpdate(DocumentEvent e) {
        if (display.tf.getText().equals("") && correct1 == true) {
            display.correctSound();
            createWave(1);
        } else if (display.tf.getText().equals("") && correct2 == true) {
            display.correctSound();
            createWave(2);
        } else if (display.tf.getText().equals("") && correct3 == true) {
            display.correctSound();
            createWave(3);
        }
    }

    public void insertUpdate(DocumentEvent e) {
        check1();
        check2();
        check3();
        empty(correct1, correct2, correct3);
    }

    private void empty(boolean correct1, boolean correct2, boolean correct3) {

        Runnable doempty = new Runnable() {
            @Override
            public void run() {
                if (correct1) {
                    display.tf.setText("");
                    setCorrect1(false);
                } else if (correct2) {
                    display.tf.setText("");
                    setCorrect2(false);
                } else if (correct3) {
                    display.tf.setText("");
                    setCorrect3(false);
                }
            }
        };
        SwingUtilities.invokeLater(doempty);
    }

    public void setCorrect1(boolean c) {
        this.correct1 = c;
    }

    public void setCorrect2(boolean c) {
        this.correct2 = c;
    }

    public void setCorrect3(boolean c) {
        this.correct3 = c;
    }
    public Image svap(){
            Image img = null;
           double num = cnt%7;
            if (num <= 0){
                img = img1;
            }
            else if (num <= 1){
                img = img2;
            }
            else  if (num <= 2){
                img = img3;
            }
            else   if (num <= 3){
                img = img4;
            }
              else  if (num <= 4){
                img = img5;
            }
             else    if (num <= 5){
                img = img6;
            }
            else    if (num <= 6){
                img = img7;
            }
            else    if (num <= 7){
                img = img8;
            }
            cnt+= .05;
            if (img == null){
                System.out.println("null");
                System.out.println(num);
            }
            return img; 
        }
}
