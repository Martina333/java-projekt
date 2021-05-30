import java.awt.*;

public class PlayerGraphics extends ImageGraphics {

    private Physics physics;

    public PlayerGraphics(Physics physics) {
        super("src/img/player.png");
        this.physics = physics;
    }

    public void draw(Player player, Graphics g) {
        Rectangle bounds = physics.getBounds(player);
        super.paint(g, bounds.x, bounds.y, bounds.width, bounds.height);
    }
}