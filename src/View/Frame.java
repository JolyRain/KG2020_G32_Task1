package View;

import javax.swing.*;

public class Frame extends JFrame {

    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;

    public Frame() {
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        DrawPanel drawPanel = new DrawPanel();
        this.add(drawPanel);
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}


