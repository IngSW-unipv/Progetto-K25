package it.unipv.ingsfw.treninordovest.model.titoli.pagamento;

import it.unipv.ingsfw.treninordovest.dao.database.Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAOImpl implements PagamentoDAO {
    @Override
    public Pagamento get(Pagamento pagamento) {
        String sql = "select idPagamento,totale,idCliente,Tipo,dataPagamento from Pagamento where idPagamento=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps= con.prepareStatement(sql)) {

            //Estrazione dei dati dal DB
            ps.setString(1, pagamento.getIdPagamento());
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String idPagamento=rs.getString("idPagamento");
                double totale=rs.getDouble("totale");
                String tipo=rs.getString("tipo");
                LocalDate dataPagamento= (LocalDate) rs.getObject("dataPagamento");

                pagamento=new Pagamento(idPagamento,totale, tipo, dataPagamento);
            }

            Database.closeConnection(con);


        } catch (SQLException e) {
           throw new RuntimeException("Errore durante l'acquisizione dati",e);
        }
        return pagamento;
    }

    @Override
    public List<Pagamento> getAll() {

        List<Pagamento> paga= new ArrayList<>();
        String sql = "select idPagamento,idCliente,totale, tipo, dataPagamento from Pagamento";
        Pagamento pagamento ;


        try (Connection con = Database.getConnection(); PreparedStatement ps= con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {

            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            while(rs.next()){
                String idPagamento=rs.getString("idPagamento");
                double totale=rs.getDouble("totale");
                String tipo=rs.getString("tipo");
                LocalDate dataPagamento=(LocalDate) rs.getObject("dataPagamento");


                pagamento=new Pagamento(idPagamento,totale, tipo, dataPagamento);
                paga.add(pagamento);
            }
            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'acquisizione dati",e);
        }
        return paga;
    }


    @Override
    public void delete(Pagamento pagamento) {

        String sql1="DELETE FROM pagamento WHERE idPagamento=?";

        try(Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql1)){

            ps.setString(1,pagamento.getIdPagamento());

            ps.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'eliminazione dati",e);
        }
    }


    @Override
    public void update(Pagamento pagamento) {
        String sql1="UPDATE pagamento set idCliente=?,totale=?, tipo=?, dataPagamento=? where idPagamento=?";

        try(Connection con = Database.getConnection();PreparedStatement ps1= con.prepareStatement(sql1)){
            //Prima Query
            //ps1.setString(1,pagamento.getIdCliente());
            ps1.setDouble(2,pagamento.getTotale());
            ps1.setString(3,pagamento.getTipo());
            ps1.setObject(4,pagamento.getDataPagamento());
            ps1.setString(5,pagamento.getIdPagamento());

            ps1.executeUpdate();

            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'aggiornamento dati",e);
        }

    }


    public void insert(Pagamento pagamento) {
        String sql1 = "INSERT INTO pagamento (idPagamento,idCliente,totale, tipo, dataPagamento) VALUES (?, ?, ?, ?, ?)";

        try ( Connection con = Database.getConnection();PreparedStatement ps1 = con.prepareStatement(sql1)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1,pagamento.getIdPagamento());
                ps1.setString(2,null);
                ps1.setDouble(3,pagamento.getTotale());
                ps1.setString(4,pagamento.getTipo());
                ps1.setObject(5,pagamento.getDataPagamento());

                // Esecuzione delle query
                ps1.executeUpdate();

                //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
