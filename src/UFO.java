import java.awt.*;

public class UFO {
    private int x;
    private int y;
    private int width;

    public UFO(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void draw(Graphics2D graphics2D) {
        int height = width / 2;
        graphics2D.setColor(Defaults.TOWER_UFO_COLOR);
        graphics2D.fillOval(x + width / 4, y, width / 2, height);
        graphics2D.setColor(Color.DARK_GRAY);
        graphics2D.fillOval(x, y + height / 2, width, height / 2);
    }


}
