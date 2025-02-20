package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.implementations.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.dao.interfaces.UtenteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException, ParseException {


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

            clienteDAO.insert(cliente2);

        }catch(SQLException e){
            e.printStackTrace();
        }




        //Controllare insert


    }
}
