package it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio;

import it.unipv.ingsfw.treninordovest.dao.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ViaggioDAOImpl implements ViaggioDAO {

    @Override
    public Viaggio get(Viaggio viaggio) {
        String sql = "select idViaggio, IDPartenza,DataViaggio, OrarioPartenza, OrarioArrivo from Viaggio where idViaggio=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {

            ps.setString(1, viaggio.getIdViaggio());

            if(rs.next()){
                String idViaggio=rs.getString("idViaggio");
                LocalDate dataViaggio= (LocalDate) rs.getObject("dataPagamento");
                LocalTime oraPartenza=(LocalTime)rs.getObject("oraPartenza");
                LocalTime oraArrivo=(LocalTime) rs.getObject("oraArrivo");

                viaggio=new Viaggio(idViaggio, dataViaggio, oraPartenza, oraArrivo);
            }

            Database.closeConnection(con);


        } catch (SQLException e) {
            throw new RuntimeException("Errore nel recupero dati",e);
        }
        return viaggio;
    }


    @Override
    public List<Viaggio> getAll() {
        List<Viaggio> viaggi= new ArrayList<>();

        //Avvio della connessione col DB
        String sql = "select idViaggio, idTratta, idPartenza, idArrivo, dataViaggio, OrarioArrivo, OrarioArrivo, idbiglietto from Viaggio";
        Viaggio viaggio;
        try (Connection con = Database.getConnection(); PreparedStatement  ps = con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {

            //Estrazione dei dati dal DB
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
           // Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nel recupero dati",e);
        }
        return viaggi;
    }


    @Override
    public void delete(Viaggio viaggio)  {
/*
        String sql = "delete from Viaggio where idViaggio=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,viaggio.getIdViaggio());
            ps.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione dati",e);
        }
    }

    @Override
    public void update(Viaggio viaggio)  {
        String sql1="UPDATE Viaggio set idTratta=?, idPartenza=?, idArrivo=?, dataViaggio=?, OrarioPartenza=?, OrarioArrivo=?  where idViaggio=?";

        try(Connection con = Database.getConnection(); PreparedStatement ps1= con.prepareStatement(sql1)){
            //Prima Query

            ps1.setString(1,viaggio.getIDTratta());
            ps1.setString(2,viaggio.getIDPartenza());
            ps1.setString(3,viaggio.getIDArrivo());
            ps1.setObject(4,viaggio.getDataViaggio());
            ps1.setObject(5,viaggio.getOraPartenza());
            ps1.setObject(6,viaggio.getOraArrivo());
            ps1.setString(7,viaggio.getIdViaggio());

            ps1.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException("Errore nell'aggiornamento dati",e);
        }

    }

    @Override
    public void insert(Viaggio viaggio)  {

        String sql1 = "INSERT INTO viaggio (IDViaggio,IDTratta,IDPartenza,IDArrivo,DataViaggio,OrarioPartenza,OrarioArrivo,IDBiglietto) VALUES (?,?,?,?,?,?,?,?)";

        try( Connection con1 = Database.getConnection(); PreparedStatement ps1 = con1.prepareStatement(sql1)) {
                //Impostazione dei parametri per la query 1
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

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}



