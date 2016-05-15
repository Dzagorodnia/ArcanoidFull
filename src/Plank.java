import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Plank extends ImageGameObject {
	public static final int PLANK_WIDTH = 100;
	public static final int PLANK_HEIGHT = 20;
	int speedX = 0;
	
	public Plank(Image image) {
		super(image);
		width = PLANK_WIDTH;
		height = PLANK_HEIGHT;
		x = 100;
		y = 400;
	}
	
	public Plank getPlank(){
		return this;
	}
	
	public void movePlank() {
		if (x + speedX > 0 && x + speedX < 300-PLANK_WIDTH)
			x = x + speedX;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, PLANK_WIDTH, PLANK_HEIGHT);
	}
	
	public int getTopY() {
		return y;
	}
	
	public void keyReleased(KeyEvent e) {
		speedX = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			speedX = -3;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			speedX = 3;
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}
}
