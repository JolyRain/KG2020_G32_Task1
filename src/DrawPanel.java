import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

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
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintSpace(graphics, width, height);
        printStars(graphics2D, width, height);
        paintSun(graphics2D);
        paintPlanets(graphics2D, solarSystem.getPlanets());
        drawUFO(graphics2D, new UFO(50, 100, 100));

    }

//    private BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight) {
//        BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g = scaledImage.createGraphics();
//        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
//        g.dispose();
//        g.setComposite(AlphaComposite.Src);
//        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//        return scaledImage;
//    }

    public void drawUFO(Graphics2D graphics2D, UFO ufo) {
        int x = ufo.getX();
        int y = ufo.getY();
        int width = ufo.getWidth();
        int height = width / 2;
        graphics2D.setColor(Defaults.TOWER_UFO_COLOR);
        graphics2D.fillOval(x + width / 4, y, width / 2, height);
        graphics2D.setColor(Color.DARK_GRAY);
        graphics2D.fillOval(x, y + height / 2, width, height / 2);
//        graphics2D.drawString("НЛО", );
    }

    private void paintPlanet(Graphics2D graphics2D, Planet planet) {
        double randomAngle = Math.random() * Double.MAX_VALUE;
        double x = SolarSystem.getSUN_X() + planet.getRadiusRotation() * Math.cos(randomAngle);
        double y = SolarSystem.getSUN_Y() + planet.getRadiusRotation() * Math.sin(randomAngle);
        int r = planet.getRadiusPlanet();

        graphics2D.setColor(Color.WHITE);
        graphics2D.draw(circle(SolarSystem.getSUN_X(), SolarSystem.getSUN_Y(), planet.getRadiusRotation()));

        graphics2D.drawImage(planet.getTexture(), (int) (x - r), (int) (y - r), this);

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
        graphics2D.drawImage(planet.getTexture(), (int) (x - r), (int) (y - r), this);
//        RadialGradientPaint grad = new RadialGradientPaint((float) x, (float) y, (float) r, dist, colors);
//        graphics2D.setPaint(grad);
//        graphics2D.fill(circle(x, y, r));
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    private Shape star(double x, double y) {
        return new Ellipse2D.Double(x, y, 1, 1);
    }


}
