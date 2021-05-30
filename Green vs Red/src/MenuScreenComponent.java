import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;

public class MenuScreenComponent extends JPanel implements MouseListener {

	private JButton startButton;
	private JButton helpButton;
	private JButton helpBackButton;
	private PlayCatch playCatch;
	private BackgroundGraphics background;
	private boolean displayHelp = false;

	public MenuScreenComponent(PlayCatch playCatch, int width, int height) {
		super();
		this.setLayout(null);
		this.playCatch = playCatch;
		setPreferredSize(new Dimension(width, height));
		background = new BackgroundGraphics(width, height);

		startButton = new JButton("Start");
		startButton.addMouseListener(this);
		startButton.setBounds(100, 200, 300, 20);
		startButton.setVisible(true);
		add(startButton);

		helpButton = new JButton("Help");
		helpButton.addMouseListener(this);
		helpButton.setBounds(100, 250, 300, 20);
		helpButton.setVisible(true);
		add(helpButton);

		helpBackButton = new JButton("Back");
		helpBackButton.addMouseListener(this);
		helpBackButton.setBounds(100, 300, 300, 20);
		helpBackButton.setVisible(false);
		add(helpBackButton);

		setVisible(true);
		revalidate();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		background.paint(g);
		g.setColor(Color.BLACK);
		if (displayHelp) {
			g.drawString("Catch the green balls to score points.", 130, 250);
			g.drawString("Missing the green ball, or catching the red ball ", 120, 270);
			g.drawString("reduces your lives.", 180, 290);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Component clickedComponent = e.getComponent();
		if (clickedComponent == startButton) {
			setVisible(false);
			playCatch.startGame();
		}

		if (clickedComponent == helpButton) {
			startButton.setVisible(false);
			helpButton.setVisible(false);
			helpBackButton.setVisible(true);
			displayHelp = true;
		}

		if (clickedComponent == helpBackButton) {
			startButton.setVisible(true);
			helpButton.setVisible(true);
			helpBackButton.setVisible(false);
			displayHelp = false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}