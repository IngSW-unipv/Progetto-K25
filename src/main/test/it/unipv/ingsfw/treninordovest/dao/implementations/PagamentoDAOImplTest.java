package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.StoricoPagamento;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

class PagamentoDAOImplTest {

    @Test
    void insert() throws SQLException {


        LocalDate date = LocalDate.now();
        Pagamento pagamento = new Pagamento("PG2583","CL32",200,"carta",date);

        Connection con = null;
        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO pagamento (idPagamento,idCliente,totale, tipo, dataPagamento) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1,pagamento.getIdPagamento());
                ps1.setString(2,pagamento.getIdCliente());
                ps1.setDouble(3,pagamento.getTotale());
                ps1.setString(4,pagamento.getTipo());
                ps1.setObject(5,pagamento.getDataPagamento());
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


    @Test
    void update() throws SQLException {

        /*
        LocalDate date = LocalDate.now();
        StoricoPagamento pagamento = new StoricoPagamento("PG2283","US0013",200,"paypal",date);
        String sql1="UPDATE pagamento set idCliente=?,totale=?, tipo=?, dataPagamento=? where idPagamento=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);

            ps1.setString(1,pagamento.getIdCliente());
            ps1.setDouble(2,pagamento.getTotale());
            ps1.setString(3,pagamento.getTipo());
            ps1.setObject(4,pagamento.getDataPagamento());
            ps1.setString(5,pagamento.getIdPagamento());

            ps1.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

    }
    
    
    @Test
     void delete() throws SQLException {

        String id = "PG2583";
        try{
            Connection con = new Database().getConnection();
            PreparedStatement ps = con.prepareStatement("delete from pagamento where IDPagamento=?");
            ps.setString(1,id);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    
    
}









