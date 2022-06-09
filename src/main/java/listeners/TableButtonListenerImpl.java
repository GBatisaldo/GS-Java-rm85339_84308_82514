package main.java.listeners;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import main.java.clients.GeocoderClient;
import main.java.dao.ChargingStationDao;
import main.java.model.ChargingStation;
import main.java.model.GeocodeRequest;
import main.java.repository.ChargingStationRepository;
import main.java.views.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class TableButtonListenerImpl implements TableButtonListener {

    ChargingStationRepository repository = new ChargingStationDao();

    private final String accessKey;

    public TableButtonListenerImpl() {
        accessKey = System.getenv("MAPBOX_ACCESS_TOKEN");

        if (accessKey == null) {
            throw new IllegalArgumentException("A variável de ambiente 'MAPBOX_ACCESS_TOKEN' está vazia");
        }
    }

    @Override
    public void tableButtonClicked(Long id) {
        ChargingStation chargingStation = repository.acharPorId(id);

        GeocoderClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(GeocoderClient.class, "https://api.mapbox.com");

        GeocodeRequest request = client.getLatLongFromAddress(chargingStation.getAddr().getRoadToUrl(), accessKey);

        Double lat = request.getFeatures().get(0).getCenter().get(0);
        Double log = request.getFeatures().get(0).getCenter().get(1);
        JOptionPane.showMessageDialog(null, getPanel(lat, log), "Mapa", JOptionPane.PLAIN_MESSAGE);
    }

    private JPanel getPanel(Double lat, Double log) {
        String url = "https://api.mapbox.com/styles/v1/mapbox/navigation-night-v1/static/pin-s+ff4724("
                + lat + "," + log +
                ")/" + lat + "," + log +
                ",13/600x600?access_token=" + accessKey;

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new ImagePanel(url), BorderLayout.CENTER);

        return panel;
    }
}
