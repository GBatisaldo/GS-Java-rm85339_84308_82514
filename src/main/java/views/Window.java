package main.java.views;

import javax.swing.*;

public class Window extends JFrame {

    JTabbedPane panels = new JTabbedPane();
    AvailableStations availableStationsPanel = new AvailableStations();
    Register registerPanel = new Register(availableStationsPanel);

    public Window() {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panels.addTab("Registrar novo posto", registerPanel);

        panels.addTab("Consultar postos", availableStationsPanel);

        add(panels);
    }

    public void init() {
        setVisible(true);
        add(new JPanel());
    }
}
