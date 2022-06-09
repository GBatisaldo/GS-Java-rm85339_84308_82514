package main.java.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import main.java.model.ChargingStation;
import main.java.repository.ChargingStationRepository;

import java.util.List;

public class ChargingStationDao implements ChargingStationRepository {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("chargingStations");
    EntityManager manager = factory.createEntityManager();

    @Override
    public void inserir(ChargingStation chargingStation) {
        manager.getTransaction().begin();
        manager.persist(chargingStation.getAddr());
        manager.persist(chargingStation);
        manager.getTransaction().commit();
    }

    @Override
    public List<ChargingStation> listarTodos() {
        TypedQuery<ChargingStation> query = manager.createQuery("SELECT c FROM ChargingStation c", ChargingStation.class);
        return query.getResultList();
    }

    @Override
    public ChargingStation acharPorId(Long id) {
        TypedQuery<ChargingStation> query =
                manager.createQuery("SELECT c FROM ChargingStation c WHERE c.id = " + id, ChargingStation.class);
        return query.getSingleResult();
    }
}
