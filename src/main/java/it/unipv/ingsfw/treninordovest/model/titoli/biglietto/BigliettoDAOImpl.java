package it.unipv.ingsfw.treninordovest.model.titoli.biglietto;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BigliettoDAOImpl implements BigliettoDAO {

    public Biglietto get(String id) {
//
//        /*Per semplificazione delle query di recupero dati si è scelto l'uso di Viste SQL basate su Join interne*/
//
//        String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Ritorno, Validato, DataRitorno,DataValidazione from titoliBiglietti where idTitolo=?";
//
//        Biglietto biglietto = null;
//
//        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {
//
//            //Estrazione dei dati dal DB
//            ps.setString(1, id);
//
//            if(rs.next()){
//                String idTitolo = rs.getString("IDTitolo");
//                String idPagamento = rs.getString("IDPagamento");
//                Date emissione =  rs.getDate("Emissione");
//
//                LocalDate emissioneLocal= emissione.toLocalDate();
//
//                Double prezzo = (Double) rs.getObject("Prezzo");
//                Boolean validato = (Boolean) rs.getObject("Validato");
//                Boolean ritorno = (Boolean) rs.getObject("Ritorno");
//
//                LocalDate dataRitornoLocal=LocalDate.now();
//                if (rs.getDate("DataRitorno") == null ) {
//                    dataRitornoLocal = LocalDate.now();
//                }else
//                    rs.getDate("DataRitorno");
//                Date dataValidazione = rs.getDate("DataValidazione");
//
//                LocalDate dataValLocal= dataValidazione.toLocalDate();
//
//               biglietto=new Biglietto(UUID.fromString(idTitolo),emissioneLocal,prezzo,ritorno,validato,dataRitornoLocal,dataValLocal);
//            }
//            //Database.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException("Errore nel recupero dei biglietti",e);
//        }
//        return biglietto;

        return null;

    }

    @Override
    public Biglietto get(Biglietto oggetto) {
        return null;
    }

    @Override
    public List<Biglietto> getAll() {
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
        return listaBiglietti;
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

        /*Poichè l'ereditarietà in SQL non esiste propriamente, si è deciso di aggiornare 2 tabella collegate con vincoli
        * di integrità referenziale in modo da avere una coerenza coi dati

        String sql1 = "INSERT INTO titoloviaggio (IDTitolo, IDPagamento, Emissione, Prezzo) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO biglietto (IDBiglietto, Ritorno, Validato, DataRitorno, DataValidazione) VALUES (?,?,?,?,?)";

        try(Connection con = Database.getConnection(); PreparedStatement ps1= con.prepareStatement(sql1); PreparedStatement ps2 = con.prepareStatement(sql2)){

            //Impostazione degli attributi
            ps1.setString(1,biglietto.getId());
            ps1.setString(2,biglietto.getIdPagamento());
            ps1.setObject(3,biglietto.getEmissione());
            ps1.setDouble(4,biglietto.getPrezzo());

            ps2.setString(1,biglietto.getId());
            ps2.setObject(2,biglietto.isRitorno());
            ps2.setObject(3,biglietto.isValidato());
            ps2.setObject(4,biglietto.getDataRitorno());
            ps2.setObject(5,biglietto.getDataValidazione());

            ps1.executeUpdate();
            ps2.executeUpdate();
            //Chiusura della connessione col Database
           // Database.closeConnection(con);

        } catch (Exception e) {
           throw new RuntimeException("Errore durante l'inserimento",e);
        }

         */
    }
}
