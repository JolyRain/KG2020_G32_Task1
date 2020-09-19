import java.awt.*;
import java.awt.geom.Point2D;

public class SpaceShip {
    private int x;
    private int y;
    private int height;
    private int width;
    private Triangle shipBow;
    private Triangle leftWing;
    private Triangle rightWing;

    public SpaceShip(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shipBow = new Triangle(
                new Point2D.Double(x + (double) width / 2, y),
                new Point2D.Double(x + (double) width / 3, y + (double) width / 3),
                new Point2D.Double(x + (double) width * 2 / 3,y + (double) width / 3));
        this.leftWing = new Triangle(
                new Point2D.Double(x + (double) width / 3, y + (double) height / 2),
                new Point2D.Double(x, y + (double) height * 4 / 5),
                new Point2D.Double(x + (double) width / 3, y + (double) height * 4 / 5));
        this.rightWing = new Triangle(
                new Point2D.Double(x + (double) width * 2 / 3, y + (double) height / 2),
                new Point2D.Double(x + width, y + (double) height * 4 / 5),
                new Point2D.Double(x + (double) width * 2 / 3, y + (double) height * 4 / 5));
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(x + width / 3, y + width / 3, width / 3, height * 3 / 5);
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillOval(x + width / 3, y + width * 2 / 3, width / 3, width / 3);
        graphics2D.setColor(Color.RED);
        graphics2D.fill(shipBow);
        graphics2D.fill(leftWing);
        graphics2D.fill(rightWing);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.fill(
                new Triangle(new Point2D.Double(x + (double) width / 3, y + (double) height * 4 / 5),
                        new Point2D.Double(x + (double) width / 3 , y + height),
                        new Point2D.Double(x + (double) width * 2 / 3, y + (double) height * 4 / 5)));
        graphics2D.fill(
                new Triangle(new Point2D.Double(x + (double) width / 3, y + (double) height * 4 / 5),
                        new Point2D.Double(x + (double) width / 2 , y + height),
                        new Point2D.Double(x + (double) width * 2 / 3, y + (double) height * 4 / 5)));

        graphics2D.fill(
                new Triangle(new Point2D.Double(x + (double) width / 3, y + (double) height * 4 / 5),
                        new Point2D.Double(x + (double) width * 2 / 3 , y + height),
                        new Point2D.Double(x + (double) width * 2 / 3, y + (double) height * 4 / 5)));
    }

}
