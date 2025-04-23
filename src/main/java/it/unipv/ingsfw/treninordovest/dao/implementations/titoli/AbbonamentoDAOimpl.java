package it.unipv.ingsfw.treninordovest.dao.implementations.titoli;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.AbbonamentoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AbbonamentoDAOimpl implements AbbonamentoDAO {

    @Override
    public Abbonamento get(String id)  {

        Abbonamento abbonamento = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            //abbonamento= null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Tipo, Scadenza, IDTessera from titoliAbbonamenti where IDTitolo=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();


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

                abbonamento=new Abbonamento(idTitolo,idPagamento,emissioneLoc,prezzo,tipo,scadenzaLoc,idTessera);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abbonamento;

    }

    @Override
    public List<Abbonamento> getAll()  {

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
    public void delete(String id)  {

        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from titoloviaggio where IDTitolo=?");
            ps.setString(1,id);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Abbonamento abbonamento)  {

        String sql1="UPDATE titoloviaggio set IDPagamento=?, Emissione=?, Prezzo=? where IDTitolo=? ";
        String sql2="UPDATE abbonamento set Tipo=?, Scadenza=?, IDTessera=? where IDAbbonamento=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);

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
            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insert(Abbonamento abbonamento)  {
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
        }

    }
}
