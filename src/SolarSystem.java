import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class SolarSystem {

    static final Planet SUN = new Planet("Sun", 0, 30);
    private static final double SUN_X = 0.5 * Frame.getWIDTH();
    private static final double SUN_Y = 0.5 * Frame.getHEIGHT();
    private static final Planet MERCURY = new Planet("Mercury", 40, 7);
    private static final Planet VENUS = new Planet("Venus", 60, 10);
    private static final Planet EARTH = new Planet("Earth", 85, 15);
    private static final Planet MARS = new Planet("Mars", 110, 15);
    private static final Planet JUPITER = new Planet("Jupiter", 205, 25);
    private static final Planet SATURN = new Planet("Saturn", 255, 25);
    private static final Planet URANUS = new Planet("Uranus", 305, 15);
    private static final Planet NEPTUNE = new Planet("Neptune", 355, 15);
    private static final Planet PLUTO = new Planet("Pluto", 500, 5);

    private Planet[] planets;

    SolarSystem() {
        this.planets = new Planet[9];
        planets[0] = MERCURY;
        planets[1] = VENUS;
        planets[2] = EARTH;
        planets[3] = MARS;
        planets[4] = JUPITER;
        planets[5] = SATURN;
        planets[6] = URANUS;
        planets[7] = NEPTUNE;
        planets[8] = PLUTO;
    }

    static double getSUN_X() {
        return SUN_X;
    }

    static double getSUN_Y() {
        return SUN_Y;
    }

    Planet[] getPlanets() {
        return planets;
    }

    static Map<Planet, ImageIcon> planetTexture = new HashMap<>();
}