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
		Timer timeMove;
		public Wave(int x,int y,int speed,JPanel page) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.move(page);
		}
                
		
		public void move(JPanel page) {
				 this.timeMove = new Timer(speed,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							x -= 15;
							page.repaint();
					}
				});
				 this.timeMove.start();
		}
		
		public BufferedImage getImage() {
			BufferedImage image = null;
			try {
				 image = ImageIO.read(new File("img\\tree.png"));
				 return image;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return image;
		}
}