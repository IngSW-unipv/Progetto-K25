package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.CardPurchasePanel;

import javax.swing.*;

public class AcquistoController {

    private CardPurchasePanel viewCardPurchase;
    private JCustomerMainFrame frameCustomer;
    private AcquistoFacade acquistoFacade;

    public AcquistoController(CardPurchasePanel viewCardPurchase, JCustomerMainFrame frameCustomer) {
        this.viewCardPurchase = viewCardPurchase;
        this.frameCustomer = frameCustomer;
        this.acquistoFacade = new AcquistoFacade();
        addCardPurchaseListener();
    }

    public void acquistoBiglietto() {}
    public void acquistoAbbonamento() {


    }
    public void acquistoTessera() {

        if (acquistoFacade.acquistaTessera()) {
            JOptionPane.showMessageDialog(frameCustomer, "Acquisto con successo!");
        } else
            JOptionPane.showMessageDialog(frameCustomer, "Errore !!! Sei già in possesso della tessera","Error",JOptionPane.ERROR_MESSAGE);




    }


    private void addCardPurchaseListener() {

        frameCustomer.getCardPurchasePanel().getButtonAcquistaTessera().addActionListener(e -> {
            if (frameCustomer.getCardPurchasePanel().getButtonAcquistaTessera().getActionCommand() != null) {
                acquistoTessera();
            }
        });


    }


    public static void main(String[] args) {
       JCustomerMainFrame fea = new JCustomerMainFrame();

        fea.setVisible(true);
    }


}
