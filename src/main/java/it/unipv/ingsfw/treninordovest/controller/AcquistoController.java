package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.CardPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.TicketPurchasePanel;

import javax.swing.*;
import java.util.ArrayList;

public class AcquistoController {

    private CardPurchasePanel viewCardPurchase;
    private TicketPurchasePanel viewTicketPurchase;
    private SubscriptionPanel viewSubscription;
    private JCustomerMainFrame frameCustomer;
    private AcquistoFacade acquistoFacade;

    public AcquistoController(CardPurchasePanel viewCardPurchase, JCustomerMainFrame frameCustomer) {
        this.viewCardPurchase = viewCardPurchase;
        this.frameCustomer = frameCustomer;
        this.acquistoFacade = new AcquistoFacade();
        addCardPurchaseListener();
    }

    public AcquistoController(SubscriptionPanel viewSubscription, JCustomerMainFrame frameCustomer) {
        this.viewSubscription = viewSubscription;
        this.frameCustomer = frameCustomer;
        this.acquistoFacade = new AcquistoFacade();
        addAbbonamentoPurchaseListener();
    }

    public AcquistoController(TicketPurchasePanel viewTicketPurchase, JCustomerMainFrame frameCustomer) {

    }


    public void acquistoBiglietto() {}
    public void acquistoAbbonamento() {

       String tipoAbbonamento=viewSubscription.getComboTipo().getSelectedItem().toString();
       String tipoAcquisto=null;

        if(acquistoFacade.acquistoAbbonamento(tipoAbbonamento,tipoAcquisto)){
            JOptionPane.showMessageDialog(frameCustomer, "Acquisto con successo!");
        }
        else
            JOptionPane.showMessageDialog(frameCustomer, "Possiedi già un abbonamento!");



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

    private void addAbbonamentoPurchaseListener() {
        frameCustomer.getSubscriptionPanel().getButtonAbbonati().addActionListener(e -> {
            if (frameCustomer.getSubscriptionPanel().getButtonAbbonati().getActionCommand() != null) {
                acquistoAbbonamento();
            }
        });
    }


    public static void main(String[] args) {
       JCustomerMainFrame fea = new JCustomerMainFrame();

        fea.setVisible(true);
    }


}
