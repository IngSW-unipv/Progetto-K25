package it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.TrattaFermataDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;
import it.unipv.ingsfw.treninordovest.model.ferrovia.TrattaFermata;

import java.sql.*;
import java.time.LocalTime;
import java.util.List;

public class TrattaFermataDAOImpl implements TrattaFermataDAO {
    @Override
    public TrattaFermata get(String idTratta, String idFermata) throws SQLException {

        TrattaFermata trattaFermata = new TrattaFermata();
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            //trattaFermata = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from trattafermata where IDTratta=? and idFermata=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,idTratta);
            ps.setString(2,idFermata);
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

                trattaFermata=new TrattaFermata(idTratta, numOrdine, idFermata, oraPartLocal, oraArrivoLocal,binario);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trattaFermata;

    }

    @Override
    public TrattaFermata getPartenza(String idTratta) throws SQLException {
        TrattaFermata tratta = new TrattaFermata();
        String sql = "SELECT t1.IDTratta, t1.NumOrdine, t1.IDFermata, t1.Binario, t1.OraPartenza, t1.OraArrivo " +
                "FROM trattafermata t1 " +
                "WHERE t1.NumOrdine = (" +
                "    SELECT MIN(t2.NumOrdine) " +
                "    FROM trattafermata t2 " +
                "    WHERE t2.IDTratta = t1.IDTratta" +
                ") AND t1.IDTratta = ?;";

        try (Connection con = new Database().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, idTratta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int numOrdine = rs.getInt("NumOrdine");
                    String idFermata = rs.getString("IDFermata");
                    int binario = rs.getInt("Binario");
                    Time oraPartenza = rs.getTime("OraPartenza");
                    Time oraArrivo = rs.getTime("OraArrivo");
                    LocalTime oraPartLocal = oraPartenza.toLocalTime();
                    LocalTime oraArrivoLocal = oraArrivo.toLocalTime();

                    tratta = new TrattaFermata(idFermata, numOrdine, idTratta, oraPartLocal, oraArrivoLocal, binario);
                }
            }
        } catch (SQLException e) {
            // Loggare l'errore o gestirlo in modo appropriato
            e.printStackTrace();
            throw e;
        }

        return tratta;
    }


    @Override
    public TrattaFermata getArrivo(String idTratta) throws SQLException {
        TrattaFermata tratta = new TrattaFermata();
        String sql = "SELECT t1.IDTratta, t1.NumOrdine, t1.IDFermata, t1.Binario, t1.OraPartenza, t1.OraArrivo " +
                "FROM trattafermata t1 " +
                "WHERE t1.NumOrdine = (" +
                "    SELECT MAX(t2.NumOrdine) " +
                "    FROM trattafermata t2 " +
                "    WHERE t2.IDTratta = t1.IDTratta" +
                ") AND t1.IDTratta = ?;";

        try (Connection con = new Database().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, idTratta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int numOrdine = rs.getInt("NumOrdine");
                    String idFermata = rs.getString("IDFermata");
                    int binario = rs.getInt("Binario");
                    Time oraPartenza = rs.getTime("OraPartenza");
                    Time oraArrivo = rs.getTime("OraArrivo");
                    LocalTime oraPartLocal = oraPartenza.toLocalTime();
                    LocalTime oraArrivoLocal = oraArrivo.toLocalTime();

                    tratta = new TrattaFermata(idFermata, numOrdine, idTratta, oraPartLocal, oraArrivoLocal, binario);
                }
            }
        } catch (SQLException e) {
            // Loggare l'errore o gestirlo in modo appropriato
            e.printStackTrace();
            throw e;
        }

        return tratta;
    }

    @Override
    public TrattaFermata get(String id) throws SQLException {
        return null;
    }

    @Override
    public List<TrattaFermata> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void delete(String id) throws SQLException {

    }

    @Override
    public void update(TrattaFermata trattaFermata) throws SQLException {
    }

    @Override
    public void insert(TrattaFermata trattaFermata) throws SQLException {

    }
}
