package it.unipv.ingsfw.treninordovest.controller.customer;


import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.view.frames.employee.JEmployeeMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TravelDocCheckPanel;

import javax.swing.*;

public class TicketCheckController {
    private JEmployeeMainFrame frame;
    private TravelDocCheckPanel view;


    public TicketCheckController(JEmployeeMainFrame frame, TravelDocCheckPanel view) {
        this.frame = frame;
        this.view = view;
        init();

    }


    private void init() {
        view.getVerificaButton().addActionListener(e -> {verficaTitolo();});

    }

    private void verficaTitolo () {
        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();
        AbbonamentoDAOimpl abbonamentoDAOimpl  = new AbbonamentoDAOimpl();

        if (bigliettoDAO.get(view.getTextFieldIdTitolo().getText())!=null || abbonamentoDAOimpl.get(view.getTextFieldIdTitolo().getText())!=null) {
            JOptionPane.showMessageDialog(view,"Titolo di viaggio valido");

        }else{
            JOptionPane.showMessageDialog(view, "Titolo di viaggio inesistente", "Errore", JOptionPane.ERROR_MESSAGE);
        }


    }

}
