import java.awt.*;
import java.util.*;

public class GameEngine {
	public static final int MIN_BALL_DELAY = 30;
	public static final int MAX_BALL_DELAY = 100;
	public static final int SPEED_UP_DELAY = 20;

	public static final int MIN_BALL_SPEED = 2;
	public static final int MAX_BALL_SPEED = 10;
	public static final int BAD_BALL_CHANCE_PERCENT = 50;

	private Vector<Ball> balls;
	private Player player;
	private int points = 0;
	private int lives = 5;
	private int speedDelay = 0;
	private int addBallDelay = MAX_BALL_DELAY;
	private int ballDelay = 0;

	private final Physics physics;
	private final BallGraphics ballGraphics;
	private final PlayerGraphics playerGraphics;
	private final BallFactory ballFactory;
	private int height;
	private int width;

	public GameEngine(int width, int height) {
		this.width = width;
		this.height = height;
		balls = new Vector<Ball>();
		player = new Player(50, (int)(height * 0.8));
		physics = new Physics();
		ballFactory = new BallFactory(MIN_BALL_SPEED, MAX_BALL_SPEED, BAD_BALL_CHANCE_PERCENT);
		ballGraphics = new BallGraphics(physics);
		playerGraphics = new PlayerGraphics(physics);
	}

	public void moveLeft() {
		if (!isGameOver()) {
			player.moveLeft();
			if (player.getX() < -Player.WIDTH / 2)
				player.moveTo(width + Player.WIDTH / 2, (int) player.getY());
		}
	}

	public void moveRight() {
		if (!isGameOver()) {
			player.moveRight();
			if (player.getX() > width + Player.WIDTH / 2)
				player.moveTo(-Player.WIDTH / 2, (int) player.getY());
		}
	}

	private boolean isGameOver() {
		return lives <= 0;
	}

	private void addBall() {
		Ball ball = this.ballFactory.create(this.width);
		balls.add(ball);
	}

	private void moveBalls() {
		for (Ball ball : balls) {
			ball.moveDown();
		}
	}

	public void testBallCatch() {
		for (int i = 0; i < balls.size(); i++) {
			if (physics.contains(player, balls.get(i))) {
				if (balls.get(i).isGood()){
					points++;
					ballFactory.increaseDifficulty();
				}
				else
					lives--;
				balls.remove(i);
				i--;
			} else if (balls.get(i).getY() >= height + Ball.RADIUS) {
				if (balls.get(i).isGood())
					lives--;
				balls.remove(i);
				i--;
			}
		}
	}

	public void update() {
		if (!isGameOver()) {
			ballDelay++;
			speedDelay++;
			if (ballDelay >= addBallDelay) {
				ballDelay = 0;
				addBall();
			}
			if (speedDelay >= SPEED_UP_DELAY) {
				speedDelay = 0;
				addBallDelay--;
				if (addBallDelay < MIN_BALL_DELAY)
					addBallDelay = MIN_BALL_DELAY;
			}
			moveBalls();
			testBallCatch();
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Points: " + points, 10, 20);
		g.drawString("Lives: " + lives, 10, 30);
		if (isGameOver()) {
			g.setColor(Color.RED);
			g.drawString("You Lose", width / 2 - 20, height / 2);
		}

		for (Ball ball : balls) {
			ballGraphics.draw(ball, g);
		}

		playerGraphics.draw(player, g);
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
}