package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.AbbonamentoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AbbonamentoDAOimpl implements AbbonamentoDAO {

    @Override
    public Abbonamento get(String id) throws SQLException {

        Abbonamento abbonamento = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            abbonamento= null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Tipo, Scadenza, IDTessera from titoliAbbonamenti where id=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                String idPagamento = rs.getString("IDPagamento");
                LocalDate emissione = (LocalDate) rs.getObject("Emissione");
                Double prezzo = (Double) rs.getObject("Prezzo");
                String tipo = rs.getString("Tipo");
                LocalDate scadenza = (LocalDate) rs.getObject("Scadenza");
                String idTessera = rs.getString("IDTessera");

                abbonamento=new Abbonamento(idTitolo,idPagamento,emissione,prezzo,tipo,scadenza,idTessera);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abbonamento;

    }

    @Override
    public List<Abbonamento> getAll() throws SQLException {

        List listaAbbonamenti =  null;
        Abbonamento abbonamento= null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            abbonamento= null;
            listaAbbonamenti = new ArrayList<Abbonamento>();
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Tipo, Scadenza, IDTessera from titoliAbbonamenti";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                String idPagamento = rs.getString("IDPagamento");
                LocalDate emissione = (LocalDate) rs.getObject("Emissione");
                Double prezzo = (Double) rs.getObject("Prezzo");
                String tipo = rs.getString("Tipo");
                LocalDate scadenza = (LocalDate) rs.getObject("Scadenza");
                String idTessera = rs.getString("IDTessera");

                abbonamento=new Abbonamento(idTitolo,idPagamento,emissione,prezzo,tipo,scadenza,idTessera);
                listaAbbonamenti.add(abbonamento);
            }


            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAbbonamenti;
    }

    @Override
    public void delete(String id) throws SQLException {

        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from abbonamento where IDAbbonamento=?");
            ps.setString(1,id);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Abbonamento abbonamento) throws SQLException {

        String sql1="UPDATE titoloviaggio set IDTitolo=?, IDPagamento=?, Emissione=?, Prezzo=?";
        String sql2="UPDATE abbonamento set IDAbbonamento=?, Tipo=?, Scadenza=?, IDTessera=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);

            //Impostazione degli attributi
            ps1.setString(1,abbonamento.getId());
            ps1.setString(2, abbonamento.getIdPagamento());
            ps1.setObject(3,abbonamento.getEmissione());
            ps1.setDouble(4,abbonamento.getPrezzo());

            ps2.setString(1,abbonamento.getId());
            ps2.setString(2, abbonamento.getTipoAbbonamento());
            ps2.setObject(3,abbonamento.getScadenza());
            ps2.setString(4,abbonamento.getIdTessera());

            ps1.executeUpdate();
            ps2.executeUpdate();

            //Chiusura della connessione col Database
            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insert(Abbonamento abbonamento) throws SQLException {
        Connection con = null;
        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO titoloviaggio (IDTitolo, IDPagamento, Emissione, Prezzo) VALUES (?, ?, ?, ?)";
            String sql2 = "INSERT INTO abbonamento (IDAbbonamento, Tipo, Scadenza, IDTessera) VALUES (?,?,?,?)";
            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {
                // Impostazione dei parametri per la query 1
                ps1.setString(1,abbonamento.getId());
                ps1.setString(2,abbonamento.getIdPagamento());
                ps1.setObject(3,abbonamento.getEmissione());
                ps1.setDouble(4, abbonamento.getPrezzo());
                // Esecuzione delle query
                ps1.executeUpdate();

            }
            try (PreparedStatement ps2 = con.prepareStatement(sql2)) {
                // Impostazione dei parametri per la query 1
                ps2.setString(1, abbonamento.getId());
                ps2.setString(2, abbonamento.getIdPagamento());
                ps2.setObject(3, abbonamento.getScadenza());
                ps2.setString(4, abbonamento.getIdTessera());
                // Esecuzione delle query
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
}
