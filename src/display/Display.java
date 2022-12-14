package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Element.Element;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Display extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(1000,700);
        private JPanel p;
        public JTextField tf;
        private Game g;
		
	public Display() {
		this.setting();
               
                                    this.add(p, BorderLayout.SOUTH);
                                    g = new Game();
                                    tf.getDocument().addDocumentListener(g);
                                    System.out.println(g.bank);
		this.getContentPane().add(g,BorderLayout.CENTER);
                
	}
        
	
	private void setting() {
		this.setTitle("Dog ninja");
		this.setSize(size);
                                    this.setLayout(new BorderLayout());
                                    
                                    tf = new JTextField(20);
                                    tf.setBorder(new EmptyBorder(5,0,5,0));
                                    tf.setFont(Element.getFont(30));
                                    p = new JPanel();
                                    p.add(tf);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(280,100);
                                   
		this.setVisible(true);
	}
	
	private void removeContent() {
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
	}
	
	public void endGame(long point) {
		removeContent();
		this.getContentPane().add(new Menu(point,this));
	}
        
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("restart")) {
			removeContent();
			Game game = new Game();
			this.getContentPane().add(game);
			game.requestFocus();
		}
	}
        
}

    
    


