import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CatchComponent extends JComponent implements KeyListener, Runnable {
	private GameEngine engine;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private BackgroundGraphics background;

	public CatchComponent(int width, int height) {
		super();
		engine = new GameEngine(width, height);
		background = new BackgroundGraphics(width, height);
		setPreferredSize(new Dimension(width, height));
		setVisible(true);
	}

	public void start() {
		addKeyListener(this);
		Thread run = new Thread(this);
		run.start();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(50);
			} catch (Exception ex) {
			}

			requestFocus();
			updateState();
			repaint();
		}
	}

	public void paint(Graphics g) {
		background.paint(g);
		engine.draw(g);
	}

	public void updateState() {
		if (leftPressed)
			engine.moveLeft();
		if (rightPressed)
			engine.moveRight();
		engine.update();
	}

	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = true;
		else if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = true;
	}

	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = false;
		else if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = false;
	}

	public void keyTyped(KeyEvent ke) {
	}
}