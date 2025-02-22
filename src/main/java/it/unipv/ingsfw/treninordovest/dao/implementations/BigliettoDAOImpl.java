package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.BigliettoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BigliettoDAOImpl implements BigliettoDAO {
    @Override
    public Biglietto get(String id) throws SQLException {

        /*Per semplificazione delle query di recupero dati si è scelto l'uso di Viste SQL basate su Join interne*/

        Biglietto biglietto = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
           biglietto= null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Ritorno, Validato, DataRitorno,DataValidazione from titoliBiglietti where idTitolo=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                String idPagamento = rs.getString("IDPagamento");
                LocalDate emissione = (LocalDate) rs.getObject("Emissione");
                Double prezzo = (Double) rs.getObject("Prezzo");
                Boolean validato = (Boolean) rs.getObject("Validato");
                Boolean ritorno = (Boolean) rs.getObject("Ritorno");
                LocalDate dataRitorno = (LocalDate) rs.getObject("DataRitorno");
                LocalDate dataValidazione = (LocalDate) rs.getObject("DataValidazione");

               biglietto=new Biglietto(idTitolo,idPagamento,emissione,prezzo,ritorno,validato,dataRitorno,dataValidazione);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biglietto;

    }

    @Override
    public List<Biglietto> getAll() throws SQLException {
        List listaBiglietti =  null;
        Biglietto biglietto= null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            biglietto= null;
            listaBiglietti = new ArrayList<Abbonamento>();
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select IDTitolo, IDPagamento, Emissione, Prezzo, Ritorno, Validato, DataRitorno,DataValidazione from titoliBiglietti where idTitolo=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                String idTitolo = rs.getString("IDTitolo");
                String idPagamento = rs.getString("IDPagamento");
                LocalDate emissione = (LocalDate) rs.getObject("Emissione");
                Double prezzo = (Double) rs.getObject("Prezzo");
                Boolean validato = (Boolean) rs.getObject("Validato");
                Boolean ritorno = (Boolean) rs.getObject("Ritorno");
                LocalDate dataRitorno = (LocalDate) rs.getObject("DataRitorno");
                LocalDate dataValidazione = (LocalDate) rs.getObject("DataValidazione");

                biglietto=new Biglietto(idTitolo,idPagamento,emissione,prezzo,ritorno,validato,dataRitorno,dataValidazione);
                listaBiglietti.add(biglietto);
            }


            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaBiglietti;
    }

    @Override
    public void delete(String id) throws SQLException {

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
    public void update(Biglietto biglietto) throws SQLException {

    }

    @Override
    public void insert(Biglietto biglietto) throws SQLException {

        /*Poichè l'ereditarietà in SQL non esiste propriamente, si è deciso di aggiornare 2 tabella collegate con vincoli
        * di integrità referenziale in modo da avere una coerenza coi dati*/

        String sql1 = "INSERT INTO titoloviaggio (IDTitolo, IDPagamento, Emissione, Prezzo) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO biglietto (IDBiglietto, Ritorno, Validato, DataRitorno, DataValidazione) VALUES (?,?,?,?,?)";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);

            //Impostazione degli attributi
            ps1.setString(1,biglietto.getId());
            ps1.setString(2,biglietto.getIdPagamento());
            ps1.setObject(3,biglietto.getEmissione());
            ps1.setDouble(4,biglietto.getPrezzo());

            ps2.setString(1,biglietto.getId());
            ps2.setObject(2,biglietto.isValidato());
            ps2.setObject(3,biglietto.isRitorno());
            ps2.setObject(4,biglietto.getDataRitorno());
            ps2.setObject(5,biglietto.getDataValidazione());

            ps1.executeUpdate();
            ps2.executeUpdate();
            //Chiusura della connessione col Database
            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
