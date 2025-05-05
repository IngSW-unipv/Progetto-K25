package it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.TrenoDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Treno;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrenoDAOImpl implements TrenoDAO {
    @Override
    public Treno get(String id)  {
        Treno treno = null;
        String sql = "select * from treno where IDTreno=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {

            ps.setString(1,id);

            if(rs.next()){
                String modello = rs.getString("modello");
                int kw = rs.getInt("KW");
                int numPosti = rs.getInt("numPosti");

                treno=new Treno(id, modello, kw,numPosti );
            }
            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'acquisizione dati",e);
        }
        return treno;
    }

    @Override
    public List<Treno> getAll()  {

        Treno treno;
        List<Treno> treni = new ArrayList<>();
        PreparedStatement ps;
        try (Connection con = Database.getConnection()) {
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
          throw new RuntimeException("Errore nell'acquisizione dati",e);
        }

        return treni;
    }

    @Override
    public void delete(String id)  {

        String sql1="DELETE FROM treno WHERE IDTreno=?";

        try(Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql1)){

            ps.setString(1,id);
            ps.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'eliminazione dati",e);
        }

    }

    @Override
    public void update(Treno treno)  {

        String sql1="UPDATE treno set modello=?, kw=?, numposti=? where IDTreno=?";

        try(Connection con = Database.getConnection();PreparedStatement ps1= con.prepareStatement(sql1)){
            //Prima Query

            //Impostazione degli attributi
            ps1.setString(1, treno.getModello());
            ps1.setInt(2, treno.getKw());
            ps1.setInt(3,treno.getNumPosti());
            ps1.setString(4,treno.getIdTreno());

            ps1.executeUpdate();

            //Chiusura della connessione
           // Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insert(Treno treno) {

        String sql1 = "INSERT INTO treno (IDTreno, modello, kw, numPosti) VALUES (?, ?, ?, ?)";


            try (Connection con = Database.getConnection(); PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1, treno.getIdTreno() );
                ps1.setObject(2, treno.getModello() );
                ps1.setInt(3, treno.getKw());
                ps1.setInt(4,  treno.getNumPosti());

                // Esecuzione delle query
                ps1.executeUpdate();
                Database.closeConnection(con);

            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }




    }
}
