package it.unipv.ingsfw.treninordovest.model.titoli.storicopagamento;

import it.unipv.ingsfw.treninordovest.dao.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoricoPagamentoDAOImpl implements StoricoPagamentoDAO {

    @Override
    public StoricoPagamento get(StoricoPagamento storicoPagamento) {

        String sql = "select idStorico,idPagamento,Stato from StoricoPagamento where idStorico=?";
        try (Connection con = Database.getConnection();PreparedStatement ps= con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {


            ps.setString(1,storicoPagamento.getIdStorico());
            if(rs.next()){
                String idStorico=rs.getString("idStorico");
                String idPagamento=rs.getString("idPagamento");
                String stato=rs.getString("stato");

                storicoPagamento=new StoricoPagamento(idStorico,idPagamento,stato);
            }

            Database.closeConnection(con);


        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'acquisizione dati",e);
        }
        return storicoPagamento;
    }

    @Override
    public List<StoricoPagamento> getAll() {
        List<StoricoPagamento> storicopaga= new ArrayList<>();
        String sql = "select idStorico,idPagamento,Stato from StoricoPagamento ";

        //Avvio della connessione col DB
        StoricoPagamento storicoPagamento ;
        try (Connection con = Database.getConnection(); PreparedStatement ps= con.prepareStatement(sql);  ResultSet rs=ps.executeQuery() ) {

            while(rs.next()){
                String idStorico=rs.getString("idStorico");
                String idPagamento=rs.getString("idPagamento");
                String stato=rs.getString("stato");

                storicoPagamento=new StoricoPagamento(idStorico,idPagamento,stato);
                storicopaga.add(storicoPagamento);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return storicopaga;
    }

    @Override
    public void delete(StoricoPagamento storicoPagamento) {

    }


    @Override
    public void delete(String idStorico) {

        String sql="DELETE FROM StoricoPagamento where idStorico=?";

        try(Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,idStorico);

            ps.executeUpdate();

            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'eliminazione dati",e);
        }
    }


    @Override
    public void update(StoricoPagamento storicoPagamento) {
        String sql1="UPDATE StoricoPagamento set idPagamento=?, Stato=? where idStorico=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps1= con.prepareStatement(sql1)){
            //Prima Query

            ps1.setString(3,storicoPagamento.getIdStorico());
            ps1.setString(1,storicoPagamento.getIdPagamento());
            ps1.setString(2,storicoPagamento.getStatoPagamento());

            ps1.executeUpdate();

            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(StoricoPagamento storicoPagamento)  {

            String sql1 = "INSERT INTO storicoPagamento (idStorico,idPagamento,stato) VALUES (?, ?, ?)";

            try (Connection con = Database.getConnection();PreparedStatement ps1 = con.prepareStatement(sql1)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1,storicoPagamento.getIdStorico());
                ps1.setString(2,storicoPagamento.getIdPagamento());
                ps1.setString(3,storicoPagamento.getStatoPagamento());

                // Esecuzione delle query
                ps1.executeUpdate();
                //Database.closeConnection(con);
            }
         catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
