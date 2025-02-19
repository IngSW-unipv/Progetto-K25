package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.interfaces.TesseraDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;

import java.sql.SQLException;
import java.util.List;

public class TesseraDaoImpl implements TesseraDAO {
    @Override
    public Tessera get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Tessera> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public int save(Tessera tessera) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public int update(Tessera tessera) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Tessera tessera) throws SQLException {
        return 0;
    }
}
