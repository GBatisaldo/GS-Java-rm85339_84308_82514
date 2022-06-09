package main.java.listeners;

import lombok.AllArgsConstructor;
import main.java.dao.ChargingStationDao;
import main.java.model.Address;
import main.java.model.ChargingStation;
import main.java.model.Plugs;
import main.java.repository.ChargingStationRepository;
import main.java.views.AvailableStations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class SubmitButtonActionListener implements ActionListener {

    private JTextField nameField;
    private JTextField roadField;
    private JTextField districtField;
    private JTextField cityField;
    private JComboBox<String> stateField;
    private JSpinner reviewField;
    private Set<Plugs> selectedPlugs;
    private JFormattedTextField priceField;
    private AvailableStations stationsView;

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String road = roadField.getText();
        String district = districtField.getText();
        String city = cityField.getText();
        String state = (String) stateField.getSelectedItem();
        Double review = (Double) reviewField.getValue();

        Double price;
        if (priceField.getValue().getClass() == Long.class) {
            Long priceFieldValue = (Long) priceField.getValue();
            price = priceFieldValue.doubleValue();
        } else {
            price = (Double) priceField.getValue();
        }

        if (name.isBlank() || road.isBlank() || district.isBlank() || city.isBlank() || state.isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
            return;
        }

        if (price <= 0.0) {
            JOptionPane.showMessageDialog(null, "O valor deve ser maior do que R$ 0.0");
            return;
        }

        Address stationAddr = new Address(null, road, district, city, state);
        ChargingStation chargingStation = new ChargingStation(
                null, name, stationAddr, review, selectedPlugs.stream().toList(), price
        );

        ChargingStationRepository dao = new ChargingStationDao();
        dao.inserir(chargingStation);

        JOptionPane.showMessageDialog(null, "Posto de recarga cadastrado com sucesso.");

        nameField.setText("");
        roadField.setText("");
        districtField.setText("");
        cityField.setText("");
        stateField.setSelectedIndex(0);
        reviewField.setValue(0.0);
        selectedPlugs = new HashSet<>();
        priceField.setValue(0.0);

        stationsView.validate();
        stationsView.repaint();
    }
}
