package it.unipv.ingsfw.treninordovest.main;

import java.sql.*;
import java.sql.ResultSet;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/treninordovest","root","xxxx");

            Statement stmt = con.createStatement();
            //ResultSet res = stmt.executeQuery("SELECT ID,Nome,Cognome from utente");
            ResultSet res = stmt.executeQuery("SELECT * from treno");

            while (res.next()){
                /*System.out.println(res.getString("ID"));
                System.out.println(res.getString("Nome"));
                System.out.println(res.getString("Cognome"));*/

                System.out.println(res.getString("IDTreno"));
                System.out.println(res.getString("Modello"));
                System.out.println(res.getString("KW"));
                System.out.println(res.getString("NumPosti"));

            }

        }catch (SQLDataException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
