package Models;

import Utils.Defaults;

import java.awt.*;
import java.awt.geom.Arc2D;

public class UFO {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public UFO(int x, int y, int width, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = width / 2;
        this.color = color;
    }

    public void draw(Graphics2D graphics2D) {
        drawTower(graphics2D);
        drawBody(graphics2D);
    }

    private void drawBody(Graphics2D graphics2D) {
        graphics2D.setColor(color);
        graphics2D.fillOval(x, y + height / 2, width, height / 2);
    }

    private void drawTower(Graphics2D graphics2D) {
        graphics2D.setColor(Defaults.TOWER_UFO_COLOR);
        graphics2D.fill(tower());
    }

    private Shape tower() {
        return new Arc2D.Double(x + (double) width / 4, y + (double) height / 5,
                (double) width / 2, height, 0, 180, Arc2D.OPEN);
    }
}
