package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.view.JMainFrame;


import java.sql.*;
import java.text.ParseException;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException, ParseException {

/*
        try {

            Connection conn=Database.getConnection();

            ClienteDAO clienteDAO = new ClienteDAOImpl();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Parsing delle date di nascita usando LocalDate
            LocalDate data1 = LocalDate.parse("1995-08-25", formatter);
            LocalDate data2 = LocalDate.parse("1988-02-14", formatter);
            Cliente cliente2 = new Cliente("U028", "pwd7", "Luca", "Pinucci",
                    "Verona'", "M", data1, "3337778889", "Via Arena 22, Verona",
                    200.00, "luca.rossi@example.com");

            clienteDAO.insert(cliente2);*

        }catch(SQLException e){
            e.printStackTrace();
        }*/




        //Controllare insert

        JMainFrame menu = new JMainFrame();

        menu.initialize();






    }
}
