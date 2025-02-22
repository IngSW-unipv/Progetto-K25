package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.PagamentoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAOImpl implements PagamentoDAO {
    @Override
    public Pagamento get(String id) throws SQLException {
        Pagamento pagamento = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            pagamento = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select idPagamento,totale,idCliente,Tipo,dataPagamento from Pagamento where idPagamento=?";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();


            if(rs.next()){
                String idPagamento=rs.getString("idPagamento");
                double totale=rs.getDouble("totale");
                String idCliente=rs.getString("idCliente");
                String tipo=rs.getString("tipo");
                LocalDate dataPagamento= (LocalDate) rs.getObject("dataPagamento");

                pagamento=new Pagamento(idPagamento,idCliente,totale,idTitolo, tipo, dataPagamento);
            }

            Database.closeConnection(con);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagamento;
    }

    @Override
    public List<Pagamento> getAll() throws SQLException {
        List<Pagamento> paga= new ArrayList<Pagamento>();

        //Avvio della connessione col DB
        PreparedStatement ps;
        Pagamento pagamento = null;
        try (Connection con = new Database().getConnection()) {

            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select idPagamento,idCliente,totale,idTitolo, tipo, dataPagamento from Pagamento";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);

            //ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                String idPagamento=rs.getString("idPagamento");
                String idCliente=rs.getString("idCliente");
                double totale=rs.getDouble("totale");
                String tipo=rs.getString("tipo");
                LocalDate dataPagamento=(LocalDate) rs.getObject("dataPagamento");


                pagamento=new Pagamento(idPagamento,idCliente,totale, tipo, dataPagamento);
                paga.add(pagamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paga;
    }



    @Override
    public void delete(String idPagamento) throws SQLException {
        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Pagamento where idPagamento=?");
            ps.setString(1,idPagamento);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(Pagamento pagamento) throws SQLException {
        String sql1="UPDATE pagamento set idPagamento=?, idCliente=?,totale=?,idTitolo=?, tipo=?, dataPagamento=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            ps1.setString(1,pagamento.getIdPagamento());
            ps1.setString(2,pagamento.getIdCliente());
            ps1.setDouble(3,pagamento.getTotale());
            ps1.setString(4,pagamento.getIdTitolo());
            ps1.setString(5,pagamento.getTipo());
            ps1.setObject(6,pagamento.getDataPagamento());

            ps1.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(Pagamento pagamento) throws SQLException {
        
        Connection con = null;

        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO pagamento (idPagamento,idCliente,totale, tipo, dataPagamento) VALUES (?, ?, ?, ?, ?, ?)";

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
}
