package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.dao.database.Database;

import java.sql.*;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException {

        try {
            Connection conn=Database.getConnection();
            if (conn==null){
                System.out.println("Connessione fallita");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }








    }
}
