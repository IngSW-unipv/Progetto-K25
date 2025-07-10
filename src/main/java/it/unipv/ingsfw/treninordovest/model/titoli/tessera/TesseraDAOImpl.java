package it.unipv.ingsfw.treninordovest.model.titoli.tessera;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.dao.exception.PersistenceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//idTessera emissione scadenza Idcliente

public class TesseraDAOImpl implements TesseraDAO {

    public TesseraDAOImpl()  {}


    @Override
    public Tessera get(Tessera tessera) {
        return null;
    }

    @Override
    public List<Tessera> getAll()  {
        return null;
    }

    @Override
    public void delete(Tessera tessera)  {
    }

    @Override
    public void update(Tessera tessera)  {
    }

    @Override
    public void insert(Tessera tessera)  {

    }

    @Override
    public boolean exists(String idCliente) {
        String sql = "SELECT idTessera FROM tessera WHERE IDCliente = ?";

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, idCliente);               // 1️⃣ imposta il parametro
            try (ResultSet rs = ps.executeQuery()) {  // 2️⃣ poi esegui la query
                if (rs.next()) {
                   rs.getString("idTessera");
                    return true;
                }


            }

        } catch (SQLException e) {
            throw new PersistenceException("Problemi durante il recupero della tessera");
        }

        return false;
    }

    @Override
    public boolean createTessera(Tessera tessera, String idCliente) {

        String sql1 = "INSERT INTO tessera (IDTessera, emissione, scadenza, idcliente) VALUES (?, ?, ?, ?)";

        if (!exists(idCliente)) {
            try (Connection con = Database.getConnection();PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1, tessera.getIdTessera());
                ps1.setObject(2, tessera.getEmissione());
                ps1.setObject(3, tessera.getScadenza());
                ps1.setObject(4, idCliente);

                // Esecuzione delle query
                ps1.executeUpdate();
                // Database.closeConnection(con);
                return true;
            }
            catch (SQLException e) {
               throw new PersistenceException("Problemi durante la creazione della tessera");
                //return false;

            }

        }

        return false;
    }

    @Override
    public String getIdTesseraByCustomerID(String idCliente) {

        String idTessera = "";
        String sql = "select IDTessera from tessera where IDCliente=?";
        //String idTessera = "";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ) {
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            //Estrazione dei dati dal DB
            ps.setString(1,idCliente);

            try (ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    idTessera = rs.getString("IDTessera");;
                    return idTessera;

                }

            }


            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new PersistenceException("Problemi durante il recupero della tessera");
        }



       return idTessera;
    }
}
