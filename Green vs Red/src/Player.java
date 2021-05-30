public class Player extends GameObject {
	public static final int WIDTH = 40;
	public static final int HEIGHT = 40;
	public static final int SPEED = 10;

	public Player(int x, int y) {
		super(x, y);
	}

	public void moveTo(int x, int y) {
		move(x - getX(), y - getY());
	}

	public void moveLeft() {
		move(-SPEED, 0);
	}

	public void moveRight() {
		move(SPEED, 0);
	}
}