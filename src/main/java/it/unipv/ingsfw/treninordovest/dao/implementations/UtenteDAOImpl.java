package it.unipv.ingsfw.treninordovest.dao.implementations;
import it.unipv.ingsfw.treninordovest.dao.interfaces.UtenteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;

import java.sql.SQLException;
import java.util.List;

public class UtenteDAOImpl implements UtenteDAO {

    @Override
    public Utente get(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Utente> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public int save(Utente utente) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public int update(Utente utente) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Utente utente) throws SQLException {
        return 0;
    }
}
