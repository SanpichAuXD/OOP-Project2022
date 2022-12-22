package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Element.Element;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Display extends JFrame implements ActionListener, WindowListener {
    private static final long serialVersionUID = 1L;
    private Dimension size = new Dimension(1000, 650);//1
    private JPanel p;
    public JTextField tf;
    private FrGame g;
    private String name = "";
    private FrStart start;
    private FrH2P htp;
    private FrHighScore frscore;
    private Score score;
    private ArrayList<Score> keepScore = new ArrayList<>();
    private Music music=  new Music();
    

    public Display() {
        this.setting();
        start = new FrStart(this);
        this.getContentPane().add(start, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private void setting() {
        this.setTitle("Dev VS Zombies");
        this.setSize(size);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(this);
        this.setLocation(280, 100);
        this.setVisible(true);
        music.playMenuSound();
    }

    public void createpandtf() {
        tf = new JTextField(20);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setBorder(new EmptyBorder(5, 0, 5, 0));
        tf.setFont(Element.getFont(30));
        tf.setForeground(new Color(17, 17, 51));
        p = new JPanel();
        p.setBackground(new Color(17, 17, 51));
        p.setLayout(new FlowLayout());
        p.add(tf);
    }

    private void removeContent() {
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
    }

    public void endGame(int point1) {
        removeContent();
        this.getContentPane().add(new FrGameOver(point1, this));
        score = new Score(name, point1);
        keepScore.add(score);
        music.stopSound();
        this.revalidate();
        this.repaint();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start") || e.getActionCommand().equals("Restart")) {
            removeContent();
            createpandtf();
            name = start.tf_n.getText();
            this.add(p, BorderLayout.SOUTH);
            g = new FrGame();
            tf.getDocument().addDocumentListener(g);
            this.getContentPane().add(g, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            g.requestFocus();
            tf.requestFocusInWindow();
            music.stopSound();
            music.playInGameSound();
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
            music.stopSound();
            music.playMenuSound();
            this.revalidate();
            this.repaint();
            start.requestFocus();
        }
        if (e.getActionCommand().equals("High Score")) {
            removeContent();
            frscore = new FrHighScore(this, keepScore);
            this.getContentPane().add(frscore, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            frscore.requestFocus();
        }
    }

    @Override
    public void windowActivated(WindowEvent arg0) {}
    @Override
    public void windowClosed(WindowEvent arg0) {}
    @Override
    public void windowClosing(WindowEvent arg0) {
        saveFile();
    }
    @Override
    public void windowDeactivated(WindowEvent arg0) {}
    @Override
    public void windowDeiconified(WindowEvent arg0) {}
    @Override
    public void windowIconified(WindowEvent arg0) {}
    @Override
    public void windowOpened(WindowEvent arg0) {
        openFile();
    }

    public void openFile() {
        try ( FileInputStream fin = new FileInputStream("Score.dat");  ObjectInputStream oin = new ObjectInputStream(fin);) {
            ArrayList arr = (ArrayList) oin.readObject();
            this.keepScore = arr;
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveFile() {
        try ( FileOutputStream fout = new FileOutputStream("Score.dat");  ObjectOutputStream oout = new ObjectOutputStream(fout);) {
            ArrayList<Score> arr = keepScore;
            oout.writeObject(arr);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
