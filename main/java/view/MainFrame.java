package Wetterstation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    WeatherStationModel model;
    final JPanel weatherStationBox;
    String path;
    JTextField pathField;

    MainFrame(String title){
        super( title );

        final Box logoBox = getLogoBox();
        pathField = getPathField();
        final JTextField searchField = getSearchField(pathField);
        final JPanel scanPanel = getScanPanel();

        final JPanel pathPanel = new JPanel();
        pathPanel.setBorder(BorderFactory.createBevelBorder(2));
        pathPanel.setBackground(new Color(0xEEFFFA));
        pathPanel.add(pathField);
        pathPanel.add(scanPanel);

        final JPanel textBoxes = new JPanel();
        textBoxes.add(pathPanel);
        textBoxes.add(Box.createRigidArea(new Dimension(40, 55)));
        textBoxes.add(searchField);

        final Box menu = new Box(BoxLayout.X_AXIS);
        menu.add(Box.createRigidArea(new Dimension(10, 15)));
        menu.add(logoBox);
        menu.add(Box.createRigidArea(new Dimension(100, 15)));
        menu.add(textBoxes);
        menu.add(Box.createRigidArea(new Dimension(9, 15)));
        menu.setBackground(new Color(210));

        weatherStationBox = new WeatherStationBox();
        weatherStationBox.setBounds(0, 60, WIDTH, HEIGHT - menu.getHeight());
        weatherStationBox.setBackground(new Color(0x006042));

        final JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(800, 1));
        separator.setBackground(new Color(0xE3E3E3));

        final Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(menu, BorderLayout.NORTH);
        mainBox.add(separator, BorderLayout.CENTER);
        mainBox.add(weatherStationBox, BorderLayout.SOUTH);

        add(mainBox);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static JTextField getPathField() {
        final JTextField pathField = new JTextField(20);
        pathField.setPreferredSize(new Dimension(pathField.getPreferredSize().width, 27));
        pathField.setToolTipText("Pfad zur CSV-Datei");
        pathField.setFont(new Font("Calibri", Font.PLAIN, 14));
        pathField.setSelectionColor(new Color(0xEEFFFA));
        pathField.setBackground(new Color(0xEEFFFA));
        pathField.setBorder(BorderFactory.createBevelBorder(2));
        return pathField;
    }

    private static JTextField getSearchField(JTextField pathField) {

        final JTextField searchField = new JTextField(18);
        searchField.setPreferredSize(new Dimension(pathField.getPreferredSize().width, 40));
        searchField.setBackground(new Color(0xEEFFFA));
        searchField.setBorder(BorderFactory.createBevelBorder(2));
        searchField.replaceSelection("Suche");
        searchField.addActionListener(action -> new SearchListener(searchField.getText()));
        searchField.setFont(new Font("Calibri", Font.PLAIN, 14));
        searchField.setSelectionColor(new Color(0xCEE1DF));

        return searchField;
    }

    private JPanel getScanPanel() {

        final JButton scanButton = new JButton("Scannen");
        scanButton.setBackground(new Color(0xF1EFEF));
        scanButton.setBorder(null);
        scanButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        scanButton.addActionListener(action -> new FolderScanner(model, pathField.getText()));

        final JPanel scanPanel = new JPanel();
        scanPanel.add(scanButton);
        scanPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        return scanPanel;
    }

    private static Box getLogoBox() {

        final JLabel label1 = new JLabel("Verwaltung von");
        final JLabel label2 = new JLabel("WETTERSTATION");
        label1.setFont(new Font("Calibri", Font.PLAIN, 12));
        label2.setFont(new Font("Calibri", Font.BOLD, 22));

        final Box logoBox = new Box(BoxLayout.Y_AXIS);
        logoBox.add(label1);
        logoBox.add(label2);
        return logoBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("actionPerformed scan");

    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setWeatherStationModel(WeatherStationModel model) {
        this.model = model;
    }
}
