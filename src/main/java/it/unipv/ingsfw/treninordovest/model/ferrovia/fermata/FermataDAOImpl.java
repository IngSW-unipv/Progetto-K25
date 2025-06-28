package it.unipv.ingsfw.treninordovest.model.ferrovia.fermata;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FermataDAOImpl implements FermataDAO {

    @Override
    public Fermata get(Fermata fermata) {

        String sql = "select idFermata, citta, numBinari from Fermata where idFermata=?";

        try (Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql)) {
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            //Estrazione dei dati dal DB
            ps.setString(1, fermata.getIdFermata());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String idFermata = rs.getString("idFermata");
                String citta = rs.getString("citta");
                int numBinari = rs.getInt("numBinari");


                fermata = new Fermata(idFermata, citta, numBinari);
            }

            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fermata;
    }


    public List<Fermata> getAll() {
        List<Fermata> fermate= new ArrayList<Fermata>();

        //Avvio della connessione col DB
        Fermata fermata = null;
        String sql = "select idFermata, citta, numBinari from Fermata";
        try (Connection con = Database.getConnection()) {

            //Query estrazione fermate
            try (PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs=ps.executeQuery();){
                while(rs.next()){
                    String idFermata=rs.getString("idFermata");
                    String citta=rs.getString("citta");
                    int numBinari=rs.getInt("numBinari");



                    fermata=new Fermata(idFermata, citta, numBinari);
                    fermate.add(fermata);
                }
            }

            //Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fermate;
    }


    @Override
    public void delete(Fermata fermata)  {
        try(Connection con = Database.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Fermata where idFermata=?");
            ps.setString(1,fermata.getIdFermata());

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Fermata fermata)  {
        String sql1="UPDATE fermata set citta=?, numBinari=? where idFermata=?";

        try(Connection con = Database.getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            ps1.setString(1,fermata.getCitta());
            ps1.setInt(2,fermata.getNumBinari());
            ps1.setString(3,fermata.getIdFermata());

            ps1.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(Fermata fermata)  {

        Connection con = null;
        try {
            con = Database.getConnection();
            String sql1 = "INSERT INTO Fermata (idFermata, citta, numBinari) VALUES (?,?,?)";

            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1,fermata.getIdFermata());
                ps1.setString(2,fermata.getCitta());
                ps1.setInt(3,fermata.getNumBinari());

                // Esecuzione delle query
                ps1.executeUpdate();

                Database.closeConnection(con);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}