package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.utils.PasswordUtils;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

/*Classe che implementa l'interfaccia DAO derivata specifica di ogni entità, con essa si rispetta il CRUD per estrapolare dati dal DB */


public class ClienteDAOImpl implements ClienteDAO {

    public ClienteDAOImpl() {
    }

    @Override
    public Cliente get(Cliente cliente) {

        String sql = "select ID,nome,cognome,email,Userpassword,bilancio,luogoNascita,dataNascita,sesso,cellulare,indirizzo,sesso from utentiClienti where email=? ";
        String hashedPassword = PasswordUtils.hashPassword(cliente.getUserPassword());

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {



             ps.setString(1, cliente.getEmail());

            try (ResultSet rs = ps.executeQuery()) {


                if (rs.next()) {
                    String storedHash = rs.getString("UserPassword");
                    if (PasswordUtils.verifyPassword(cliente.getUserPassword(), storedHash)){
                        String nome = rs.getString("nome");
                        String cognome = rs.getString("cognome");
                        String email = rs.getString("email");
                        String password = rs.getString("UserPassword");
                        double bilancio = rs.getDouble("bilancio");
                        String luogoNascita = rs.getString("luogoNascita");

                        Date dataNascita = rs.getDate("dataNascita");
                        LocalDate dataNascitaLocal = dataNascita.toLocalDate();

                        String sesso = rs.getString("sesso");
                        String cellulare = rs.getString("cellulare");
                        String indirizzo = rs.getString("indirizzo");


                        cliente = new Cliente(cliente.getId(), password, nome, cognome, luogoNascita, sesso, dataNascitaLocal, cellulare, indirizzo, bilancio, email);

                    }

                }

            }


        } catch (SQLException e) {
            throw new RuntimeException("Errore durante il recupero dei dati: ", e);
        }

        return cliente;
    }




    @Override
    public List<Cliente> getAll() {

        List<Cliente> clienti = new ArrayList<>();
        String sql = "select ID,nome,cognome,email,Userpassword,bilancio,luogoNascita,dataNascita,sesso,cellulare,indirizzo,sesso from utentiClienti";
        Cliente cliente;

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            //Itera sui record degli oggetti cliente
            while (rs.next()) {
                UUID id = (UUID) rs.getObject("ID");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String email = rs.getString("email");
                String password = rs.getString("UserPassword");
                double bilancio = rs.getDouble("bilancio");
                String luogoNascita = rs.getString("luogoNascita");
                LocalDate dataNascita = (LocalDate) rs.getObject("dataNascita");
                String sesso = rs.getString("sesso");
                String cellulare = rs.getString("cellulare");
                String indirizzo = rs.getString("indirizzo");


                cliente = new Cliente(id, password, nome, cognome, luogoNascita, sesso, dataNascita, cellulare, indirizzo, bilancio, email);
                clienti.add(cliente);
            }
            //Database.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException("Errore durante il recupero dei dati: ", e);
        }
        return clienti;
    }

    @Override
    public void delete(Cliente cliente) {

        String sql = "DELETE FROM utente where ID=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getId().toString());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'eliminazione dati: ", e);
        }

    }

    @Override
    public void update(Cliente cliente) {
        String sql1 = "UPDATE utente set UserPassword=?, nome=?, cognome=?, luogoNascita=?, sesso=?, dataNascita=?, cellulare=?, indirizzo=? where ID=?";
        String sql2 = "UPDATE cliente set Bilancio=?, Email=? where IDCliente=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps1 = con.prepareStatement(sql1); PreparedStatement ps2 = con.prepareStatement(sql2)) {
            //Prima Query

            //Impostazione degli attributi

            ps1.setString(1, cliente.getUserPassword());
            ps1.setString(2, cliente.getNome());
            ps1.setString(3, cliente.getCognome());
            ps1.setString(4, cliente.getLuogoNascita());
            ps1.setString(5, cliente.getSesso());
            ps1.setObject(6, cliente.getDataNascita());
            ps1.setString(7, cliente.getCellulare());
            ps1.setString(8, cliente.getIndirizzo());
            ps1.setString(9, cliente.getId().toString());

            //Seconda Query
            ps2.setDouble(1, cliente.getBilancio());
            ps2.setString(2, cliente.getEmail());
            ps2.setString(3, cliente.getId().toString());

            ps1.executeUpdate();
            ps2.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'aggiornamento  dati: ", e);
        }

    }

    @Override
    public void insert(Cliente cliente) {
        String sql1 = "INSERT INTO utente (ID, UserPassword, Nome, Cognome, Sesso, LuogoNascita, DataNascita, Cellulare, Indirizzo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO cliente (IDCliente, Bilancio, Email) VALUES (?, ?, ?)";
        try (Connection con = Database.getConnection(); PreparedStatement ps1 = con.prepareStatement(sql1); PreparedStatement ps2 = con.prepareStatement(sql2)) {

            String hashedPassword = PasswordUtils.hashPassword(cliente.getUserPassword());

            // Impostazione dei parametri per la query 1
            ps1.setString(1, cliente.getId().toString());
            ps1.setString(2, hashedPassword);
            ps1.setString(3, cliente.getNome());
            ps1.setString(4, cliente.getCognome());
            ps1.setString(5, String.valueOf(cliente.getSesso()));
            ps1.setString(6, cliente.getLuogoNascita());
            ps1.setObject(7, cliente.getDataNascita()); // Assicurati che il driver JDBC supporti JDBC 4.2+
            ps1.setString(8, cliente.getCellulare());
            ps1.setString(9, cliente.getIndirizzo());

            // Impostazione dei parametri per la query 2
            ps2.setString(1, cliente.getId().toString());
            ps2.setDouble(2, cliente.getBilancio());
            ps2.setString(3, cliente.getEmail());

            // Esecuzione delle query
            ps1.executeUpdate();
            ps2.executeUpdate();

            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'inserimento dati", e);
        }


    }

    /*Metodi da valutare*/

    @Override
    public Cliente findById(String id) {

        String sql = "SELECT * FROM utente WHERE ID=?";
        Cliente cliente = null;


        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return cliente;
    }

    @Override
    public Cliente autenticateByEmail(Cliente credentials) {

        try {
            if (credentials != null && get(credentials)!=null) {
                System.out.println("Autenticato con successo");
                return get(credentials);
            }

        }catch (Exception e) {
           e.printStackTrace();

        }

        return null;

    }



    @Override
    public boolean updateBilancio (Cliente cliente) {

//        String sql0 = "SELECT Bilancio FROM cliente where IDCliente=?";
//        String sql = "UPDATE cliente set Bilancio=? where IDCliente=?";
//
//        try (Connection con2 = Database.getConnection(); PreparedStatement ps = con2.prepareStatement(sql0)) {
//            ps.setString(1, cliente.getId());
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                double bilancio = rs.getDouble("Bilancio");
//                //importo += bilancio;
//            }
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException("Errore durante l'estrazione dei dati: ", e);
//        }
//
//        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//          //  ps.setDouble(1, importo);
//           // ps.setString(2, IdCliente);
//            ps.executeUpdate();
//            //Database.closeConnection(con);
//            return true;
//        } catch (SQLException e) {
//            throw new RuntimeException("Errore durante l'aggiornamento password", e);
//        }
        return false;
    }

    @Override
    public boolean updatePassword (Cliente cliente) {

//        String hashedPassword = PasswordUtils.hashPassword(cliente.getUserPassword());
//        String sql = "UPDATE utente set UserPassword=? where ID=?";
//        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
//            //ps.setString(1, hashedPassword);
//            //ps.setString(2, id);
//            //Database.closeConnection(con);
//            return ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//            throw new RuntimeException("Errore durante l'aggiornamento della password", e);
//        }
        return false;
    }
}