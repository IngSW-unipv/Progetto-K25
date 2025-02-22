package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.view.frames.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.JMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.JRegistrationFrame;


import java.sql.*;
import java.text.ParseException;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException, ParseException {

        JMainFrame menu = new JMainFrame();

        menu.show();

        JRegistrationFrame registration = new JRegistrationFrame();

        registration.show();







    }
}
