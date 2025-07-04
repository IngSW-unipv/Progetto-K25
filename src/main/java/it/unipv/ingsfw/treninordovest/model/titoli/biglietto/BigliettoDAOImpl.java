package it.unipv.ingsfw.treninordovest.model.titoli.biglietto;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BigliettoDAOImpl implements BigliettoDAO {

    @Override
    public Biglietto get(Biglietto biglietto) {

        /*Per semplificazione delle query di recupero dati si è scelto l'uso di Viste SQL basate su Join interne*/

        Biglietto bigliettoDB = null;
        String sql = "select * from titoliBiglietti where idTitolo=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            //Estrazione dei dati dal DB
            ps.setString(1, biglietto.getId().toString());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                String idPagamento = rs.getString("IDPagamento");
                Pagamento pagamento = new Pagamento(idPagamento);
                Date emissione =  rs.getDate("Emissione");
                Viaggio viaggio = new Viaggio(rs.getString("IDViaggio"));
                Double prezzo = (Double) rs.getObject("Prezzo");
                Boolean validato = (Boolean) rs.getObject("Validato");
                String tipoBiglietto = rs.getString("TipoBiglietto");
                Date dataValidazione = rs.getDate("DataValidazione");




               bigliettoDB=new Biglietto(UUID.fromString(idTitolo),pagamento,emissione.toLocalDate(),prezzo,validato,dataValidazione.toLocalDate(),viaggio,tipoBiglietto);
            }
            //Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nel recupero dei biglietti",e);

        }


        return bigliettoDB;

    }

    @Override
    public List<Biglietto> getAll() {
        /*
        List<Biglietto> listaBiglietti= new ArrayList<>();
        Biglietto biglietto;
        String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Ritorno, Validato, DataRitorno,DataValidazione from titoliBiglietti where idTitolo=?";

        try (Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql);ResultSet rs=ps.executeQuery()) {

            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati

            while (rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                String idPagamento = rs.getString("IDPagamento");
                LocalDate emissione = (LocalDate) rs.getObject("Emissione");
                Double prezzo = (Double) rs.getObject("Prezzo");
                Boolean validato = (Boolean) rs.getObject("Validato");
                Boolean ritorno = (Boolean) rs.getObject("Ritorno");
                LocalDate dataRitorno = (LocalDate) rs.getObject("DataRitorno");
                LocalDate dataValidazione = (LocalDate) rs.getObject("DataValidazione");

                biglietto=new Biglietto(UUID.fromString(idTitolo),emissione,prezzo,ritorno,validato,dataRitorno,dataValidazione);
                listaBiglietti.add(biglietto);
            }


            //Database.closeConnection(con);

        } catch (SQLException e) {
           throw new RuntimeException("Errore nel recupero dei biglietti",e);
        }

         */
        return null;
    }


    @Override
    public void delete(Biglietto biglietto) {

        String sql1="DELETE FROM biglietto where IDBiglietto=?";

        try(Connection con = Database.getConnection();PreparedStatement ps = con.prepareStatement(sql1)){
            ps.setString(1, biglietto.getId().toString());
            ps.executeUpdate();
            //Database.closeConnection(con);

        } catch (Exception e) {
           throw new RuntimeException("Errore durante l'eliminazione dati",e);
        }


    }

    @Override
    public void update(Biglietto biglietto) {
        /*
        String sql1="UPDATE titoloviaggio set IDPagamento=?, Emissione=?, Prezzo=? where IDTitolo=?";
        String sql2="UPDATE biglietto set ritorno=?, validato=?, dataRitorno=?, dataValidazione=?  where IDBiglietto=?";

        try(Connection con = Database.getConnection();PreparedStatement ps1= con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2)){

            //Impostazione degli attributi
            ps1.setString(1,biglietto.getIdPagamento());
            ps1.setObject(2,biglietto.getEmissione());
            ps1.setDouble(3,biglietto.getPrezzo());
            ps1.setString(4,biglietto.getId());

            ps2.setObject(1,biglietto.isValidato());
            ps2.setObject(2,biglietto.isRitorno());
            ps2.setObject(2,biglietto.getDataRitorno());
            ps2.setObject(2,biglietto.getDataValidazione());
            ps2.setString(3,biglietto.getId());

            ps1.executeUpdate();
            ps2.executeUpdate();

            //Chiusura della connessione col Database
            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante l'aggiornamento dati",e);
        }



         */
    }

    @Override
    public void insert(Biglietto biglietto) {

        String sql1 = "INSERT INTO titoloviaggio (IDTitolo, IDPagamento, Emissione, Prezzo) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO biglietto (IDBiglietto, Validato, DataValidazione,IDViaggio,TipoBiglietto) VALUES (?,?,?,?,?)";

        try(Connection con = Database.getConnection(); PreparedStatement ps1= con.prepareStatement(sql1); PreparedStatement ps2 = con.prepareStatement(sql2)){

            //Impostazione degli attributi
            ps1.setString(1,biglietto.getId().toString());
            ps1.setString(2,biglietto.getPagamento().getIdPagamento().toString());
            ps1.setObject(3, Date.valueOf(biglietto.getEmissione()));
            ps1.setDouble(4,biglietto.getPrezzo());

            ps2.setString(1,biglietto.getId().toString());
            ps2.setObject(2,biglietto.isValidato());
            ps2.setObject(3,biglietto.getDataValidazione());
            ps2.setString(4,biglietto.getViaggio().getIdViaggio());
            ps2.setString(5,biglietto.getTipoBiglietto());

            ps1.executeUpdate();
            ps2.executeUpdate();
            //Chiusura della connessione col Database
           // Database.closeConnection(con);

        } catch (SQLException e) {
           throw new RuntimeException("Errore durante l'inserimento",e);
        }


    }

    @Override
    public List<Biglietto> getAllBigliettiByCliente(String idCliente) {
        String sql ="select tb.IDTitolo,tb.Emissione,tb.Prezzo,tb.Validato,tb.DataValidazione,tb.TipoBiglietto,tb.tipo from titolibiglietti tb join pagamento pg on tb.IDPagamento=pg.IdPagamento where idCliente =? and Validato=true";
        List<Biglietto> listaBiglietti =  new ArrayList<>();
        Biglietto biglietto;

        try (Connection con = Database.getConnection();PreparedStatement  ps = con.prepareStatement(sql)) {
            ps.setString(1,idCliente);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                Date emissione = rs.getDate("Emissione");
                Double prezzo = (Double) rs.getObject("Prezzo");
                Boolean validato = (Boolean) rs.getObject("Validato");
                Date dataValidazione = rs.getDate("DataValidazione");
                String tipo = rs.getString("Tipo");

                biglietto=new Biglietto(UUID.fromString(idTitolo),emissione.toLocalDate(),prezzo,validato,tipo);
                listaBiglietti.add(biglietto);
            }

            // Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nel recupero dei biglietti",e);
        }
        return listaBiglietti;

    }
}
