import java.awt.Graphics;
import java.awt.Point;

public abstract class GameObject {
	//public Point position = new Point(0, 0); // base point for our object
	protected int x = 0; // x position
	protected int y = 0; // y position
	protected int height = 0; // object height
	protected int width = 0; // object width
	

	abstract public void draw(Graphics g);

}
