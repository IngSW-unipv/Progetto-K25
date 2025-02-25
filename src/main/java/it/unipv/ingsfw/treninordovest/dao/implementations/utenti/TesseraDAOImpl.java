package it.unipv.ingsfw.treninordovest.dao.implementations.utenti;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.TesseraDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//idTessera emissione scadenza Idcliente

public class TesseraDAOImpl implements TesseraDAO {
    @Override
    public Tessera get(String id) throws SQLException {
        Tessera tessera = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            tessera = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from tessera where id=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
             String idTessera = rs.getString("IDTessera");
             LocalDate Emissione = (LocalDate) rs.getObject("Emissione");
             LocalDate Scadenza = (LocalDate) rs.getObject("Scadenza");
             String idCliente = rs.getString("IDCliente");

             tessera=new Tessera(idTessera, Emissione, Scadenza, idCliente);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tessera;
    }

    @Override
    public List<Tessera> getAll() throws SQLException {
        List listaTessere =  null;
        Tessera tessera= null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {

            listaTessere = new ArrayList<>();
            String sql = "select * from tessera";
            ps=null;

            //Prepared Statement
            ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                String idTessera = rs.getString("IDTessera");
                LocalDate Emissione = (LocalDate) rs.getObject("Emissione");
                LocalDate Scadenza = (LocalDate) rs.getObject("Scadenza");
                String idCliente = rs.getString("IDCliente");

                tessera=new Tessera(idTessera, Emissione, Scadenza, idCliente);
                listaTessere.add(tessera);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listaTessere;
    }

    @Override
    public void delete(String id) throws SQLException {
        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from tessera where IDTessera=?");
            ps.setString(1,id);
            ps.executeUpdate();
            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Tessera tessera) throws SQLException {

        String sql1="UPDATE tessera set emissione=?, scadenza=?, idcliente=? where IDTessera=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);

            //Impostazione degli attributi
            ps1.setObject(1,(LocalDate)tessera.getEmissione());
            ps1.setObject(2,(LocalDate) tessera.getScadenza());
            ps1.setString(3,tessera.getIdCliente());
            ps1.setString(4,tessera.getIdTessera());

            ps1.executeUpdate();

            //Chiusura della connessione col Database
            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void insert(Tessera tessera) throws SQLException {
        Connection con = null;
        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO tessera (IDTessera, emissione, scadenza, idcliente) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1, tessera.getIdTessera());
                ps1.setObject(2, tessera.getEmissione());
                ps1.setObject(3, tessera.getScadenza());
                ps1.setObject(4, tessera.getIdCliente());

                // Esecuzione delle query
                ps1.executeUpdate();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }

    }

    @Override
    public boolean exists(String idCliente) throws SQLException {
        Tessera tessera = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            tessera = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select idTessera, idCliente from tessera where IDCliente=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,idCliente);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String idTessera = rs.getString("IDTessera");
                String idCLiente = rs.getString("IDCliente");
                return true;
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getIdTessera(String idCliente) throws SQLException {

        String idTessera = null;
        Tessera tessera = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            tessera = null;
            String sql = "select idTessera, idCliente from tessera where IDCliente=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,idCliente);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                idTessera = rs.getString("IDTessera");
                idCliente = rs.getString("IDCliente");

            }
            Database.closeConnection(con);

        }catch (SQLException e) {
            e.printStackTrace();
        }



        return idTessera;
    }
}
