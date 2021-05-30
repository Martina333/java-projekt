import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public abstract class ImageGraphics extends JComponent {
	private BufferedImage image;

	public ImageGraphics(String filePath) {
		super();
		File imageFile = new File(filePath);
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
			image = null;
		}

		setVisible(true);
	}

	public void paint(Graphics g, int x, int y, int width, int height) {
		if (image != null) {
			g.drawImage(image, x, y, width, height, this);
		} else {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
		}
	}
}