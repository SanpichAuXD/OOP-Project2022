
package display;

import Element.EleButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
//import javax.swing.JPanel;


public class testStart extends JPanel {
//    private JButton btn;
    public testStart(){
        
    }
    public testStart(ActionListener main){
        try{
            this.setBackground(new Color(200, 98, 69));
            this.setBounds(0,0,1000,600);
            this.setFocusable(true);
            this.setLayout(null);
            
            EleButton restart = new EleButton("restart",15,380,300,200,50);
            restart.addActionListener(main);
            this.add(restart);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new testStart();
    }
}
