package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.model.facade.TreniNordOvestFacade;
import it.unipv.ingsfw.treninordovest.model.service.RimborsoService;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.RefundPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RimborsoController implements ActionListener {

    private TreniNordOvestFacade facade;
    private final JTreniNordOvestFrame view;

    public RimborsoController(JTreniNordOvestFrame frame) {
        this.view = frame;
        this.facade = TreniNordOvestFacade.getInstance();
        addActionListeners();
    }

    public void effettuaRimborso() {

        String idBiglietto = view.getCustomerMainPanel().getRefundPanel().getTextIDBiglietto().getText();

        if(facade.getRimborsoFacade().rimborsoBiglietto(idBiglietto)){
            JOptionPane.showMessageDialog(view, "Rimborso effettuato con successo! Al biglietto: " + idBiglietto);
        }else
            JOptionPane.showMessageDialog(view, "Errore durante l'effettuazione del rimborso!", "Errore", JOptionPane.ERROR_MESSAGE);


    }

    private void addActionListeners() {
        view.getCustomerMainPanel().getRefundPanel().getButtonRimborso().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(RefundPanel.CMD_Rimborso)){
            effettuaRimborso();
        }

    }
}
