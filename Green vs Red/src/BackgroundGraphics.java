import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class BackgroundGraphics extends JComponent {
	private BufferedImage image;
	private int width;
	private int height;

	public BackgroundGraphics(int width, int height) {
		this.width = width;
		this.height = height;
		File imageFile = new File("src/img/background.png");
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
			image = null;
		}

		setVisible(true);
	}

	public void paint(Graphics g) {
		if (image != null) {
			g.drawImage(image, 0, 0, width, height, this);
		} else {
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, width, height);
		}
	}
}