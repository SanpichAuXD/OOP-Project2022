package display;

import Element.EleLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Element.Element;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Display extends JFrame implements ActionListener, WindowListener {

    private static final long serialVersionUID = 1L;
    private Dimension size = new Dimension(1000, 600);
    private JPanel p;
    public JTextField tf;
    private Game g;
    private FrStart start;
    private FrH2P htp;
    private HighScore score;
    private HighScore HS;
    private long point;
    private ArrayList<Long> keepScore = new ArrayList<>();
    private Clip clip;
    private Clip clip2;
    private AudioInputStream audioInput;
    private AudioInputStream audioInput2;

    public Display() {
        this.setting();
        start = new FrStart(this);             
        this.getContentPane().add(start, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
        this.addWindowListener(this);
    }

    private void setting() {
        this.setTitle("Dog ninja");
        this.setSize(size);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(280, 100);
        this.setVisible(true);
        playMenuSound();
    }

    public void Createpandtf() {
        tf = new JTextField(20);
        tf.setBorder(new EmptyBorder(5, 0, 5, 0));
        tf.setFont(Element.getFont(30));
        p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(tf);
    }

    private void removeContent() {
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
    }

    public void endGame(long point1) {
        removeContent();
        this.getContentPane().add(new Menu(point1, this));
        System.out.println();
        keepScore.add(point1);
        this.revalidate();
        this.repaint();
    }
    
    public void playInGameSound() {
        try {
            audioInput = AudioSystem.getAudioInputStream(new File("sound\\InGameSound.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            playSound();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void playMenuSound() {
        try {
            audioInput = AudioSystem.getAudioInputStream(new File("sound\\MenuSound.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            playSound();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void playSoundEffect(){
        try {
            audioInput2 = AudioSystem.getAudioInputStream(new File("sound\\Ugh.wav"));
            clip2 = AudioSystem.getClip();
            clip2.open(audioInput2);
            clip2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void playSound(){
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopSound(){
        clip.stop();
    }
    
    public void openFile(EleLabel showPoint){
        try(FileInputStream fin = new FileInputStream("Score.dat");
                        DataInputStream din = new DataInputStream(fin);) {
                        String str = din.readUTF(din);
                        showPoint.setText(str);
                        System.out.println("open");
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
    }

    public void saveFile(String keep){
        try(FileOutputStream fout = new FileOutputStream("Score.dat");
                      DataOutputStream dout = new DataOutputStream(fout);) {
                      String str = keep;
                       dout.writeUTF(str);
                        System.out.println("close");
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        if (e.getActionCommand().equals("Start") || e.getActionCommand().equals("Restart")) {
            removeContent();
            Createpandtf();
            this.add(p, BorderLayout.SOUTH);
            g = new Game();
            tf.getDocument().addDocumentListener(g);
            this.getContentPane().add(g, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            g.requestFocus();
            tf.requestFocusInWindow();
            stopSound();
            playInGameSound();
        }
        if (e.getActionCommand().equals("How To Play")) {
            removeContent();
            htp = new FrH2P(this);
            this.getContentPane().add(htp, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            htp.requestFocus();
        }
        if (e.getActionCommand().equals("Home")) {
            removeContent();
            start = new FrStart(this);              
            this.getContentPane().add(start, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            stopSound();
            playMenuSound();
            start.requestFocus();
        }
        if (e.getActionCommand().equals("High Score")) {
            removeContent();
            score = new HighScore(this,keepScore);
            this.getContentPane().add(score, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            score.requestFocus();
        }
    }
    
                public void windowActivated(WindowEvent arg0) {}
                public void windowClosed(WindowEvent arg0) {}
                public void windowClosing(WindowEvent arg0) {
//                    saveFile();
                } 
                public void windowDeactivated(WindowEvent arg0) {}
                public void windowDeiconified(WindowEvent arg0) {}
                public void windowIconified(WindowEvent arg0) {}
                public void windowOpened(WindowEvent arg0) {
//                    openFile();
                }

}
