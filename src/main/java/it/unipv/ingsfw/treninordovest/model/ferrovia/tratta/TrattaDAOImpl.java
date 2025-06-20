package it.unipv.ingsfw.treninordovest.model.ferrovia.tratta;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrattaDAOImpl implements TrattaDAO {

    @Override
    public Tratta get(Tratta tratta) {

      /* Tratta tratta = null;
       String sql = "select * from tratta where IDTratta=?";

        try (Connection con =Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            ps.setString(1,id);
            try (ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    String nome = rs.getString("Nome");
                    int lunghezza = rs.getInt("Lunghezza");

                    tratta=new Tratta(id,nome,lunghezza );
                }
            }


            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'acquisizione dati",e);
        }
        return tratta;


       */
        return null;
    }

    @Override
    public List<Tratta> getAll()  {

        Tratta tratta = null;
        List<Tratta> tratte = new ArrayList<>();
        String sql = "select IDTratta,Nome,Lunghezza from tratta";

        try (Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {

            while (rs.next()){
                String idTratta = rs.getString("IDTratta");
                String nome = rs.getString("Nome");
                int lunghezza = rs.getInt("Lunghezza");


                tratta=new Tratta (idTratta,nome,lunghezza );
                tratte.add(tratta);
            }
            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'acquisizione dati",e);
        }

        return tratte;

    }

    @Override
    public void delete(Tratta tratta)  {
        /*

        String sql1="DELETE FROM tratta WHERE IDTratta=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql1)){
            ps.setString(1,id);
            ps.executeUpdate();
            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public void update(Tratta tratta) {
        /*
        String sql1="UPDATE Tratta set nome=?, lunghezza=? where idTratta=?=?";

        try(Connection con = Database.getConnection();PreparedStatement ps1= con.prepareStatement(sql1)){

            ps1.setString(1,tratta.getNome());
            ps1.setInt(2,tratta.getLunghezza());
            ps1.setString(3,tratta.getIdTratta());

            ps1.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

         */
    }

    @Override
    public void insert(Tratta tratta) {

        try (Connection con =Database.getConnection() ){

            String sql1 = "INSERT INTO tratta (idTratta, nome, lunghezza) VALUES (?, ?, ?)";

            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1,tratta.getIdTratta());
                ps1.setString(2,tratta.getNome());
                ps1.setInt(3,tratta.getLunghezza());

                // Esecuzione delle query
                ps1.executeUpdate();

               // Database.closeConnection(con);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

