package it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.TrenoDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Treno;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrenoDAOImpl implements TrenoDAO {
    @Override
    public Treno get(String id)  {
        Treno treno = null;
        PreparedStatement ps;
        try (Connection con = Database.getConnection()) {
            treno = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from treno where IDTreno=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String modello = rs.getString("modello");
                int kw = rs.getInt("KW");
                int numPosti = rs.getInt("numPosti");

                treno=new Treno(id, modello, kw,numPosti );
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treno;
    }

    @Override
    public List<Treno> getAll()  {

        Treno treno = null;
        List treni = new ArrayList<Treno>();
        PreparedStatement ps;
        try (Connection con = Database.getConnection()) {
            treno = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from treno";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            //ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                String idTreno = rs.getString("IDTreno");
                String modello = rs.getString("modello");
                int kw = rs.getInt("KW");
                int numPosti = rs.getInt("numPosti");

                treno=new Treno(idTreno, modello, kw,numPosti );
                treni.add(treno);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treni;
    }

    @Override
    public void delete(String id)  {

        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from treno where IDTreno=?");
            ps.setString(1,id);
            ps.executeUpdate();
            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Treno treno)  {

        String sql1="UPDATE treno set modello=?, kw=?, numposti=? where IDTreno=?";

        try(Connection con = Database.getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);

            //Impostazione degli attributi
            ps1.setString(1, treno.getModello());
            ps1.setInt(2, treno.getKw());
            ps1.setInt(3,treno.getNumPosti());
            ps1.setString(4,treno.getIdTreno());

            ps1.executeUpdate();

            //Chiusura della connessione col Database
            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insert(Treno treno) {
        Connection con = null;
        try {
            con = Database.getConnection();
            String sql1 = "INSERT INTO treno (IDTreno, modello, kw, numPosti) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1, treno.getIdTreno() );
                ps1.setObject(2, treno.getModello() );
                ps1.setInt(3, treno.getKw());
                ps1.setInt(4,  treno.getNumPosti());

                // Esecuzione delle query
                ps1.executeUpdate();
                Database.closeConnection(con);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
}
