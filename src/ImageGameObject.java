import java.awt.Graphics;
import java.awt.Image;

public class ImageGameObject extends GameObject {
	protected Image image;
	
	public ImageGameObject(Image image){
		this.image = image;
	}
	@Override
	public void draw(Graphics g){
		g.drawImage(image, x, y, width, height,null);
	}
	
}
