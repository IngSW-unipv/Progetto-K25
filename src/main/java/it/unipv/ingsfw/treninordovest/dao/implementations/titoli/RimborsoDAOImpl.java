package it.unipv.ingsfw.treninordovest.dao.implementations.titoli;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.RimborsoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.Rimborso;

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
            String sql = "select * from rimborso where idRimborso=?";

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

        List<Rimborso> rimborsi = null;
        Rimborso rimborso = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            rimborso = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from rimborso ";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            //ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                String idRimborso=rs.getString("idRimborso");
                Double totale = rs.getDouble("totale");
                String idBiglietto=rs.getString("idBiglietto");
                String idRichiedente = rs.getString("idRichiedente");
                LocalDate dataRimborso = (LocalDate)rs.getObject("DataRimborso");


                rimborso=new Rimborso(idRimborso,dataRimborso,totale,idBiglietto,idRichiedente);
                rimborsi.add(rimborso);
            }

            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rimborsi;
    }

    @Override
    public void delete(String id) throws SQLException {

        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from rimborso where idRimborso=?");
            ps.setString(1,id);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Rimborso rimborso) throws SQLException {
        String sql1="UPDATE rimborso set Totale=?,IDBiglietto=?, IDRichiedente=?,DataRimborso=? where idRimborso=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            ps1.setDouble(1,rimborso.getTotale());
            ps1.setString(2,rimborso.getIdBiglietto());
            ps1.setString(3,rimborso.getIdRichiedente());
            ps1.setObject(4,rimborso.getDataRimborso());
            ps1.setObject(5,rimborso.getIdRimborso());

            ps1.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insert(Rimborso rimborso) throws SQLException {
        Connection con = null;

        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO rimborso (idRimborso,Totale,idBiglietto,idRichiedente,DataRimborso) VALUES (?,?,?,?,?)";

            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1,rimborso.getIdRimborso());
                ps1.setDouble(2,rimborso.getTotale());
                ps1.setString(3,rimborso.getIdBiglietto());
                ps1.setString(4,rimborso.getIdRichiedente());
                ps1.setObject(5,rimborso.getDataRimborso());

                // Esecuzione delle query
                ps1.executeUpdate();

                Database.closeConnection(con);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }






    }
}
