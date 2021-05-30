import javax.swing.*;
import java.awt.*;

public class PlayCatch extends JFrame  {
	CatchComponent catchComponent;
	MenuScreenComponent menuComponent;

	public PlayCatch() {
		getContentPane().setLayout(new FlowLayout());
		final int initialWidth = 500;
		final int initialHeight = 500;
		menuComponent = new MenuScreenComponent(this, initialWidth, initialHeight);
		add(menuComponent);
		this.setSize(initialWidth, initialHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		validate();
	}

	public static void main(String[] args) {
		new PlayCatch();
	}

	public void startGame() {
		remove(menuComponent);
		catchComponent = new CatchComponent(getWidth(), getHeight());
		add(catchComponent);
		catchComponent.start();
	}

}