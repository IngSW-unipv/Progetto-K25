package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.view.frames.JStartFrame;
import it.unipv.ingsfw.treninordovest.view.frames.JRegistrationFrame;


import java.sql.*;
import java.text.ParseException;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException, ParseException {

        JStartFrame menu = new JStartFrame();

        menu.show();

        JRegistrationFrame registration = new JRegistrationFrame();

        registration.show();

        //JCalendar calendar = new JCalendar();







    }
}
