import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

class DrawPanel extends JPanel {

    private SolarSystem solarSystem;

    DrawPanel() {
        this.solarSystem = new SolarSystem();
    }

    private void paintSpace(Graphics graphics, int width, int height) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, height);
    }

    private void printStars(Graphics2D graphics2D, int width, int height) {
        graphics2D.setColor(Color.WHITE);
        for (int i = 0; i < Defaults.NUMBER_OF_STARS; i++) {
            double x = Math.random() * width;
            double y = Math.random() * height;
            graphics2D.fill(star(x, y));
        }
    }

    @Override
    public void paint(Graphics graphics) {
        int width = Frame.getWIDTH();
        int height = Frame.getHEIGHT();
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics.setColor(Color.BLACK);
        graphics2D.setStroke(Defaults.STROKE);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(rh);
        paintSpace(graphics, width, height);
        printStars(graphics2D, width, height);
        paintSun(graphics2D);
        paintPlanets(graphics2D, solarSystem.getPlanets());
        SpaceShip spaceShip = new SpaceShip(50, 500, 120, 200);
        spaceShip.draw(graphics2D);
        UFO ufo = new UFO(50, 200, 120);
        ufo.draw(graphics2D);
    }


    private void paintPlanet(Graphics2D graphics2D, Planet planet) {
        double randomAngle = Math.random() * Double.MAX_VALUE;
        double x = SolarSystem.getSUN_X() + planet.getRadiusRotation() * Math.cos(randomAngle);
        double y = SolarSystem.getSUN_Y() + planet.getRadiusRotation() * Math.sin(randomAngle);
        int r = planet.getRadiusPlanet();

        graphics2D.setColor(Color.WHITE);
        graphics2D.draw(circle(SolarSystem.getSUN_X(), SolarSystem.getSUN_Y(), planet.getRadiusRotation()));

        graphics2D.drawImage(planet.getTexture(), (int) (x - r), (int) (y - r), this);

        graphics2D.setColor(Color.RED);
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
        graphics2D.drawImage(planet.getTexture(), (int) (x - r), (int) (y - r), this);
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    private Shape star(double x, double y) {
        return new Ellipse2D.Double(x, y, 1, 1);
    }

}
