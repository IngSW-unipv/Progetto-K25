package it.unipv.ingsfw.treninordovest.controller.titoli;

import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JEmployeeMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TravelDocCheckPanel;

import javax.swing.*;
import java.sql.SQLException;

public class TicketCheckController {
    private JEmployeeMainFrame frame;
    private TravelDocCheckPanel view;


    public TicketCheckController(JEmployeeMainFrame frame, TravelDocCheckPanel view) {
        this.frame = frame;
        this.view = view;
        initComponents();

    }
    private void initComponents() {
        view.getVerificaButton().addActionListener(e -> {
            try {
                verficaTitolo();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    private void verficaTitolo () throws SQLException {
        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();
        AbbonamentoDAOimpl abbonamentoDAOimpl  = new AbbonamentoDAOimpl();

        if (bigliettoDAO.get(view.getTextFieldIdTitolo().getText())!=null || abbonamentoDAOimpl.get(view.getTextFieldIdTitolo().getText())!=null) {
            JOptionPane.showMessageDialog(view,"Titolo di viaggio valido");

        }else{
            JOptionPane.showMessageDialog(view, "Titolo di viaggio inesistente", "Errore", JOptionPane.ERROR_MESSAGE);
        }


    }

}
