package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.titoli.Rimborso;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RimborsoDAOImplTest {

    @Test
    void get() {
        String id="XCER3";
        Rimborso rimborso = null;
        PreparedStatement ps;
        try (Connection con = new Database().getConnection()) {
            rimborso = null;
            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
            String sql = "select * from rimborso where idRimborso=?";

            //Estrazione dei dati dal DB
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                Double totale = rs.getDouble("totale");
                String idBiglietto=rs.getString("idBiglietto");
                String idRichiedente = rs.getString("idRichiedente");
                LocalDate dataRimborso = (LocalDate)rs.getObject("DataRimborso");


                rimborso=new Rimborso(id,dataRimborso,totale,idBiglietto,idRichiedente);
            }
            System.out.println(rimborso);

            Database.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
    }
}