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

public class Game extends JPanel implements  DocumentListener {

    private static final long serialVersionUID = 1L;

    private static int speed = 350, dogSize =60, waveHeight = 50;
    private static int base = 400, xStart = 1000;
    private long point = 0;
    private boolean correct1, correct2, correct3;
    private Random rand = new Random();
    public ArrayList<String> bank;

    private Dog dog = new Dog(0, base - 50);
    static Display display;
    static Wave wave;

//	------------------Wave SIze ----------------------------
    private ArrayList<Wave> waveSet1 = makeWave1(2);
    private ArrayList<Wave> waveSet2 = makeWave2(2);
    private ArrayList<Wave> waveSet3 = makeWave3(2);
//--------------------Cloud--------------------------------
    private Environment[] envSet = makeEnv(2, Environment.CLOUD);
    private Environment building = new Environment(xStart - 100, base - 150, this, Environment.BUILDING, 4);

    public Game() {
        this.setBounds(0, 0, 1000, 600);
//        this.setLayout(null);
        this.setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            this.drawBackground(g2);
            //---POINT----
            g2.setFont(Element.getFont(20));
            g2.setColor(Color.white);
            g2.drawString("Point : " + point, 750, 40);
            //--- dog --
            g2.setColor(Color.RED);
            drawDogHealth(g2);
            g2.drawImage(dog.getImage(), dog.x, dog.y, dogSize, dogSize, null);
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
        g2.drawImage(ImageIO.read(new File("img\\sky.png")), 0, 0, 2000, 1000, null);
        g2.drawImage(building.getImage(), building.x, building.y, 500, 200, null);
        g2.drawImage(ImageIO.read(new File("img\\dir.png")), 0, base + 10, 2000, 220, null);
        for (Environment item : envSet) {
            g2.drawImage(item.getImage(), item.x, item.y, 250, 160, null);
        }
    }

    private void drawDogHealth(Graphics2D g2) {
        try {
            g2.drawImage(ImageIO.read(new File("img\\heart.png")), 10, 20, 20, 20, null);
            g2.setStroke(new BasicStroke(18.0f));
            g2.setColor(new Color(241, 98, 69));
            g2.drawLine(60, 30, 60 + dog.health, 30);
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(6.0f));
            g2.drawRect(50, 20, 200, 20);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void createWave(int set){
         int n1 = rand.nextInt(1, 29);
         int fars = rand.nextInt(200, 250);
         switch (set) {
            case 1 -> waveSet1.add(new Wave(xStart + fars  ,  base - 150, speed, bank.get(n1), this));
            case 2 -> waveSet2.add(new Wave(xStart + fars ,  base - 150, speed, bank.get(n1), this));
            case 3 -> waveSet3.add(new Wave(xStart + fars , base - 300, speed, bank.get(n1), this));
          }
    }

    private ArrayList makeWave1(int size) {
        bank = createBank(1);
        ArrayList<Wave> waveSet = new ArrayList<Wave>();
        int far = 100;
        for (int i = 0; i < size; i++) {
            int n1 = rand.nextInt(1, 29);
            waveSet.add(new Wave(xStart + far , base, speed, bank.get(n1), this));
            far = far + rand.nextInt(200,300);
        }
        return waveSet;
    }

    private ArrayList makeWave2(int size) {
        bank = createBank(2);
        ArrayList<Wave> waveSet = new ArrayList<Wave>();
        int far = 0;
        for (int i = 0; i < size; i++) {
            int n1 = rand.nextInt(1, 29);
            waveSet.add(new Wave(xStart + far, base - 150, speed, bank.get(n1), this));
            far = far + rand.nextInt(200,300);
        }
        return waveSet;
    }
    
    private ArrayList makeWave3(int size) {
        ArrayList<Wave> waveSet = new ArrayList<Wave>();
        bank = createBank(3);
        int far = 200;
        for (int i = 0; i < size; i++) {
            int n1 = rand.nextInt(1, 29);
            waveSet.add(new Wave(xStart + far, base - 300, speed, bank.get(n1), this));
            far = far + rand.nextInt(200,300);
        }
        return waveSet;
    }

    private Environment[] makeEnv(int size, int eType) {
        Environment[] envSet = new Environment[size];
        int far = 0;
        for (int i = 0; i < size; i++) {
            envSet[i] = new Environment(xStart + far, 20, this, eType, 10);
            far += 600;
        }
        return envSet;
    }

    public ArrayList createBank(int i) {

        try {
            bank = GetVo.getWords("cum"+ i +".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bank;
    }

    private void drawWave(Wave wave, Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics(g2.getFont());
        g2.drawString(wave.vord, wave.x + 25 - fm.stringWidth(wave.vord) /2, (wave.y - waveHeight));
        g2.drawImage(wave.getImage(), wave.x, (wave.y - waveHeight), 50, waveHeight + 10, null);
        if (Event.checkHit(dog, wave)) {
            g2.setColor(new Color(240, 98, 69));
//            System.out.println("hit");
            g2.setStroke(new BasicStroke(10.0f));
            g2.draw(new RoundRectangle2D.Double(5, 5, 977, 555, 0, 10));
            dog.health -= 60;
            wave.x += 10000;
            if (dog.health <= 0) {
                display.endGame(this.point);
                dog.health = new Dog().health;
                this.point = 0;
            }
        }
    }
    public boolean check1(){
            java.util.Iterator<Wave> it = waveSet1.iterator();
        while(it.hasNext()) {
            Wave current = it.next();
            if(current.vord.equals(display.tf.getText()) && current.x < 950) {
                            it.remove();
                            System.out.println("Correct");
                           correct1 = true;
            }
        }
                return false;
        }
    public boolean check2(){
            java.util.Iterator<Wave> it = waveSet2.iterator();
        while(it.hasNext()) {
            Wave current = it.next();
            if(current.vord.equals(display.tf.getText()) && current.x < 950) {
                            it.remove();
                            System.out.println("Correct");
                            correct2 = true;
            }
        }
                return false;
        }
    public boolean check3(){
            java.util.Iterator<Wave> it = waveSet3.iterator();
        while(it.hasNext()) {
            Wave current = it.next();
            if(current.vord.equals(display.tf.getText()) && current.x < 950) {
                            it.remove();
                           correct3 = true;
                            System.out.println("Correct");
            }
            
        }
                return false;
        }
    
        public void changedUpdate(DocumentEvent e) {
        }
        public void removeUpdate(DocumentEvent e) {
            if(display.tf.getText().equals("") && correct1 == true){
                this.point += 10;
                createWave(1);
            }else if(display.tf.getText().equals("") && correct2 == true){
                this.point += 10;
                createWave(2);
            }else if(display.tf.getText().equals("") && correct3 == true){
                this.point += 10;
                createWave(3);
            }
        }
        
        public void insertUpdate(DocumentEvent e) {
            check1();
            check2();
            check3();
            empty(correct1, correct2, correct3);
            
            
        }
        private void  empty(boolean correct1, boolean correct2, boolean correct3) {

    Runnable doempty = new Runnable() {
        @Override
        public void run() {
            // your highlight code
            if (correct1){
                display.tf.setText("");
                setCorrect1(false);
            }else if(correct2){
                display.tf.setText("");
                setCorrect2(false);
            }else if(correct3){
                display.tf.setText("");
                setCorrect3(false);
            }
        }
    };
    SwingUtilities.invokeLater(doempty);
}
       public void setCorrect1(boolean c){
           this.correct1 = c;
       }
       public void setCorrect2(boolean c){
           this.correct2 = c;
       }
       public void setCorrect3(boolean c){
           this.correct3 = c;
       }
    

    public static void main(String[] arg) {
        display = new Display();
        
         
    }


}
