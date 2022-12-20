package Charactor;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Dev{
	public int x;
	public int y;
	public int health=180;
	public Dev() {}
	public Dev(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("img\\dev.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}
