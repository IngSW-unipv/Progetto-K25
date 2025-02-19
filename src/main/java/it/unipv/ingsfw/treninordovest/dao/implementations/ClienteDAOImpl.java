package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public Cliente get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public int save(Cliente cliente) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public int update(Cliente cliente) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Cliente cliente) throws SQLException {
        return 0;
    }
}
