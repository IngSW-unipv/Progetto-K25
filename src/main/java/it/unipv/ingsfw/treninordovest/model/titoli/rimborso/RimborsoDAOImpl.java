package it.unipv.ingsfw.treninordovest.model.titoli.rimborso;

import it.unipv.ingsfw.treninordovest.dao.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RimborsoDAOImpl implements RimborsoDAO {

    @Override
    public Rimborso get(String id) {

        Rimborso rimborso = null;
        String sql = "select * from rimborso where idRimborso=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps= con.prepareStatement(sql);ResultSet rs=ps.executeQuery()) {
            //Estrazione dei dati dal DB
            ps.setString(1,id);

            if(rs.next()){
                double totale = rs.getDouble("totale");
                String idBiglietto=rs.getString("idBiglietto");
                String idRichiedente = rs.getString("idRichiedente");
                LocalDate dataRimborso = (LocalDate)rs.getObject("DataRimborso");


                rimborso=new Rimborso(id,dataRimborso,totale,idBiglietto,idRichiedente);
            }
           // Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rimborso;

    }

    @Override
    public Rimborso get(Rimborso oggetto) {
        return null;
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


                rimborso=new Rimborso(idRimborso,dataRimborso,totale,idBiglietto,idRichiedente);
                rimborsi.add(rimborso);
            }

            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante il recupero dei dati",e);
        }

        return rimborsi;
    }

    @Override
    public void delete(Rimborso rimborso) {

    }

    @Override
    public void delete(String id)  {

        try(Connection con = Database.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from rimborso where idRimborso=?");
            ps.setString(1,id);

            ps.executeUpdate();

           // Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'eliminazione dati",e);
        }


    }

    @Override
    public void update(Rimborso rimborso)  {
        String sql1="UPDATE rimborso set Totale=?,IDBiglietto=?, IDRichiedente=?,DataRimborso=? where idRimborso=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps1= con.prepareStatement(sql1)){
            //Prima Query
            ps1.setDouble(1,rimborso.getTotale());
            ps1.setString(2,rimborso.getIdBiglietto());
            ps1.setString(3,rimborso.getIdRichiedente());
            ps1.setObject(4,rimborso.getDataRimborso());
            ps1.setObject(5,rimborso.getIdRimborso());

            ps1.executeUpdate();

           // Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'aggiornamento dati",e);
        }


    }

    @Override
    public void insert(Rimborso rimborso)  {
            String sql1 = "INSERT INTO rimborso (idRimborso,Totale,idBiglietto,idRichiedente,DataRimborso) VALUES (?,?,?,?,?)";


            try (Connection con = Database.getConnection() ;PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1,rimborso.getIdRimborso());
                ps1.setDouble(2,rimborso.getTotale());
                ps1.setString(3,rimborso.getIdBiglietto());
                ps1.setString(4,rimborso.getIdRichiedente());
                ps1.setObject(5,rimborso.getDataRimborso());

                // Esecuzione delle query
                ps1.executeUpdate();

                //Database.closeConnection(con);
            }
            catch (Exception e) {
                throw new RuntimeException("Errore durante l'inserimento dati",e);
            }



    }
}
