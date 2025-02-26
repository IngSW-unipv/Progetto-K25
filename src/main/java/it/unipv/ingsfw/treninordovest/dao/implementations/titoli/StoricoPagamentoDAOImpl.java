package it.unipv.ingsfw.treninordovest.dao.implementations.titoli;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.StoricoPagamentoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.StoricoPagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoricoPagamentoDAOImpl implements StoricoPagamentoDAO {
    @Override
    public StoricoPagamento get(String id) throws SQLException {
        StoricoPagamento storicoPagamento = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            storicoPagamento = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select idStorico,idPagamento,Stato from StoricoPagamento where idStorico=?";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();


            if(rs.next()){
                String idStorico=rs.getString("idStorico");
                String idPagamento=rs.getString("idPagamento");
                String stato=rs.getString("stato");

                storicoPagamento=new StoricoPagamento(idStorico,idPagamento,stato);
            }

            Database.closeConnection(con);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storicoPagamento;
    }

    @Override
    public List<StoricoPagamento> getAll() throws SQLException {
        List<StoricoPagamento> storicopaga= new ArrayList<StoricoPagamento>();

        //Avvio della connessione col DB
        PreparedStatement ps;
        StoricoPagamento storicoPagamento = null;
        try (Connection con = new Database().getConnection()) {

            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select idStorico,idPagamento,Stato from StoricoPagamento from StoricoPagamento";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);

            //ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                String idStorico=rs.getString("idStorico");
                String idPagamento=rs.getString("idPagamento");
                String stato=rs.getString("stato");

                storicoPagamento=new StoricoPagamento(idStorico,idPagamento,stato);
                storicopaga.add(storicoPagamento);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storicopaga;
    }


    @Override
    public void delete(String idStorico) throws SQLException {
        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from StoricoPagamento where idStorico=?");
            ps.setString(1,idStorico);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(StoricoPagamento storicoPagamento) throws SQLException {
        String sql1="UPDATE StoricoPagamento set idPagamento=?, Stato=? where idStorico=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            ps1.setString(3,storicoPagamento.getIdStorico());
            ps1.setString(1,storicoPagamento.getIdPagamento());
            ps1.setString(2,storicoPagamento.getStatoPagamento());

            ps1.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(StoricoPagamento storicoPagamento) throws SQLException {
        
        Connection con = null;

        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO storicoPagamento (idStorico,idPagamento,stato) VALUES (?, ?, ?)";

            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1,storicoPagamento.getIdStorico());
                ps1.setString(2,storicoPagamento.getIdPagamento());
                ps1.setString(3,storicoPagamento.getStatoPagamento());


                // Esecuzione delle query
                ps1.executeUpdate();

                //Database.closeConnection(con);
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
