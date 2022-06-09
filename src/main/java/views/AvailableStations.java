package main.java.views;

import main.java.dao.ChargingStationDao;
import main.java.listeners.TableButtonListenerImpl;
import main.java.model.ChargingStation;
import main.java.repository.ChargingStationRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AvailableStations extends JPanel {

    DefaultTableModel dm = new DefaultTableModel();
    ChargingStationRepository repository = new ChargingStationDao();

    public AvailableStations() {
        List<ChargingStation> allStations = repository.listarTodos();

        List<String[]> allStationsConverted = allStations.stream().map(ChargingStation::toTableObj).toList();

        String[][] allStationsArray = new String[allStationsConverted.size()][6];

        for (int i = 0; i < allStationsConverted.size(); i++) {
            allStationsArray[i] = allStationsConverted.get(i);
        }

        String[] columnNames = {"Nome", "Estado", "Cidade", "Avaliação", "Preço", "Mapa"};

        dm.setDataVector(allStationsArray, columnNames);

        CellButtonRenderer cellButton = new CellButtonRenderer("Mapa");
        cellButton.addTableButtonListener(new TableButtonListenerImpl());

        JTable table = new JTable(dm);
        table.getColumn("Mapa").setCellRenderer(cellButton);
        table.getColumn("Mapa").setCellEditor(cellButton);
        JScrollPane scroll = new JScrollPane(table);

        add(scroll);
    }

    @Override
    public void repaint() {
        super.repaint();

        repository = new ChargingStationDao();
        dm = new DefaultTableModel();
        List<ChargingStation> allStations = repository.listarTodos();

        List<String[]> allStationsConverted = allStations.stream().map(ChargingStation::toTableObj).toList();

        String[][] allStationsArray = new String[allStationsConverted.size()][6];

        for (int i = 0; i < allStationsConverted.size(); i++) {
            allStationsArray[i] = allStationsConverted.get(i);
        }

        String[] columnNames = {"Nome", "Estado", "Cidade", "Avaliação", "Preço", "Mapa"};

        dm.setDataVector(allStationsArray, columnNames);

        CellButtonRenderer cellButton = new CellButtonRenderer("Mapa");
        cellButton.addTableButtonListener(new TableButtonListenerImpl());

        JTable table = new JTable(dm);
        table.getColumn("Mapa").setCellRenderer(cellButton);
        table.getColumn("Mapa").setCellEditor(cellButton);
        JScrollPane scroll = new JScrollPane(table);

        removeAll();
        add(scroll);
    }
}
