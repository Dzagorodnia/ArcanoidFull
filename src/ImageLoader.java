import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static Image Load(String path) {
		BufferedImage sourceImage = null;

		try {
			URL url = ImageLoader.class.getClassLoader().getResource(path);
			sourceImage = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image myImage = Toolkit.getDefaultToolkit().createImage(sourceImage.getSource());
		return myImage;
	}
}
