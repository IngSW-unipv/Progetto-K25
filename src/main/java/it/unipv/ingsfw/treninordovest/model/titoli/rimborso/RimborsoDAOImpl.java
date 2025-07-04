package it.unipv.ingsfw.treninordovest.model.titoli.rimborso;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RimborsoDAOImpl implements RimborsoDAO {

    @Override
    public Rimborso get(Rimborso rimborso) {

        Rimborso rimborsoDB = null;
        String sql = "select * from rimborso where idRimborso=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps= con.prepareStatement(sql);ResultSet rs=ps.executeQuery()) {
            //Estrazione dei dati dal DB
            ps.setString(1,rimborso.getIdRimborso().toString());

            if(rs.next()){
                double totale = rs.getDouble("totale");
                String idBiglietto=rs.getString("idBiglietto");
                String idRichiedente = rs.getString("idRichiedente");
                LocalDate dataRimborso = (LocalDate)rs.getObject("DataRimborso");


                rimborsoDB=new Rimborso(rimborso.getIdRimborso().toString(),dataRimborso,totale,new Biglietto(idBiglietto),new Cliente(idRichiedente));
            }
           // Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rimborsoDB;

    }


    @Override
    public List<Rimborso> getAll()  {

        List<Rimborso> rimborsi = new ArrayList<>();
        Rimborso rimborso;
        String sql = "select * from rimborso ";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            //Estrazione dei dati dal DB
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                String idRimborso=rs.getString("idRimborso");
                double totale = rs.getDouble("totale");
                String idBiglietto=rs.getString("idBiglietto");
                String idRichiedente = rs.getString("idRichiedente");
                LocalDate dataRimborso = (LocalDate)rs.getObject("DataRimborso");


                rimborso=new Rimborso(idRimborso,dataRimborso,totale,new Biglietto(idBiglietto),new Cliente(idRichiedente));
                rimborsi.add(rimborso);
            }

            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante il recupero dei dati",e);
        }

        return rimborsi;
    }


    @Override
    public void delete(Rimborso rimborso)  {}

    @Override
    public void update(Rimborso rimborso)  {}

    @Override
    public void insert(Rimborso rimborso)  {
          String sql1 = "INSERT INTO rimborso (idRimborso,Totale,idBiglietto,idRichiedente,DataRimborso) VALUES (?,?,?,?,?)";


            try (Connection con = Database.getConnection() ;PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1,rimborso.getIdRimborso().toString());
                ps1.setDouble(2,rimborso.getTotale());
                ps1.setString(3,rimborso.getBiglietto().getId().toString());
                ps1.setString(4,rimborso.getCliente().getId().toString());
                ps1.setObject(5,rimborso.getDataRimborso());

                // Esecuzione delle query
                ps1.executeUpdate();

                //Database.closeConnection(con);
            }
            catch (SQLException e) {
                throw new RuntimeException("Errore durante l'inserimento dati",e);
            }





    }


    @Override
    public boolean exists(Rimborso rimborso) {
        String sql = "SELECT 1 FROM rimborso WHERE idBiglietto = ? LIMIT 1";

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rimborso.getBiglietto().getId().toString());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.err.println("Errore durante la verifica dell'esistenza del rimborso: " + e.getMessage());
            throw new RuntimeException("Impossibile accedere al database.", e);
        }

    }
}
