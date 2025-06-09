package it.unipv.ingsfw.treninordovest.model.titoli.abbonamento;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AbbonamentoDAOimpl implements AbbonamentoDAO {

    private PagamentoDAOImpl pagamentoDAO;
    private TesseraDAOImpl tesseraDAO;

    public AbbonamentoDAOimpl() {
        pagamentoDAO = new PagamentoDAOImpl();
        tesseraDAO = new TesseraDAOImpl();
    }

    @Override
    public Abbonamento get(Abbonamento abbonamento)  {

        String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Tipo, Scadenza, IDTessera from titoliAbbonamenti where IDTitolo=?";

        try (Connection con =Database.getConnection();PreparedStatement ps = con.prepareStatement(sql);ResultSet rs=ps.executeQuery()) {

            //Estrazione dei dati dal DB
            ps.setString(1, abbonamento.getId());

            if(rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                String idPagamento = rs.getString("IDPagamento");
                Date emissione = rs.getDate("Emissione");
                LocalDate emissioneLoc= emissione.toLocalDate();
                Double prezzo = (Double) rs.getObject("Prezzo");
                String tipo = rs.getString("Tipo");
                Date scadenza = rs.getDate("Scadenza");
                LocalDate scadenzaLoc= scadenza.toLocalDate();
                String idTessera = rs.getString("IDTessera");

                abbonamento=new Abbonamento(idTitolo,emissioneLoc,prezzo,tipo,scadenzaLoc);
            }
            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nel recupero degli abbonamenti",e);
        }
        return abbonamento;

    }

    @Override
    public List<Abbonamento> getAll()  {

        List<Abbonamento> listaAbbonamenti =  new ArrayList<>();
        Abbonamento abbonamento;
        String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Tipo, Scadenza, IDTessera from titoliAbbonamenti";

        try (Connection con = Database.getConnection();PreparedStatement  ps = con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            //Estrazione dei dati dal DB

            while (rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                String idPagamento = rs.getString("IDPagamento");
                LocalDate emissione = (LocalDate) rs.getObject("Emissione");
                Double prezzo = (Double) rs.getObject("Prezzo");
                String tipo = rs.getString("Tipo");
                LocalDate scadenza = (LocalDate) rs.getObject("Scadenza");
                String idTessera = rs.getString("IDTessera");

                abbonamento=new Abbonamento(idTitolo,emissione,prezzo,tipo,scadenza);
                listaAbbonamenti.add(abbonamento);
            }

           // Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nel recupero degli abbonamenti",e);
        }
        return listaAbbonamenti;
    }


    @Override
    public void delete(Abbonamento abbonamento)  {
/*
        String sql1="DELETE FROM abbonamento where IDAbbonamento=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql1)){

            ps.setString(1, abbonamento.getTipoAbbonamento());
            ps.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'eliminazione dati",e);
        }



 */
    }

    @Override
    public void update(Abbonamento abbonamento)  {
        /*
        String sql1="UPDATE titoloviaggio set IDPagamento=?, Emissione=?, Prezzo=? where IDTitolo=? ";
        String sql2="UPDATE abbonamento set Tipo=?, Scadenza=?, IDTessera=? where IDAbbonamento=?";

        try(Connection con = Database.getConnection();  PreparedStatement ps1= con.prepareStatement(sql1); PreparedStatement ps2 = con.prepareStatement(sql2)){

            //Impostazione degli attributi
            ps1.setString(1, abbonamento.getIdPagamento());
            ps1.setObject(2,abbonamento.getEmissione());
            ps1.setDouble(3,abbonamento.getPrezzo());
            ps1.setString(4,abbonamento.getId());

            ps2.setString(1, abbonamento.getTipoAbbonamento());
            ps2.setObject(2,abbonamento.getScadenza());
            ps2.setString(3,abbonamento.getIdTessera());
            ps2.setString(4,abbonamento.getId());

            ps1.executeUpdate();
            ps2.executeUpdate();

            //Chiusura della connessione col Database
           //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'aggiornamento dati",e);
        }*/


    }

    @Override
    public void insert(Abbonamento abbonamento)  {
        /*
        String sql1 = "INSERT INTO titoloviaggio (IDTitolo, IDPagamento, Emissione, Prezzo) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO abbonamento (IDAbbonamento, Tipo, Scadenza, IDTessera) VALUES (?,?,?,?)";



        try (Connection con = Database.getConnection()) {

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
        }

        */

    }



}
