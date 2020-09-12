import javax.swing.*;

class Frame extends JFrame {

    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;

    Frame() {
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        DrawPanel drawPanel = new DrawPanel();
        this.add(drawPanel);
    }

    static int getWIDTH() {
        return WIDTH;
    }

    static int getHEIGHT() {
        return HEIGHT;
    }
}


