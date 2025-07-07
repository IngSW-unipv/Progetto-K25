package it.unipv.ingsfw.treninordovest.model.utenti.dipendente;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.ferrovia.treno.Treno;
import it.unipv.ingsfw.treninordovest.model.utils.PasswordUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DipendenteDAOImpl implements DipendenteDAO {

    public DipendenteDAOImpl() {
    }


    @Override
    public Dipendente get(Dipendente dipendente){
        //Dipendenti
        String sql = "select ID,Userpassword,Nome,Cognome,Sesso,LuogoNascita,DataNascita,Cellulare,Indirizzo,Stipendio,Ruolo from utentiDipendenti where id=?";
        try (Connection con = Database.getConnection(); PreparedStatement ps= con.prepareStatement(sql)) {
            //Preparazione della Query
            ps.setString(1,dipendente.getId().toString());
            //Impostazione di estrapolazione query

            try (ResultSet rs=ps.executeQuery()) {
                if(rs.next()){
                    String nome=rs.getString("nome");
                    String cognome=rs.getString("cognome");
                    String password=rs.getString("UserPassword");
                    double stipendio=rs.getDouble("stipendio");
                    String luogoNascita=rs.getString("luogoNascita");

                    Date dataNascita= rs.getDate("dataNascita");
                    LocalDate dataNascitaLocal = dataNascita.toLocalDate();

                    String sesso=rs.getString("sesso");
                    String cellulare=rs.getString("cellulare");
                    String indirizzo=rs.getString("indirizzo");
                    String ruolo =rs.getString("ruolo");

                    dipendente=new Dipendente(dipendente.getId(),password,nome,cognome,luogoNascita, sesso, dataNascitaLocal,cellulare,indirizzo,stipendio,ruolo);

            }


            }

            //Chiusura connesione
            //Database.closeConnection(con);
        }catch(SQLException e){
            throw new RuntimeException("Errore durante l'estrazione dei dati: ",e);
        }

        return dipendente;
    }

    @Override
    public List<Dipendente> getAll()  {

        String sql = "select ID,nome,cognome,Userpassword,luogoNascita,dataNascita,sesso,cellulare,indirizzo,sesso,stipendio,ruolo,codTreno from utentiDipendenti";
        //Variabili
        List<Dipendente> dipendenti = new ArrayList<>();

        //Avvio della connessione col DB
        Dipendente dipendente ;
        try (Connection con = Database.getConnection(); PreparedStatement ps= con.prepareStatement(sql)) {


            //ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                UUID id=(UUID) rs.getObject("ID");
                String nome=rs.getString("nome");
                String cognome=rs.getString("cognome");
                String password=rs.getString("UserPassword");
                String luogoNascita=rs.getString("luogoNascita");

                Date dataNascita= rs.getDate("dataNascita");
                LocalDate dataNascitaLocal = dataNascita.toLocalDate();

                String sesso=rs.getString("sesso");
                String cellulare=rs.getString("cellulare");
                String indirizzo=rs.getString("indirizzo");
                double stipendio=rs.getDouble("stipendio");
                String ruolo=rs.getString("ruolo");
                String codTreno=rs.getString("codTreno");

                dipendente=new Dipendente(id,password,nome,cognome,luogoNascita, sesso, dataNascitaLocal,cellulare,indirizzo,stipendio,ruolo);
                dipendenti.add(dipendente);
            }

            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'estrazione dei dati: ",e);
        }
        return dipendenti;
    }


    @Override
    public void delete(Dipendente dipendente) {
       /* String sql = "DELETE FROM utente where ID=?";
        try(Connection con =Database.getConnection();PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,id);
            ps.executeUpdate();
            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'eliminazione dati: ",e);
        }
        */

    }

    @Override
    public void update(Dipendente dipendente) {
/*        String sql1="UPDATE utente set UserPassword=?, nome=?, cognome=?, luogoNascita=?, sesso=?, dataNascita=?, cellulare=?, indirizzo=? where ID=?";
        String sql2="UPDATE dipendente set codTreno=?, stipendio=?, ruolo=? where IdDipendente=?";

        try(Connection con = Database.getConnection();PreparedStatement ps1= con.prepareStatement(sql1); PreparedStatement ps2= con.prepareStatement(sql2)){
            //Prima Query
            ps1.setString(1,dipendente.getUserPassword());
            ps1.setString(2,dipendente.getNome());
            ps1.setString(3,dipendente.getCognome());
            ps1.setString(4,dipendente.getLuogoNascita());
            ps1.setString(5,dipendente.getSesso());
            ps1.setObject(6, dipendente.getDataNascita());
            ps1.setString(7,dipendente.getCellulare());
            ps1.setString(8,dipendente.getIndirizzo());
            ps1.setString(9,dipendente.getId());

            //Seconda Query
            ps2.setString(1,dipendente.getCodTreno());
            ps2.setDouble(2,dipendente.getStipendio());
            ps2.setString(3,dipendente.getRuolo());
            ps2.setString(4,dipendente.getId());

            ps1.executeUpdate();
            ps2.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
           throw new RuntimeException("Errore durante l'aggiornamento dati: ",e);
        }
*/
    }

    @Override
    public void insert(Dipendente dipendente) {
        String sql1 = "INSERT INTO utente (ID,UserPassword,Nome,Cognome, LuogoNascita,Sesso, DataNascita, Cellulare, Indirizzo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO dipendente (IDDipendente, Stipendio,Ruolo,CodTreno) VALUES (?, ?, ?,?)";

            try (Connection con = Database.getConnection() ;PreparedStatement ps1 = con.prepareStatement(sql1); PreparedStatement ps2 = con.prepareStatement(sql2)) {

                String hashedPassword = PasswordUtils.hashPassword(dipendente.getUserPassword());
                // Impostazione dei parametri per la query 1
                ps1.setString(1, dipendente.getId().toString());
                ps1.setString(2, hashedPassword);
                ps1.setString(3, dipendente.getNome());
                ps1.setString(4,dipendente.getCognome());
                ps1.setString(5, dipendente.getSesso());
                ps1.setString(6, dipendente.getLuogoNascita());
                ps1.setObject(7, dipendente.getDataNascita()); // Assicurati che il driver JDBC supporti JDBC 4.2+
                ps1.setString(8,dipendente.getCellulare());
                ps1.setString(9,dipendente.getIndirizzo());

                // Impostazione dei parametri per la query 2
                ps2.setString(1, dipendente.getId().toString());
                ps2.setDouble(2, dipendente.getStipendio());
                ps2.setString(3, dipendente.getRuolo());
                ps2.setString(4, Treno.getRandomTreno());

                // Esecuzione delle query
                ps1.executeUpdate();
                ps2.executeUpdate();

                //Database.closeConnection(con);
            }
        catch (SQLException e) {
            throw new RuntimeException("Errore durante l'inserimento dati: ",e);


        }

    }

    @Override
    public Dipendente autenticate(Dipendente dipendente)  {

        Dipendente autenticate = null;

        String sql = "select ID,Userpassword,Nome,Cognome,Sesso,LuogoNascita,DataNascita,Cellulare,Indirizzo,Stipendio,Ruolo from utentiDipendenti where id=?";
        try (Connection con = Database.getConnection(); PreparedStatement ps= con.prepareStatement(sql)) {
            //Preparazione della Query
            ps.setString(1,dipendente.getId().toString());
            //Impostazione di estrapolazione query

            try (ResultSet rs=ps.executeQuery()) {

                if(rs.next()){
                    String storePassword=rs.getString("UserPassword");
                    if (PasswordUtils.verifyPassword(dipendente.getUserPassword(), storePassword)){
                        String nome=rs.getString("nome");
                        String cognome=rs.getString("cognome");

                        double stipendio=rs.getDouble("stipendio");
                        String luogoNascita=rs.getString("luogoNascita");

                        Date dataNascita= rs.getDate("dataNascita");
                        LocalDate dataNascitaLocal = dataNascita.toLocalDate();

                        String sesso=rs.getString("sesso");
                        String cellulare=rs.getString("cellulare");
                        String indirizzo=rs.getString("indirizzo");
                        String ruolo =rs.getString("ruolo");

                        autenticate=new Dipendente(dipendente.getId(),storePassword,nome,cognome,luogoNascita, sesso, dataNascitaLocal,cellulare,indirizzo,stipendio,ruolo);


                    }

                }


            }

            //Chiusura connesione
            //Database.closeConnection(con);
        }catch(SQLException e){
            throw new RuntimeException("Errore durante l'estrazione dei dati: ",e);
        }

        return autenticate;

    }

    @Override
    public boolean updatePassword(Dipendente dipendente) {

        String sql = "UPDATE utente set UserPassword=? where ID=?";
        String hashedPassword = PasswordUtils.hashPassword(dipendente.getUserPassword());

        try (Connection con= Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, hashedPassword);
                ps.setString(2, dipendente.getId().toString());
                ps.executeUpdate();
               // Database.closeConnection(con);
                System.out.println("Password aggiornata con successo");
                return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'aggiornamento della password",e);
        }

    }
}
