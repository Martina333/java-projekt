import java.awt.*;

public class BallGraphics {
    public static final Color GOOD_COLOR = Color.GREEN;
    public static final Color BAD_COLOR = Color.RED;
    private Physics physics;

    public BallGraphics(Physics physics) {
        this.physics = physics;
    }

    public void draw(Ball ball, Graphics g) {
        Rectangle bounds = physics.getBounds(ball);

        g.setColor(Color.BLACK);
        g.fillOval(bounds.x - 1, bounds.y - 1, bounds.width + 2, bounds.height + 2);

        Color color = ball.isGood() ? GOOD_COLOR : BAD_COLOR;
        g.setColor(color);
        g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
    }
}