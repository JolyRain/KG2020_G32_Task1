import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

class DrawPanel extends JPanel {

    private SolarSystem solarSystem;
    private float[] dist = {0.45f, 0.98f, 1.0f};
    private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW};

    DrawPanel() {
        this.solarSystem = new SolarSystem();
    }

    private void paintSpace(Graphics graphics, int width, int height) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, height);
    }

    private void printStars(Graphics2D graphics2D, int numberOfStars, int width, int height) {
        graphics2D.setColor(Color.WHITE);
        for (int i = 0; i < numberOfStars; i++) {
            double x = Math.random() * width;
            double y = Math.random() * height;
            graphics2D.fill(star(x, y));
        }
    }

    private void paintUFO(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(1f, 1f, 0f, 0.5f));
        graphics2D.fillOval(75, 480, 50, 50);
        graphics2D.setColor(Color.DARK_GRAY);
        graphics2D.fillOval(50, 500, 100, 30);
        graphics2D.setColor(Color.RED);
        graphics2D.drawOval(50, 500, 100, 30);

    }

    @Override
    public void paint(Graphics graphics) {
        int width = Frame.getWIDTH();
        int height = Frame.getHEIGHT();
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics.setColor(Color.BLACK);
        graphics2D.setStroke(Defaults.STROKE);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintSpace(graphics, width, height);
        printStars(graphics2D, Defaults.NUMBER_OF_STARS, width, height);
        paintSun(graphics2D);
        paintPlanets(graphics2D, solarSystem.getPlanets());
        paintUFO(graphics2D);
    }

    private void paintPlanet(Graphics2D graphics2D, Planet planet) {
        double randomAngle = Math.random() * Double.MAX_VALUE;
        double x = SolarSystem.getSUN_X() + planet.getRadiusRotation() * Math.cos(randomAngle);
        double y = SolarSystem.getSUN_Y() + planet.getRadiusRotation() * Math.sin(randomAngle);
        double r = planet.getRadiusPlanet();

        graphics2D.setColor(Color.WHITE);
        graphics2D.draw(circle(SolarSystem.getSUN_X(), SolarSystem.getSUN_Y(), planet.getRadiusRotation()));
        graphics2D.setColor(planet.getColorPlanet());
        graphics2D.fill(circle(x, y, r));

        graphics2D.setColor(Color.WHITE);
        Rectangle2D nameRect = planet.getRectName(graphics2D, x, y);
        graphics2D.drawString(planet.getName(), (float) nameRect.getX(), (float) (nameRect.getY()));
    }

    private void paintPlanets(Graphics2D graphics2D, Planet[] planets) {
        for (Planet planet : planets) {
            paintPlanet(graphics2D, planet);
        }
    }

    private void paintSun(Graphics2D graphics2D) {
        Planet planet = SolarSystem.SUN;
        double x = SolarSystem.getSUN_X();
        double y = SolarSystem.getSUN_Y();
        double r = planet.getRadiusPlanet();
        RadialGradientPaint grad = new RadialGradientPaint((float) x, (float) y, (float) r, dist, colors);
        graphics2D.setPaint(grad);
        graphics2D.fill(circle(x, y, r));
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    private Shape star(double x, double y) {
        return new Ellipse2D.Double(x, y, 1, 1);
    }



}
