package it.unipv.ingsfw.treninordovest.dao.implementations.utenti;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.DipendenteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Dipendente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DipendenteDAOImpl implements DipendenteDAO {

    public DipendenteDAOImpl() {
    }

    @Override
    public Dipendente get(String id) throws SQLException {
        //Dipendenti
        Dipendente dipendente = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            String sql = "select * from utentiDipendenti where id=?";

            //Preparazione della Query
            ps = null;
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            //Impostazione di estrapolazione query
            if(rs.next()){
                String nome=rs.getString("nome");
                String cognome=rs.getString("cognome");
                String email=rs.getString("email");
                String password=rs.getString("UserPassword");
                double stipendio=rs.getDouble("stipendio");
                String luogoNascita=rs.getString("luogoNascita");
                LocalDate dataNascita= (LocalDate) rs.getObject("dataNascita");
                String sesso=rs.getString("sesso");
                String cellulare=rs.getString("cellulare");
                String indirizzo=rs.getString("indirizzo");
                String codTreno=rs.getString("codTreno");
                String ruolo =rs.getString("ruolo");

               dipendente=new Dipendente(id,password,nome,cognome,luogoNascita, sesso, dataNascita,cellulare,indirizzo,codTreno,stipendio,ruolo);
            }

            //Chiusura connesione
            Database.closeConnection(con);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return dipendente;
    }

    @Override
    public List<Dipendente> getAll() throws SQLException {

        //Variabili
        List<Dipendente> clienti = new ArrayList<Dipendente>();

        //Avvio della connessione col DB
        PreparedStatement ps;
        Dipendente dipendente = null;
        try (Connection con = new Database().getConnection()) {

            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select ID,nome,cognome,email,Userpassword,luogoNascita,dataNascita,sesso,cellulare,indirizzo,sesso,stipendio,ruolo,codTreno from utentiDipendenti";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);

            //ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                String id=rs.getString("ID");
                String nome=rs.getString("nome");
                String cognome=rs.getString("cognome");
                String password=rs.getString("UserPassword");
                String luogoNascita=rs.getString("luogoNascita");
                LocalDate dataNascita= (LocalDate) rs.getObject("dataNascita");
                String sesso=rs.getString("sesso");
                String cellulare=rs.getString("cellulare");
                String indirizzo=rs.getString("indirizzo");
                double stipendio=rs.getDouble("stipendio");
                String ruolo=rs.getString("ruolo");
                String codTreno=rs.getString("codTreno");

                dipendente=new Dipendente(id,password,nome,cognome,luogoNascita, sesso, dataNascita,cellulare,indirizzo,codTreno,stipendio,ruolo);
                clienti.add(dipendente);
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
    public void update(Dipendente dipendente) throws SQLException {
        String sql1="UPDATE utente set password=?, nome=?, cognome=?, luogoNascita=?, sessoChar=?, dataNascita=?, cellulare=?, indirizzo=? where ID=?";
        String sql2="UPDATE dipendente set codTreno=?, stipendio=?, ruolo=? where IdDipendente=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            PreparedStatement ps2= con.prepareStatement(sql2);

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

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(Dipendente dipendente) throws SQLException {
        Connection con = null;
        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO utente (ID, UserPassword, Nome, Cognome, Sesso, LuogoNascita, DataNascita, Cellulare, Indirizzo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String sql2 = "INSERT INTO dipendente (IDDipendente, Stipendio,Ruolo,CodTreno) VALUES (?, ?, ?,?)";

            try (PreparedStatement ps1 = con.prepareStatement(sql1);
                 PreparedStatement ps2 = con.prepareStatement(sql2)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1, dipendente.getId());
                ps1.setString(2, dipendente.getUserPassword());
                ps1.setString(3, dipendente.getNome());
                ps1.setString(4,dipendente.getCognome());
                ps1.setString(5, (dipendente.getSesso()));
                ps1.setString(6, dipendente.getLuogoNascita());
                ps1.setObject(7, dipendente.getDataNascita()); // Assicurati che il driver JDBC supporti JDBC 4.2+
                ps1.setString(8,dipendente.getCellulare());
                ps1.setString(9,dipendente.getIndirizzo());

                // Impostazione dei parametri per la query 2
                ps2.setString(1, dipendente.getId());
                ps2.setDouble(2, dipendente.getStipendio());
                ps2.setString(3, dipendente.getRuolo());
                ps2.setString(4, dipendente.getCodTreno());

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

    @Override
    public Dipendente autenticate(String id, String password) throws SQLException {
       Dipendente dipendente = get(id);
        if(dipendente.getUserPassword().equals(password) && dipendente!=null){
            return dipendente;
        }
        return null;
    }
}
