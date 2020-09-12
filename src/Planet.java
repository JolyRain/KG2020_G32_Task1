import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Planet {
    private String name;
    private Color colorPlanet;
    private double radiusRotation;
    private double radiusPlanet;

    Planet(String name, Color colorPlanet, double radiusRotation, double radiusPlanet) {
        this.name = name;
        this.colorPlanet = colorPlanet;
        this.radiusRotation = radiusRotation;
        this.radiusPlanet = radiusPlanet;
    }

    public String getName() {
        return name;
    }

    Color getColorPlanet() {
        return colorPlanet;
    }

    double getRadiusRotation() {
        return radiusRotation;
    }

    double getRadiusPlanet() {
        return radiusPlanet;
    }

    Rectangle2D.Double getRectName(Graphics2D graphics2D, double x, double y) {
        return new Rectangle2D.Double((float) x - radiusPlanet, (float) y,
                graphics2D.getFontMetrics().stringWidth(name), Defaults.LABEL_FONT.getSize());
    }

}
