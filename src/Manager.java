import javax.swing.*;

class Manager extends JFrame {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    Manager(SolarSystem solarSystem) {
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PaintPlanet paintPlanet = new PaintPlanet(solarSystem);
        this.add(paintPlanet);
    }

    static int getWIDTH() {
        return WIDTH;
    }

    static int getHEIGHT() {
        return HEIGHT;
    }
}


