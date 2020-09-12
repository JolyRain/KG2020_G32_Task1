import java.awt.*;

class SolarSystem {

    static final Planet SUN = new Planet("Sun", Color.RED, 0, 30);
    private static final double SUN_X = 0.5 * Frame.getWIDTH();
    private static final double SUN_Y = 0.5 * Frame.getHEIGHT();
    private static final Planet MERCURY = new Planet("Mercury", Defaults.MERCURY_COLOR, 40, 5);
    private static final Planet VENUS = new Planet("Venus", Defaults.VENUS_COLOR, 60, 10);
    private static final Planet EARTH = new Planet("Earth", Defaults.EARTH_COLOR, 85, 10);
    private static final Planet MARS = new Planet("Mars", Defaults.MARS_COLOR, 110, 10);
    private static final Planet JUPITER = new Planet("Jupiter", Defaults.JUPITER_COLOR, 205, 20);
    private static final Planet SATURN = new Planet("Saturn", Defaults.SATURN_COLOR, 255, 20);
    private static final Planet URANUS = new Planet("Uranus", Defaults.URANUS_COLOR, 305, 15);
    private static final Planet NEPTUNE = new Planet("Neptune", Defaults.NEPTUNE_COLOR, 355, 15);
    private static final Planet PLUTO = new Planet("Pluto", Defaults.PLUTO_COLOR, 500, 5);

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
}