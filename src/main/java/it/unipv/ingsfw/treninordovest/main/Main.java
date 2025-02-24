package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.controller.MainMenuController;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JCustomerRegistrationFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JEmployeeRegistrationFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;


import java.sql.*;
import java.text.ParseException;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException, ParseException {


        JMainMenuFrame frame = new JMainMenuFrame();

        frame.setVisible(true);

        GeneraID generaID = new GeneraID("CL");
        System.out.println(generaID.getID());
        System.out.println(generaID.getID());
        System.out.println(generaID.getID());
        System.out.println(generaID.getID());

    }
}
