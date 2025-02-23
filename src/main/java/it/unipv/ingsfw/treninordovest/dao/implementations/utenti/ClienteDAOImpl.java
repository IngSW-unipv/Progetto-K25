package it.unipv.ingsfw.treninordovest.dao.implementations.utenti;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*Classe che implementa l'interfaccia DAO derivata specifica di ogni entità, con essa si rispetta il CRUD per estrapolare dati dal DB */


public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public Cliente get(String id) throws SQLException {

        //Avvio della connessione col DB
        Cliente cliente = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            cliente = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select ID,nome,cognome,email,Userpassword,bilancio,luogoNascita,dataNascita,sesso,cellulare,indirizzo,sesso from utentiClienti where id=?";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String nome=rs.getString("nome");
                String cognome=rs.getString("cognome");
                String email=rs.getString("email");
                String password=rs.getString("UserPassword");
                double bilancio=rs.getDouble("bilancio");
                String luogoNascita=rs.getString("luogoNascita");
                LocalDate dataNascita= (LocalDate) rs.getObject("dataNascita");
                String sesso=rs.getString("sesso");
                String cellulare=rs.getString("cellulare");
                String indirizzo=rs.getString("indirizzo");


                cliente=new Cliente(id,password,nome,cognome,luogoNascita, sesso, dataNascita,cellulare,indirizzo,bilancio,email);
            }

            Database.closeConnection(con);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;

    }

    @Override
    public List<Cliente> getAll() throws SQLException {

        //Variabili
        List<Cliente> clienti = new ArrayList<Cliente>();

        //Avvio della connessione col DB
        PreparedStatement ps;
        Cliente cliente = null;
        try (Connection con = new Database().getConnection()) {

            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select ID,nome,cognome,email,Userpassword,bilancio,luogoNascita,dataNascita,sesso,cellulare,indirizzo,sesso from utentiClienti";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);

        //ps.setString(1,id);
        ResultSet rs=ps.executeQuery();

        while(rs.next()){
            String id=rs.getString("ID");
            String nome=rs.getString("nome");
            String cognome=rs.getString("cognome");
            String email=rs.getString("email");
            String password=rs.getString("UserPassword");
            double bilancio=rs.getDouble("bilancio");
            String luogoNascita=rs.getString("luogoNascita");
            LocalDate dataNascita= (LocalDate) rs.getObject("dataNascita");
            String sesso=rs.getString("sesso");
            String cellulare=rs.getString("cellulare");
            String indirizzo=rs.getString("indirizzo");


            cliente=new Cliente(id,password,nome,cognome,luogoNascita, sesso, dataNascita,cellulare,indirizzo,bilancio,email);
            clienti.add(cliente);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clienti;
    }
    @Override
    public void delete(String id) throws SQLException {
        try(Connection con = new Database().getConnection()){
                     PreparedStatement ps = con.prepareStatement("delete from utente where ID=?");
                     ps.setString(1,id);

                     ps.executeUpdate();

                    Database.closeConnection(con);

                 } catch (Exception e) {
                     throw new RuntimeException(e);
                 }

    }

    @Override
    public void update(Cliente cliente) throws SQLException {
        String sql1="UPDATE utente set password=?, nome=?, cognome=?, luogoNascita=?, sessoChar=?, dataNascita=?, cellulare=?, indirizzo=? where ID=?";
        String sql2="UPDATE cliente set Bilancio=?, Email=? where IDCliente=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            PreparedStatement ps2= con.prepareStatement(sql2);
            //Impostazione degli attributi

            ps1.setString(1,cliente.getUserPassword());
            ps1.setString(2,cliente.getNome());
            ps1.setString(3,cliente.getCognome());
            ps1.setString(4,cliente.getLuogoNascita());
            ps1.setString(5,cliente.getSesso());
            ps1.setObject(6, cliente.getDataNascita());
            ps1.setString(7,cliente.getCellulare());
            ps1.setString(8,cliente.getIndirizzo());
            ps1.setString(9,cliente.getId());

            //Seconda Query
            ps2.setDouble(1,cliente.getBilancio());
            ps2.setString(2,cliente.getEmail());
            ps2.setString(3,cliente.getId());

            ps1.executeUpdate();
            ps2.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(Cliente cliente) throws SQLException {
        Connection con = null;
        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO utente (ID, UserPassword, Nome, Cognome, Sesso, LuogoNascita, DataNascita, Cellulare, Indirizzo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String sql2 = "INSERT INTO cliente (IDCliente, Bilancio, Email) VALUES (?, ?, ?)";

            try (PreparedStatement ps1 = con.prepareStatement(sql1);
                 PreparedStatement ps2 = con.prepareStatement(sql2)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1, cliente.getId());
                ps1.setString(2, cliente.getUserPassword());
                ps1.setString(3, cliente.getNome());
                ps1.setString(4, cliente.getCognome());
                ps1.setString(5, String.valueOf(cliente.getSesso()));
                ps1.setString(6, cliente.getLuogoNascita());
                ps1.setObject(7, cliente.getDataNascita()); // Assicurati che il driver JDBC supporti JDBC 4.2+
                ps1.setString(8, cliente.getCellulare());
                ps1.setString(9, cliente.getIndirizzo());

                // Impostazione dei parametri per la query 2
                ps2.setString(1, cliente.getId());
                ps2.setDouble(2, cliente.getBilancio());
                ps2.setString(3, cliente.getEmail());

                // Esecuzione delle query
                ps1.executeUpdate();
                ps2.executeUpdate();
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
