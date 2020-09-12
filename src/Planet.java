import java.awt.*;

public class Planet {
    private String name;
    private Color colorPlanet;
    private double radiusRotation;
    private double radiusPlanet;
    private double x;
    private double y;

    Planet() {
    }

    Planet(String name, Color colorPlanet, double radiusRotation, double radiusPlanet, double x, double y) {
        this.name = name;
        this.colorPlanet = colorPlanet;
        this.radiusRotation = radiusRotation;
        this.radiusPlanet = radiusPlanet;
        this.x = x;
        this.y = y;
    }

    Planet(String name, Color colorPlanet, double radiusRotation, double radiusPlanet) {
        this.name = name;
        this.colorPlanet = colorPlanet;
        this.radiusRotation = radiusRotation;
        this.radiusPlanet = radiusPlanet;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
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

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }
}
