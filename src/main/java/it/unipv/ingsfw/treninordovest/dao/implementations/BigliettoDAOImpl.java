package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.interfaces.BigliettoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;

import java.sql.SQLException;
import java.util.List;

public class BigliettoDAOImpl implements BigliettoDAO {
    @Override
    public Biglietto get(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Biglietto> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void delete(String id) throws SQLException {

    }

    @Override
    public void update(Biglietto biglietto) throws SQLException {

    }

    @Override
    public void insert(Biglietto biglietto) throws SQLException {

    }
}
