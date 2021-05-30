import java.awt.*;

public class Physics {

	public Point getLocation(Player player) {
		return new Point(player.getX(), player.getY());
	}

	public Rectangle getBounds(Player player) {
		return new Rectangle(player.getX() - Player.WIDTH / 2, player.getY() - Player.HEIGHT / 2, Player.WIDTH,
				Player.HEIGHT);
	}

	public Rectangle getBounds(Ball ball) {
		return new Rectangle(ball.getX() - Ball.RADIUS, ball.getY() - Ball.RADIUS, Ball.RADIUS * 2, Ball.RADIUS * 2);
	}

	public boolean contains(Player player, Ball ball) {
		return getBounds(player).contains(getBounds(ball));
	}
}