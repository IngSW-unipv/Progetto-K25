package it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.dao.exception.PersistenceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TitoloViaggioDAOImpl implements TitoloViaggioDAO{
    @Override
    public TitoloViaggio get(TitoloViaggio oggetto) {
        return null;
    }

    @Override
    public List<TitoloViaggio> getAll() {
        return List.of();
    }

    @Override
    public void delete(TitoloViaggio titoloViaggio) {
    }

    @Override
    public void update(TitoloViaggio titoloViaggio) {
    }

    @Override
    public void insert(TitoloViaggio titoloViaggio) {
    }


    @Override
    public TitoloViaggio findByID(String idTitolo) {
        TitoloViaggio titoloViaggio = null;
        String sql = "SELECT * FROM titoloviaggio WHERE IDTitolo = ?";
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, idTitolo);               // 1️⃣ imposta il parametro
            try (ResultSet rs = ps.executeQuery()) {  // 2️⃣ poi esegui la query
                if (rs.next()) {
                    rs.getString( "IDTitolo");
                    rs.getString( "IDCliente");
                    rs.getString( "IDTessera");
                    rs.getString( "DataInizio");
                    return titoloViaggio;
                }
            }
        } catch (SQLException e) {
            throw new PersistenceException("Problemi durante il recupero della tessera");
        }
        
        
        return titoloViaggio;
    }
}
