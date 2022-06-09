package main.java;

import main.java.dao.ChargingStationDao;
import main.java.model.Address;
import main.java.model.ChargingStation;
import main.java.model.Plugs;
import main.java.views.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ChargingStationDao dao = new ChargingStationDao();
        ChargingStation station = new ChargingStation(
                null, "name",
                new Address(null, "Avenida Lins de Vasconselos", "district", "city", "state"),
                1.0, new ArrayList<>(Arrays.asList(Plugs.TYPE1, Plugs.TYPE2)), 100.0
        );

        dao.inserir(station);
        List<ChargingStation> all = dao.listarTodos();

        new Window().init();
    }
}
