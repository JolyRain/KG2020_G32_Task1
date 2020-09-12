import java.awt.*;

class SolarSystem {

    private static final double SUN_X = 0.5 * Manager.getWIDTH();
    private static final double SUN_Y = 0.5 * Manager.getHEIGHT();
    private static final Planet SUN = new Planet("Sun", Color.RED, 0, 30, SUN_X, SUN_Y);
    private static final Planet MERCURY = new Planet("Mercury", Color.yellow, 40, 5);
    private static final Planet VENUS = new Planet("Venus", Color.orange, 60, 10);
    private static final Planet EARTH = new Planet("Earth", Color.GREEN, 85, 10);
    private static final Planet MARS = new Planet("Mars", Color.RED, 110, 10);
    private static final Planet JUPITER = new Planet("Jupiter", Color.orange, 205, 20);
    private static final Planet SATURN = new Planet("Saturn", Color.yellow, 255, 20);
    private static final Planet URANUS = new Planet("Uranus", Color.blue, 305, 15);
    private static final Planet NEPTUNE = new Planet("Neptune", Color.blue, 355, 15);
    private static final Planet PLUTO = new Planet("Pluto", Color.darkGray, 500, 5);

    private Planet[] planets;

    SolarSystem() {
    }

    static double getSUN_X() {
        return SUN_X;
    }

    static double getSUN_Y() {
        return SUN_Y;
    }

    Planet[] getPlanetList() {
        return planets;
    }

    void setPlanetList(Planet[] planets) {
        planets[0] = SUN;
        planets[1] = MERCURY;
        planets[2] = VENUS;
        planets[3] = EARTH;
        planets[4] = MARS;
        planets[5] = JUPITER;
        planets[6] = SATURN;
        planets[7] = URANUS;
        planets[8] = NEPTUNE;
        planets[9] = PLUTO;
        this.planets = planets;
    }
}