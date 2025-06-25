package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.CardPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.TicketPurchasePanel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

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
        this.viewTicketPurchase = viewTicketPurchase;
        this.frameCustomer = frameCustomer;
        this.acquistoFacade = new AcquistoFacade();
        addAbbonamentoPurchaseListener();
    }


    ///  Acquisto dei biglietti
    public void acquistoBiglietto() {

        String idTratta= viewTicketPurchase.getTextFieldTratta().getText();
        boolean ritorno=viewTicketPurchase.getCheckBoxRitorno().isSelected() ;
        LocalDate dataRitorno= viewTicketPurchase.getDataRitorno().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String tipoBiglietto = "";
        String tipoPagamento = "";
        int quantita = 0;

        if(acquistoFacade.acquistaBiglietto(tipoBiglietto,tipoPagamento,quantita,idTratta,ritorno,dataRitorno)) {
            JOptionPane.showMessageDialog(frameCustomer, "Biglietti acquistati");
        } else
            JOptionPane.showMessageDialog(frameCustomer, "Errore durante l'acquisto dei biglietti");



    }

    ///  Acquisto dell'abbonamento
    public void acquistoAbbonamento() {

       String tipoAbbonamento=viewSubscription.getComboTipo().getSelectedItem().toString();
       String tipoAcquisto=null;
       int quantita=1;

        if(acquistoFacade.acquistoAbbonamento(tipoAbbonamento,tipoAcquisto,quantita)){
            JOptionPane.showMessageDialog(frameCustomer, "Acquisto con successo!");
        }
        else
            JOptionPane.showMessageDialog(frameCustomer, "Possiedi già un abbonamento!");



    }

    ///  Acquisto della tessera
    public void acquistoTessera() {

        if (acquistoFacade.acquistaTessera()) {
            JOptionPane.showMessageDialog(frameCustomer, "Acquisto con successo!");
        } else
            JOptionPane.showMessageDialog(frameCustomer, "Errore !!! Sei già in possesso della tessera","Error",JOptionPane.ERROR_MESSAGE);




    }


    /// Aggiunta degli Action Listener per i vari pannelli

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

    private void addBigliettoPurchaseListener() {
        frameCustomer.getTicketPurchasePanel().getButtonAcquista().addActionListener(e -> {
            if (frameCustomer.getTicketPurchasePanel().getButtonAcquista().getActionCommand() != null) {
                acquistoBiglietto();
            }
        });
    }


    ///  TEST --- RIMUOVERE
    public static void main(String[] args) {
       JCustomerMainFrame fea = new JCustomerMainFrame();

        fea.setVisible(true);
    }


}
