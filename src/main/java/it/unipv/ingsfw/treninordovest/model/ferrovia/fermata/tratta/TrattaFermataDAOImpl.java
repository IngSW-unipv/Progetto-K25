package it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.tratta;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.Fermata;
import it.unipv.ingsfw.treninordovest.model.ferrovia.tratta.Tratta;

import java.sql.*;
import java.time.LocalTime;
import java.util.List;

public class TrattaFermataDAOImpl implements TrattaFermataDAO {
    @Override
    public TrattaFermata get(Tratta tratta, Fermata fermata)  {

        TrattaFermata trattaFermata = new TrattaFermata();
        PreparedStatement ps;
        try (Connection con = Database.getConnection()) {
            //trattaFermata = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from trattafermata where IDTratta=? and idFermata=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,tratta.getIdTratta());
            ps.setString(2,fermata.getIdFermata());
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String idTratta1 = rs.getString("idTratta");
                int numOrdine = rs.getInt("NumOrdine");
                String idFermata1 = rs.getString("IDFermata");
                int binario = rs.getInt("Binario");
                Time oraPartenza =  rs.getTime("OraPartenza");
                Time oraArrivo =  rs.getTime("OraArrivo");

                LocalTime oraPartLocal = oraPartenza.toLocalTime();
                LocalTime oraArrivoLocal = oraArrivo.toLocalTime();

                trattaFermata=new TrattaFermata(new Fermata(idFermata1), numOrdine, new Tratta(idTratta1), oraPartLocal, oraArrivoLocal,binario);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trattaFermata;

    }

    @Override
    public TrattaFermata getPartenza(Tratta tratta) {
        TrattaFermata trattafer = new TrattaFermata();
        String sql = "SELECT t1.IDTratta, t1.NumOrdine, t1.IDFermata, t1.Binario, t1.OraPartenza, t1.OraArrivo " +
                "FROM trattafermata t1 " +
                "WHERE t1.NumOrdine = (" +
                "    SELECT MIN(t2.NumOrdine) " +
                "    FROM trattafermata t2 " +
                "    WHERE t2.IDTratta = t1.IDTratta" +
                ") AND t1.IDTratta = ?;";

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tratta.getIdTratta());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int numOrdine = rs.getInt("NumOrdine");
                    String idFermata = rs.getString("IDFermata");
                    int binario = rs.getInt("Binario");
                    Time oraPartenza = rs.getTime("OraPartenza");
                    Time oraArrivo = rs.getTime("OraArrivo");
                    LocalTime oraPartLocal = oraPartenza.toLocalTime();
                    LocalTime oraArrivoLocal = oraArrivo.toLocalTime();

                    trattafer = new TrattaFermata(new Fermata(idFermata), numOrdine, new Tratta(tratta.getIdTratta()), oraPartLocal, oraArrivoLocal,binario);
                }
            }
        } catch (SQLException e) {
            // Loggare l'errore o gestirlo in modo appropriato
            e.printStackTrace();

        }

        return trattafer;
    }


    @Override
    public TrattaFermata getArrivo(Tratta tratta)  {
        TrattaFermata trattafer = new TrattaFermata();
        String sql = "SELECT t1.IDTratta, t1.NumOrdine, t1.IDFermata, t1.Binario, t1.OraPartenza, t1.OraArrivo " +
                "FROM trattafermata t1 " +
                "WHERE t1.NumOrdine = (" +
                "    SELECT MAX(t2.NumOrdine) " +
                "    FROM trattafermata t2 " +
                "    WHERE t2.IDTratta = t1.IDTratta" +
                ") AND t1.IDTratta = ?;";

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tratta.getIdTratta());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int numOrdine = rs.getInt("NumOrdine");
                    String idFermata = rs.getString("IDFermata");
                    int binario = rs.getInt("Binario");
                    Time oraPartenza = rs.getTime("OraPartenza");
                    Time oraArrivo = rs.getTime("OraArrivo");
                    LocalTime oraPartLocal = oraPartenza.toLocalTime();
                    LocalTime oraArrivoLocal = oraArrivo.toLocalTime();

                    trattafer = new TrattaFermata(new Fermata(idFermata), numOrdine, new Tratta(tratta.getIdTratta()), oraPartLocal, oraArrivoLocal,binario);;
                }
            }
        } catch (SQLException e) {
            // Loggare l'errore o gestirlo in modo appropriato
            e.printStackTrace();

        }

        return trattafer;
    }


    @Override
    public TrattaFermata get(TrattaFermata oggetto) {
        return null;
    }

    @Override
    public List<TrattaFermata> getAll()  {
        return List.of();
    }

    @Override
    public void delete(TrattaFermata trattaFermata) {

    }


    @Override
    public void update(TrattaFermata trattaFermata) {
    }

    @Override
    public void insert(TrattaFermata trattaFermata) {

    }
}
