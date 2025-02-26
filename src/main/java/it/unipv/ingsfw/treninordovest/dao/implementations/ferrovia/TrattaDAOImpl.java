package it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.TrattaDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrattaDAOImpl implements TrattaDAO {
    @Override
    public Tratta get(String id) throws SQLException {

       Tratta tratta = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            tratta = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from tratta where IDTratta=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String nome = rs.getString("Nome");
                int lunghezza = rs.getInt("Lunghezza");

                tratta=new Tratta(id,nome,lunghezza );
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratta;


    }

    @Override
    public List<Tratta> getAll() throws SQLException {

        Tratta tratta = null;
        List tratte = new ArrayList<Tratta>();
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            tratta = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from tratta";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            //ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                String idTratta = rs.getString("IDTratta");
                String nome = rs.getString("Nome");
                int lunghezza = rs.getInt("Lunghezza");


                tratta=new Tratta (idTratta,nome,lunghezza );
                tratte.add(tratta);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tratte;

    }

    @Override
    public void delete(String id) throws SQLException {
        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Tratta where idTratta=?");
            ps.setString(1,id);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Tratta tratta) throws SQLException {
        String sql1="UPDATE Tratta set nome=?, lunghezza=? where idTratta=?=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            ps1.setString(1,tratta.getNome());
            ps1.setInt(2,tratta.getLunghezza());
            ps1.setString(3,tratta.getIdTratta());

            ps1.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Tratta tratta) throws SQLException {
        Connection con = null;
        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO tratta (idTratta, nome, lunghezza) VALUES (?, ?, ?)";

            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1,tratta.getIdTratta());
                ps1.setString(2,tratta.getNome());
                ps1.setInt(3,tratta.getLunghezza());

                // Esecuzione delle query
                ps1.executeUpdate();

                Database.closeConnection(con);
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

