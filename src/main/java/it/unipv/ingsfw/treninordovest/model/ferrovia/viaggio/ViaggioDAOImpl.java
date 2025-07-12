package it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio;

import it.unipv.ingsfw.treninordovest.model.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.Fermata;
import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.FermataDAOImpl;
import it.unipv.ingsfw.treninordovest.model.ferrovia.tratta.Tratta;
import it.unipv.ingsfw.treninordovest.model.ferrovia.treno.Treno;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ViaggioDAOImpl implements ViaggioDAO {

    private FermataDAOImpl fermataDAO;

    public ViaggioDAOImpl() {
        fermataDAO = new FermataDAOImpl();
    }


    @Override
    public Viaggio get(Viaggio viaggio) {
        Viaggio viaggioEstr = null;
        String sql = "select * from viaggio where idViaggio=?";

        try (Connection con = Database.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, viaggio.getIdViaggio());

            try ( ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    String idTratta=rs.getString("idTratta");
                    String idPartenza=rs.getString("idPartenza");
                    String idArrivo=rs.getString("idArrivo");
                    Date dataViaggio= rs.getDate("dataViaggio");
                    Time oraPartenza=rs.getTime("orarioPartenza");
                    Time oraArrivo= rs.getTime("orarioArrivo");

                    Fermata partenza=fermataDAO.get(new Fermata(idPartenza));
                    Fermata arrivo=fermataDAO.get(new Fermata(idArrivo));
                    Treno treno = new Treno(rs.getString("numTreno"));
                    Tratta tratta = new Tratta(idTratta);


                    viaggioEstr=new Viaggio(viaggio.getIdViaggio(),tratta,treno ,partenza,arrivo, oraPartenza.toLocalTime(), oraArrivo.toLocalTime(),dataViaggio.toLocalDate());
                }
            }



            Database.closeConnection(con);


        } catch (SQLException e) {
            throw new RuntimeException("Errore nel recupero dati",e);
        }
        return viaggioEstr;
    }


    @Override
    public List<Viaggio> getAll() {
        List<Viaggio> viaggi= new ArrayList<>();

        //Avvio della connessione col DB
        String sql = "select * from Viaggio";
        Viaggio viaggio;
        try (Connection con = Database.getConnection(); PreparedStatement  ps = con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {

            //Estrazione dei dati dal DB
            while(rs.next()){
                String idViaggio=rs.getString("idViaggio");
                String idTratta=rs.getString("idTratta");
                String idPartenza=rs.getString("idPartenza");
                String idArrivo=rs.getString("idArrivo");
                Date dataViaggio= rs.getDate("dataViaggio");
                Time oraPartenza=rs.getTime("orarioPartenza");
                Time oraArrivo= rs.getTime("orarioArrivo");

                Fermata partenza=fermataDAO.get(new Fermata(idPartenza));
                Fermata arrivo=fermataDAO.get(new Fermata(idArrivo));
                Treno treno = new Treno(rs.getString("numTreno"));
                Tratta tratta = new Tratta(idTratta);


               viaggio=new Viaggio(idViaggio,tratta,treno ,partenza,arrivo, oraPartenza.toLocalTime(), oraArrivo.toLocalTime(),dataViaggio.toLocalDate());
                viaggi.add(viaggio);

            }
            return viaggi;
           // Database.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nel recupero dati",e);
        }
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
        }*/
    }

    @Override
    public void update(Viaggio viaggio)  {
/*        String sql1="UPDATE Viaggio set idTratta=?, idPartenza=?, idArrivo=?, dataViaggio=?, OrarioPartenza=?, OrarioArrivo=?  where idViaggio=?";

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
*/
    }

    @Override
    public void insert(Viaggio viaggio)  {

        String sql1 = "INSERT INTO viaggio (IDViaggio,IDTratta,IDPartenza,IDArrivo,DataViaggio,OrarioPartenza,OrarioArrivo) VALUES (?,?,?,?,?,?,?)";

        try( Connection con1 = Database.getConnection(); PreparedStatement ps1 = con1.prepareStatement(sql1)) {
                //Impostazione dei parametri per la query 1
                ps1.setString(1,viaggio.getIdViaggio().toString());
                ps1.setString(2,viaggio.getTratta().getIdTratta());
                ps1.setString(3,viaggio.getPartenza().getIdFermata());
                ps1.setString(4,viaggio.getDestinazione().getIdFermata());
                ps1.setObject(5,viaggio.getDataViaggio());
                ps1.setObject(6,viaggio.getOraPartenza());
                ps1.setObject(7,viaggio.getOraArrivo());

                // Esecuzione delle query
                ps1.executeUpdate();

                //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}



