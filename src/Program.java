import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        SolarSystem solarSystem = new SolarSystem();
        Planet[] planets = new Planet[10];
        solarSystem.setPlanetList(planets);
        Manager manager = new Manager(solarSystem);
        manager.setVisible(true);
    }

}
