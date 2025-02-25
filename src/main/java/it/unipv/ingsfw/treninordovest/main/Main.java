package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;
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

        System.out.println(sessionManager.getCurrentUser());

        TesseraDAOImpl tdao = new TesseraDAOImpl();

        System.out.println(tdao.getIdTessera("CL42863"));


    }
}
