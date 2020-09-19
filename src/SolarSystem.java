class SolarSystem {

    static final Planet SUN = new Planet("Sun", 0, 40);
    private static final double SUN_X = 0.5 * Frame.getWIDTH();
    private static final double SUN_Y = 0.5 * Frame.getHEIGHT();
    private static final Planet MERCURY = new Planet("Mercury", 50, 7);
    private static final Planet VENUS = new Planet("Venus", 70, 10);
    private static final Planet EARTH = new Planet("Earth", 100, 15);
    private static final Planet MARS = new Planet("Mars", 140, 12);
    private static final Planet JUPITER = new Planet("Jupiter", 205, 25);
    private static final Planet SATURN = new Planet("Saturn", 270, 25);
    private static final Planet URANUS = new Planet("Uranus", 325, 15);
    private static final Planet NEPTUNE = new Planet("Neptune", 370, 15);
    private static final Planet PLUTO = new Planet("Pluto", 500, 5);
    private Planet[] planets;

    SolarSystem() {
        this.planets = new Planet[]{MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE, PLUTO};
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