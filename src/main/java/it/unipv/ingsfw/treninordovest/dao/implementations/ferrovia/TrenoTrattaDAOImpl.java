package it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.TrenoTrattaDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.TrenoTratta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class TrenoTrattaDAOImpl implements TrenoTrattaDAO{

    @Override
    public TrenoTratta get(String id) throws SQLException {
        return null;
    }

    @Override
    public List<TrenoTratta> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void delete(String id) throws SQLException {

    }

    @Override
    public void update(TrenoTratta trenoTratta) throws SQLException {

    }

    @Override
    public void insert(TrenoTratta trenoTratta) throws SQLException {

    }

    @Override
    public TrenoTratta get(String idTreno, String idTratta) throws SQLException {
        return null;
    }
}
