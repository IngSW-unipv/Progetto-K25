package it.unipv.ingsfw.treninordovest.dao.implementations.utenti;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.utils.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/*Classe che implementa l'interfaccia DAO derivata specifica di ogni entità, con essa si rispetta il CRUD per estrapolare dati dal DB */


public class ClienteDAOImpl implements ClienteDAO {

    public ClienteDAOImpl() {
    }

    @Override
    public Cliente get(String id) {

        String sql = "select ID,nome,cognome,email,Userpassword,bilancio,luogoNascita,dataNascita,sesso,cellulare,indirizzo,sesso from utentiClienti where id=?";
        Cliente cliente = null;

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1,id);

            try (ResultSet rs=ps.executeQuery()){


                if(rs.next()){
                    String nome=rs.getString("nome");
                    String cognome=rs.getString("cognome");
                    String email=rs.getString("email");
                    String password=rs.getString("UserPassword");
                    double bilancio=rs.getDouble("bilancio");
                    String luogoNascita=rs.getString("luogoNascita");

                    Date dataNascita= rs.getDate("dataNascita");
                    LocalDate dataNascitaLocal = dataNascita.toLocalDate();

                    String sesso=rs.getString("sesso");
                    String cellulare=rs.getString("cellulare");
                    String indirizzo=rs.getString("indirizzo");


                    cliente =new Cliente(id,password,nome,cognome,luogoNascita, sesso, dataNascitaLocal ,cellulare,indirizzo,bilancio,email);
                }

            }



        } catch (SQLException e) {
            throw new RuntimeException( "Errore durante il recupero dei dati: ",e);
        }

        return cliente;
    }

    @Override
    public List<Cliente> getAll() {

        List<Cliente> clienti = new ArrayList<>();
        String sql = "select ID,nome,cognome,email,Userpassword,bilancio,luogoNascita,dataNascita,sesso,cellulare,indirizzo,sesso from utentiClienti";
        Cliente cliente ;

        try (Connection con = Database.getConnection();  PreparedStatement ps= con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {

         //Itera sui record degli oggetti cliente
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
            //Database.closeConnection(con);
        } catch (SQLException e) {
           throw new RuntimeException( "Errore durante il recupero dei dati: ",e);
        }
        return clienti;
    }
    @Override
    public void delete(String id)  {

        String sql = "DELETE FROM utente where ID=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'eliminazione dati: ",e);
        }

    }

    @Override
    public void update(Cliente cliente)  {
        String sql1="UPDATE utente set UserPassword=?, nome=?, cognome=?, luogoNascita=?, sesso=?, dataNascita=?, cellulare=?, indirizzo=? where ID=?";
        String sql2="UPDATE cliente set Bilancio=?, Email=? where IDCliente=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps1= con.prepareStatement(sql1); PreparedStatement ps2= con.prepareStatement(sql2)){
            //Prima Query

            //Impostazione degli attributi

            ps1.setString(1,cliente.getUserPassword());
            ps1.setString(2,cliente.getNome());
            ps1.setString(3,cliente.getCognome());
            ps1.setString(4,cliente.getLuogoNascita());
            ps1.setString(5,cliente.getSesso());
            ps1.setObject(6,cliente.getDataNascita());
            ps1.setString(7,cliente.getCellulare());
            ps1.setString(8,cliente.getIndirizzo());
            ps1.setString(9,cliente.getId());

            //Seconda Query
            ps2.setDouble(1,cliente.getBilancio());
            ps2.setString(2,cliente.getEmail());
            ps2.setString(3,cliente.getId());

            ps1.executeUpdate();
            ps2.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'aggiornamento  dati: ",e);
        }

    }

    @Override
    public void insert(Cliente cliente)  {
        String sql1 = "INSERT INTO utente (ID, UserPassword, Nome, Cognome, Sesso, LuogoNascita, DataNascita, Cellulare, Indirizzo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO cliente (IDCliente, Bilancio, Email) VALUES (?, ?, ?)";
        try (Connection con = Database.getConnection();PreparedStatement ps1 = con.prepareStatement(sql1); PreparedStatement ps2 = con.prepareStatement(sql2)){

            String hashedPassword = PasswordUtils.hashPassword(cliente.getUserPassword());

            // Impostazione dei parametri per la query 1
                ps1.setString(1, cliente.getId());
                ps1.setString(2, hashedPassword);
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

                //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'inserimento dati",e);
        }


    }

    /*Metodi da valutare*/

    @Override
    public Cliente autenticate(String id, String password) {
        System.out.println("Tentativo di autenticazione per id: " + id);
        
        Cliente cliente = get(id);
        if (cliente == null) {
            System.out.println("Cliente non trovato nel database");
            return null;
        }
        
        System.out.println("Cliente trovato. Verifica password...");
        System.out.println("Password inserita: [lunghezza: " + password.length() + "]");
        System.out.println("Password hash nel DB: " + cliente.getUserPassword());
        
        boolean passwordValida = PasswordUtils.verifyPassword(password, cliente.getUserPassword());
        System.out.println("Risultato verifica password: " + passwordValida);
        
        if (passwordValida) {
            System.out.println("Autenticazione riuscita");
            return cliente;
        } else {
            System.out.println("Password non valida");
            return null;
        }
    }

    @Override
    public boolean updateBilancio(String IdCliente, double bilancio) {

        String sql = "UPDATE cliente set Bilancio=? where IDCliente=?";
        Connection con ;
        try {
            con= Database.getConnection();
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDouble(1, bilancio);
                ps.setString(2, IdCliente);
                ps.executeUpdate();
                Database.closeConnection(con);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePassword(String id, String password) {

        String hashedPassword = PasswordUtils.hashPassword(password);
        String sql = "UPDATE utente set UserPassword=? where ID=?";
        try (Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql);){
                ps.setString(1, hashedPassword);
                ps.setString(2, id);
                //Database.closeConnection(con);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'aggiornamento della password",e);
        }


    }
}