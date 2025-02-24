package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JDecisionFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JCustomerRegistrationFrame;


import java.sql.*;
import java.text.ParseException;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException, ParseException {

        JDecisionFrame frame = new JDecisionFrame();

        frame.show();

        JLoginFrame menu = new JLoginFrame();

        menu.show();

        JCustomerRegistrationFrame registration = new JCustomerRegistrationFrame();

        registration.show();

        //JCalendar calendar = new JCalendar();







    }
}
