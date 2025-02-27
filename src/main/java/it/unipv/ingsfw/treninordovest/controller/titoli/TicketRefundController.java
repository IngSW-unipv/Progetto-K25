package it.unipv.ingsfw.treninordovest.controller.titoli;

import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.RimborsoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.Rimborso;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.RefundPanel;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class TicketRefundController {
    private JCustomerMainFrame frame;
    private RefundPanel view;


    public TicketRefundController(JCustomerMainFrame frame, RefundPanel view) {
        this.frame = frame;
        this.view = view;
        initComponents();
    }

    private void initComponents() {
        view.getButtonRimborso().addActionListener(e -> {
            try {
                creaRimborso();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }


    private void creaRimborso () throws SQLException {

        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();
        String idBiglietto=view.getTextIDBiglietto().getText();

        Biglietto biglietto = bigliettoDAO.get(idBiglietto);

        if (biglietto == null) {
            JOptionPane.showMessageDialog(view, "ID Biglietto non valido riprovare", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        RimborsoDAOImpl rimborsoDAO = new RimborsoDAOImpl();
        Rimborso rimborso ;
        String id = new GeneraID("RM").getID();

        String richiedente = SessionManager.getInstance().getCurrentUser().getId();
        double totale = 2;
        LocalDate dataRimborso=LocalDate.now();

        rimborso =new Rimborso(id,dataRimborso,totale,idBiglietto,richiedente);

        rimborsoDAO.insert(rimborso);


    }

}
