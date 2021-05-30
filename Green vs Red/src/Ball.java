import java.awt.*;

public class Ball extends GameObject {
	public static final Color GOOD_COLOR = Color.GREEN;
	public static final Color BAD_COLOR = Color.RED;
	public static final int RADIUS = 5;

	private boolean good;
	private int speed;

	public Ball(int x, int y, boolean good, int speed) {
		super(x, y);
		this.good = good;
		this.speed = speed;
	}

	public void moveDown() {
		move(0, this.speed);
	}

	public boolean isGood() {
		return good;
	}
}