//import javax.swing.*;
//import java.awt.*;
//import java.util.HashMap;
//import java.util.Map;
//
//class Menu extends JFrame {
//
//    private static final Map<String, Color> COLORS = new HashMap<>();
//
//    Menu(SolarSystem solarSystem) {
//
//        JFrame jFrame = new JFrame("Menu");
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setSize(300, 600);
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setResizable(false);
//        JPanel panel = new JPanel();
//
//        GridLayout layout = new GridLayout(12, 0, 10, 15);
//        panel.setLayout(layout);
//
//        JLabel nameLabel = new JLabel("Введите название планеты");
//        nameLabel.setHorizontalAlignment(JLabel.CENTER);
//        panel.add(nameLabel);
//
//        JTextField nameField = new JTextField();
//        panel.add(nameField);
//
//        JLabel colorLabel = new JLabel("Выберите цвет планеты");
//        colorLabel.setHorizontalAlignment(JLabel.CENTER);
//        panel.add(colorLabel);
//        String[] nameColors = {"Белый", "Желтый", "Оранжевый", "Синий", "Красный",
//                "Циан", "Серый", "Зеленый", "Пурпурный", "Розовый"};
//
//        JComboBox<String> colorComboBox = new JComboBox<>(nameColors);
//        panel.add(colorComboBox);
//
//        JLabel speedLabel = new JLabel("Введите скорость вращения");
//        speedLabel.setHorizontalAlignment(JLabel.CENTER);
//        panel.add(speedLabel);
//
//        JTextField speedField = new JTextField();
//        panel.add(speedField);
//
//        JLabel radiusRotationLabel = new JLabel("Введите радиус вращения");
//        radiusRotationLabel.setHorizontalAlignment(JLabel.CENTER);
//        panel.add(radiusRotationLabel);
//
//        JTextField radiusRotationField = new JTextField();
//        panel.add(radiusRotationField);
//
//        JLabel radiusPlanetLabel = new JLabel("Введите радиус планеты");
//        radiusPlanetLabel.setHorizontalAlignment(JLabel.CENTER);
//        panel.add(radiusPlanetLabel);
//
//        JTextField radiusPlanetField = new JTextField();
//        panel.add(radiusPlanetField);
//
//        JButton addButton = new JButton("Добавить планету");
//        addButton.addActionListener(e -> {
//
//            Planet newPlanet = new Planet();
//            newPlanet.setName(nameField.getText());
//            newPlanet.setColorPlanet(COLORS.get(colorComboBox.getSelectedItem()));
//            try {
//                newPlanet.setSpeedRotation(Double.parseDouble(speedField.getText()));
//                newPlanet.setRadiusRotation(Double.parseDouble(radiusRotationField.getText()));
//                newPlanet.setRadiusPlanet(Double.parseDouble(radiusPlanetField.getText()));
//                if (solarSystem.canAdd(newPlanet)) {
//                    solarSystem.addPlanet(newPlanet);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Ошибка! Столкновение планет!",
//                            "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(null, "Некорректный ввод", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//
//        });
//        panel.add(addButton);
//        Manager manager = new Manager(solarSystem);
//        manager.setSize(1600, 900);
//        manager.setResizable(false);
//        JButton showButton = new JButton("Показать солнечную систему");
//        showButton.addActionListener(e -> manager.setVisible(true));
//        panel.add(showButton);
//        jFrame.add(panel);
//        jFrame.setVisible(true);
//    }
//
//    static {
//        COLORS.put("Белый", Color.WHITE);
//        COLORS.put("Желтый", Color.YELLOW);
//        COLORS.put("Оранжевый", Color.ORANGE);
//        COLORS.put("Синий", Color.BLUE);
//        COLORS.put("Красный", Color.RED);
//        COLORS.put("Циан", Color.CYAN);
//        COLORS.put("Серый", Color.GRAY);
//        COLORS.put("Зеленый", Color.GREEN);
//        COLORS.put("Пурпурный", Color.MAGENTA);
//        COLORS.put("Розовый", Color.PINK);
//    }
//}
