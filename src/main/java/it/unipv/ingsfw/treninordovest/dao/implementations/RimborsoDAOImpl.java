package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.RimborsoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.Rimborso;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class RimborsoDAOImpl implements RimborsoDAO {

    @Override
    public Rimborso get(String id) throws SQLException {

        Rimborso rimborso = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            rimborso = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from rimborso where id=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                Double totale = rs.getDouble("totale");
                String idBiglietto=rs.getString("idBiglietto");
                String idRichiedente = rs.getString("idRichiedente");
                LocalDate dataRimborso = (LocalDate)rs.getObject("DataRimborso");


                rimborso=new Rimborso(id,dataRimborso,totale,idBiglietto,idRichiedente);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rimborso;
    }

    @Override
    public List<Rimborso> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void delete(String id) throws SQLException {

    }

    @Override
    public void update(Rimborso rimborso) throws SQLException {

    }

    @Override
    public void insert(Rimborso rimborso) throws SQLException {

    }
}
