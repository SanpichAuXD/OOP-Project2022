package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Element.Element;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Display extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private Dimension size = new Dimension(1000, 600);
    private JPanel p;
    public JTextField tf;
    private Game g;
    private FrStart start;
    private FrH2P htp;

    public Display() {
        this.setting();
        start = new FrStart(this);                   
        this.getContentPane().add(start, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private void setting() {
        this.setTitle("Dog ninja");
        this.setSize(size);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(280, 100);
        this.setVisible(true);
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

    public void endGame(long point) {
        removeContent();
        this.getContentPane().add(new Menu(point, this));
        this.revalidate();
        this.repaint();
    }
    public void highScore(long point1){
        removeContent();
        this.getContentPane().add(new HighScore(point1, this));
        this.revalidate();
        this.repaint();
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
            start.requestFocus();
        }
    }

}
