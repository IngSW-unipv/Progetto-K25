package it.unipv.ingsfw.treninordovest.model.titoli.tessera;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;

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
      /*  String sql = "select * from tessera where IDTessera=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql);ResultSet rs=ps.executeQuery() ) {

            //Estrazione dei dati dal DB
            ps.setString(1,tessera.getIdTessera());
            if(rs.next()){
             String idTessera = rs.getString("IDTessera");
             LocalDate Emissione = (LocalDate) rs.getObject("Emissione");
             LocalDate Scadenza = (LocalDate) rs.getObject("Scadenza");
             String idCliente = rs.getString("IDCliente");

             tessera=new Tessera(tessera.getIdTessera(), Emissione, Scadenza);
            }
            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException( "Errore durante il recupero dei dati: ",e);
        }
        return tessera;

       */
        return null;
    }


    @Override
    public List<Tessera> getAll()  {
/*
        List<Tessera> listaTessere =  new ArrayList<>();
        Tessera tessera;

        String sql = "select * from tessera";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql);ResultSet rs=ps.executeQuery()) {

            while (rs.next()){
                String idTessera = rs.getString("IDTessera");
                LocalDate Emissione = (LocalDate) rs.getObject("Emissione");
                LocalDate Scadenza = (LocalDate) rs.getObject("Scadenza");
                String idCliente = rs.getString("IDCliente");

                tessera=new Tessera(idTessera, Emissione, Scadenza);
                listaTessere.add(tessera);
            }
            //Database.closeConnection(con);

        } catch (SQLException e) {
           e.printStackTrace();
        }


        return listaTessere;

 */
        return null;
    }



    @Override
    public void delete(Tessera tessera)  {
/*
        String sql = "delete from tessera where IDTessera=?";

        try(Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,tessera.getIdTessera());
            ps.executeUpdate();
            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

 */
    }

    @Override
    public void update(Tessera tessera)  {
        /*

        String sql1="UPDATE tessera set emissione=?, scadenza=?, idcliente=? where IDTessera=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps1= con.prepareStatement(sql1)){

            //Impostazione degli attributi
            ps1.setObject(1,(LocalDate)tessera.getEmissione());
            ps1.setObject(2,(LocalDate) tessera.getScadenza());
            ps1.setString(3,tessera.getIdCliente());
            ps1.setString(4,tessera.getIdTessera());

            ps1.executeUpdate();
            //Chiusura della connessione col Database
            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        */
    }

    @Override
    public void insert(Tessera tessera)  {
        /*
            String sql1 = "INSERT INTO tessera (IDTessera, emissione, scadenza, idcliente) VALUES (?, ?, ?, ?)";
            try (Connection con = Database.getConnection();PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1, tessera.getIdTessera());
                ps1.setObject(2, tessera.getEmissione());
                ps1.setObject(3, tessera.getScadenza());
                ps1.setObject(4, tessera.getIdCliente());

                // Esecuzione delle query
                ps1.executeUpdate();
               // Database.closeConnection(con);

            }
         catch (Exception e) {
             throw new RuntimeException("Errore durante l'inserimento dati",e);
        }
        */
    }

    /*Metodi da valutare*/

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
            e.printStackTrace();
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
                e.printStackTrace();
                //return false;

            }

        }

        return false;
    }

    @Override
    public String getIdTesseraByCustomerID(String idCliente) {

        String sql = "select IDTessera from tessera where IDCliente=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ) {
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            //Estrazione dei dati dal DB
            ps.setString(1,idCliente);

            try (ResultSet rs=ps.executeQuery()){
                if(rs.next()){

                    return rs.getString("IDTessera");

                }

            }


            //Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return "";
    }
}
