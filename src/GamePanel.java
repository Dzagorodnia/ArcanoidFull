import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class GamePanel extends JPanel {
	int width;
	int height;
	List<GameObject> gameObjects;
	Ball ball = new Ball((ImageLoader.Load("ball.png")), this);
	Plank plank = new Plank((ImageLoader.Load("Plank.png")));
	List<Brick> brickList = new ArrayList<Brick>();

	public GamePanel(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.gameObjects = new ArrayList<GameObject>();
		gameObjects.add(ball);
		gameObjects.add(plank);
		GenarateLv1();
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				plank.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				plank.keyPressed(e);
			}
		});
		setFocusable(true);

	}

	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void GenarateLv1() {
		//Point position = new Point(0, 0);
		int x = 0;
		int y = 0;
		for (x = 0; x < 300 - 30; x = x + 40) {
			for (y = 0; y < 60; y = y + 30) {
				// position.y = 0;
				Brick brick = new Brick(ImageLoader.Load("brick.png"));
				brick.x = x;
				brick.y = y;
				gameObjects.add(brick);
				brickList.add(brick);
			}
		}
	}

	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	public void gameWon() {
		JOptionPane.showMessageDialog(this, "YOU WON", "YOU WON!!!!", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public boolean collision() {
		return plank.getBounds().intersects(ball.getBounds());
	}

	/*
	 * public Brick collisionBrick() { Brick impactBrick = null; for (Brick
	 * brick : brickList) { if (ball.getBounds().intersects(brick.getBounds()))
	 * { impactBrick = brick; brickList.remove(brick);
	 * gameObjects.remove(brick); break; } }
	 * 
	 * return impactBrick; }
	 */

	public boolean collisionBrick() {
		boolean isCollision = false;
		for (Brick brick : brickList) {
			if (ball.getBounds().intersects(brick.getBounds())) {
				isCollision = true;
				brickList.remove(brick);
				gameObjects.remove(brick);
				break;
			}
		}
		if (brickList.isEmpty()) {
			this.repaint();
			this.gameWon();
		}
		return isCollision;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.LIGHT_GRAY); // select color
		g.fillRect(0, 0, width, height);
		for (GameObject element : gameObjects) {
			element.draw(g);
		}
	}

}
