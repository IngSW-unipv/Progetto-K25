package it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ViaggioDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Viaggio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ViaggioDAOimpl implements ViaggioDAO {
    @Override
    public Viaggio get(String id) throws SQLException {
        Viaggio viaggio = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            viaggio = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select idViaggio, idTratta, IDPartenza, IDArrivo, DataViaggio, OraPartenza, OraArrivo from Viaggio where idViaggio=?";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String idViaggio=rs.getString("idViaggio");
                String idTratta=rs.getString("idTratta");
                String idPartenza=rs.getString("idPartenza");
                String idArrivo=rs.getString("idArrivo");
                LocalDate dataViaggio= (LocalDate) rs.getObject("dataPagamento");
                LocalTime oraPartenza=(LocalTime)rs.getObject("oraPartenza");
                LocalTime oraArrivo=(LocalTime) rs.getObject("oraArrivo");
                String idBiglietto=rs.getString("idBiglietto");

                viaggio=new Viaggio(idViaggio, idTratta, idPartenza, idArrivo, dataViaggio, oraPartenza, oraArrivo,idBiglietto);
            }

            Database.closeConnection(con);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viaggio;
    }

    @Override
    public List<Viaggio> getAll() throws SQLException {
        List<Viaggio> viaggi= new ArrayList<Viaggio>();

        //Avvio della connessione col DB
        PreparedStatement ps;
        Viaggio viaggio = null;
        try (Connection con = new Database().getConnection()) {

            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select idViaggio, idTratta, idPartenza, idArrivo, dataViaggio, oraPartenza, oraArrivo, idbiglietto from Viaggio";

            //Estrazione dei dati dal DB
            ps = null;
            ps = con.prepareStatement(sql);

            //ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                String idViaggio=rs.getString("idViaggio");
                String idTratta=rs.getString("idPartenza");
                String idPartenza=rs.getString("idPartenza");
                String idArrivo=rs.getString("idArrivo");
                LocalDate dataViaggio= (LocalDate) rs.getObject("dataPagamento");
                LocalTime oraPartenza=(LocalTime)rs.getObject("oraPartenza");
                LocalTime oraArrivo=(LocalTime) rs.getObject("oraArrivo");
                String IdBiglietto=rs.getString("idbiglietto");



                viaggio=new Viaggio(idViaggio, idTratta, idPartenza, idArrivo, dataViaggio, oraPartenza, oraArrivo,IdBiglietto);
                viaggi.add(viaggio);
            }
            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viaggi;
    }


    @Override
    public void delete(String id) throws SQLException {
        try(Connection con = new Database().getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Viaggio where idViaggio=?");
            ps.setString(1,id);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Viaggio viaggio) throws SQLException {
        String sql1="UPDATE Viaggio set idTratta=?, idPartenza=?, idArrivo=?, dataViaggio=?, oraPartenza=?, oraArrivo=?  where idViaggio=?";

        try(Connection con = new Database().getConnection()){
            //Prima Query
            PreparedStatement ps1= con.prepareStatement(sql1);
            ps1.setString(1,viaggio.getIDTratta());
            ps1.setString(2,viaggio.getIDPartenza());
            ps1.setString(3,viaggio.getIDArrivo());
            ps1.setObject(4,viaggio.getDataViaggio());
            ps1.setObject(5,viaggio.getOraPartenza());
            ps1.setObject(6,viaggio.getOraArrivo());
            ps1.setString(7,viaggio.getIdViaggio());

            ps1.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(Viaggio viaggio) throws SQLException {

        Connection con = null;
        try {
            con = new Database().getConnection();
            String sql1 = "INSERT INTO viaggio (IDViaggio,IDTratta,IDPartenza,IDArrivo,DataViaggio,OrarioPartenza,OrarioArrivo,IDBiglietto) VALUES (?,?,?,?,?,?,?,?)";

            try (PreparedStatement ps1 = con.prepareStatement(sql1)) {

                // Impostazione dei parametri per la query 1
                ps1.setString(1,viaggio.getIdViaggio());
                ps1.setString(2,viaggio.getIDTratta());
                ps1.setString(3,viaggio.getIDPartenza());
                ps1.setString(4,viaggio.getIDArrivo());
                ps1.setObject(5,viaggio.getDataViaggio());
                ps1.setObject(6,viaggio.getOraPartenza());
                ps1.setObject(7,viaggio.getOraArrivo());
                ps1.setString(8,viaggio.getIdBiglietto());

                // Esecuzione delle query
                ps1.executeUpdate();

                //Database.closeConnection(con);
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



