import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Ball extends ImageGameObject {
	public static final int BALL_WIDTH = 30;
	public static final int BALL_HEIGHT = 30;
	int xSpeed = 3;
	int ySpeed = 3;
	GamePanel gamePanel;

	public Ball(Image image, GamePanel panel) {
		super(image);
		width = BALL_WIDTH;
		height = BALL_HEIGHT;
		x = 130;
		y = 320;
		this.gamePanel = panel;
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}

	public void moveBall() {
		if (x + xSpeed < 0)
			xSpeed = 3;
		if (x + xSpeed > 300 - BALL_WIDTH)
			xSpeed = -3;
		if (y + ySpeed < 0)
			ySpeed = 3;
		/*
		 * if (position.y + ySpeed > 500 - BALL_HEIGHT) ySpeed = -1;
		 */
		if (y + ySpeed > 500 - BALL_HEIGHT)
			gamePanel.gameOver();
		
		if (gamePanel.collision()) {
			ySpeed = -3;
			y = gamePanel.plank.getTopY() - BALL_HEIGHT;
		}
		if /*(gamePanel.collisionBrick() != null)*/ (gamePanel.collisionBrick()) {
			
			ySpeed = 3;
		}

		x = x + xSpeed;
		y = y + ySpeed;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, BALL_WIDTH, BALL_HEIGHT);
	}

}
