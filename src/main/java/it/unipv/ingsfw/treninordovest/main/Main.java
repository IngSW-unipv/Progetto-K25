package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;


import java.sql.*;
import java.text.ParseException;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException, ParseException {


        JMainMenuFrame frame = new JMainMenuFrame();

        frame.setVisible(true);

        SessionManager sessionManager = SessionManager.getInstance();



        GeneraID generaID = new GeneraID("CL");
        System.out.println(generaID.getID());
        System.out.println(generaID.getID());
        System.out.println(generaID.getID());
        System.out.println(generaID.getID());

    }
}
