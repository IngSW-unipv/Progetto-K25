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
    public TrenoTratta getTT(String id1, String id2) throws SQLException {
        TrenoTratta trenoTratta = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            trenoTratta = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select idTreno, idTratta, numTreno from trenoTratta where idTreno=? AND idTratta=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,id1);
            ps.setString(1,id2);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String idTreno = rs.getString("idTreno");
                String idTratta = rs.getString("idTratta");
                int numTreno = rs.getInt("numTreno");

                trenoTratta=new TrenoTratta(idTratta, idTreno, numTreno);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trenoTratta;
    }
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

}
