package it.unipv.ingsfw.treninordovest.controller.customer;

import it.unipv.ingsfw.treninordovest.controller.misc.IController;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.RimborsoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.Rimborso;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.RefundPanel;

import javax.swing.*;
import java.time.LocalDate;

public class TicketRefundController implements IController {
    private JCustomerMainFrame frame;
    private RefundPanel view;


    public TicketRefundController(JCustomerMainFrame frame, RefundPanel view) {
        this.frame = frame;
        this.view = view;
        init();
    }

    @Override
    public void init() {
        initComponents();
    }

    private void initComponents() {
        view.getButtonRimborso().addActionListener(e -> {creaRimborso();});
    }


    private void creaRimborso ()  {

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
