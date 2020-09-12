
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

class PaintPlanet extends JPanel {

    private SolarSystem solarSystem;

    PaintPlanet(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    private void paintSpace(Graphics graphics, int width, int height) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, height);
    }

    private void printStars(Graphics2D graphics2D, int numberOfStars, int width, int height) {
        graphics2D.setColor(Color.WHITE);
        for (int i = 0; i < numberOfStars; i++) {
            graphics2D.fill(star(Math.abs((Math.random() * width - 1)), Math.abs((Math.random() * height - 1))));
        }
    }

    public void paint(Graphics graphics) {
        int width = Manager.getWIDTH();
        int height = Manager.getHEIGHT();
        Graphics2D graphics2D = (Graphics2D) graphics;
        paintSpace(graphics, width, height);
        printStars(graphics2D, 1000, width, height);


        graphics.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(1));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Planet[] planets = solarSystem.getPlanetList();
        int n = 9;
        double alpha = 2 * Math.PI / n;
        for (int i = 0; i <= n; i++ ) {

            Planet planet = planets[i];
            if (planet == null) break;
            double x = SolarSystem.getSUN_X() + planet.getRadiusRotation() * Math.cos(alpha * i);
            double y = SolarSystem.getSUN_Y() + planet.getRadiusRotation() * Math.sin((alpha * i));
            double r = planet.getRadiusPlanet();

            if (planet.getName().equals("Sun")) {
                RadialGradientPaint grad = new RadialGradientPaint((float) x, (float) y, (float) r, dist, colors);
                graphics2D.setPaint(grad);
                graphics2D.fill(circle(x, y, r));
                continue;
            }

            graphics.setColor(Color.WHITE);
            graphics2D.draw(circle(SolarSystem.getSUN_X(), SolarSystem.getSUN_Y(), planet.getRadiusRotation()));
            graphics2D.setColor(planet.getColorPlanet());
            graphics2D.fill(circle(x, y, r));
        }
    }



    private void paintPlanet(Graphics2D graphics2D) {

    }

    private float[] dist = {0.45f, 0.98f, 1.0f};
    private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW};


    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    private Shape star(double x, double y) {
        return new Ellipse2D.Double(x, y, 1, 1);
    }


}
