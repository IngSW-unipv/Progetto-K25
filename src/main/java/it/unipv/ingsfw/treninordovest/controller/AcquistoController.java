package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.model.observer.Observer;
import it.unipv.ingsfw.treninordovest.model.observer.model.AcquistoModel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.CardPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.TicketPurchasePanel;

import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Observable;


public class AcquistoController implements ActionListener, Observer {


    private CardPurchasePanel viewCardPurchase;
    private SubscriptionPanel viewSubscription;
    private JCustomerMainFrame frameCustomer;
    private AcquistoFacade acquistoFacade;
    private AcquistoModel acquistoModel=new AcquistoModel();

    public AcquistoController(CardPurchasePanel viewCardPurchase, JCustomerMainFrame frameCustomer) {
        this.viewCardPurchase = viewCardPurchase;
        this.frameCustomer = frameCustomer;
        this.acquistoFacade = new AcquistoFacade();
        addCardPurchaseListener();

        acquistoModel.addObserver(this);

    }

    public AcquistoController(SubscriptionPanel viewSubscription, JCustomerMainFrame frameCustomer) {
        this.viewSubscription = viewSubscription;
        this.frameCustomer = frameCustomer;
        this.acquistoFacade = new AcquistoFacade();
        addAbbonamentoPurchaseListener();
    }

    public AcquistoController(TicketPurchasePanel viewTicketPurchase, JCustomerMainFrame frameCustomer) {
        this.frameCustomer = frameCustomer;
        this.acquistoFacade = new AcquistoFacade();
        addBigliettoPurchaseListener();
    }


    ///  Acquisto dei biglietti
    public void acquistoBiglietto() {

        String idTratta= frameCustomer.getTicketPurchasePanel().getTextFieldTratta().getText();
        boolean ritorno=frameCustomer.getTicketPurchasePanel().getCheckBoxRitorno().isSelected() ;
        LocalDate dataRitorno= frameCustomer.getTicketPurchasePanel().getDataRitorno().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String tipoBiglietto = frameCustomer.getTicketPurchasePanel().getComboTipoBiglietto().getSelectedItem().toString();
        String tipoPagamento = "cartacredito"; //Provvisorio
        int quantita =  Integer.parseInt(frameCustomer.getTicketPurchasePanel().getQuantitaSpinner().getValue().toString() ) ;

        if(acquistoFacade.acquistaBiglietto(tipoBiglietto,tipoPagamento,quantita,idTratta,ritorno,dataRitorno)) {
            JOptionPane.showMessageDialog(frameCustomer, "Biglietti acquistati");
        } else
            JOptionPane.showMessageDialog(frameCustomer, "Errore durante l'acquisto dei biglietti!","Errore",JOptionPane.ERROR_MESSAGE);



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
            JOptionPane.showMessageDialog(frameCustomer, "Abbonamento già posseduto o tessera non valida!","Errore",JOptionPane.ERROR_MESSAGE);



    }

    ///  Acquisto della tessera
    public void acquistoTessera() {

        if (acquistoFacade.acquistaTessera()) {
            JOptionPane.showMessageDialog(frameCustomer, "Acquisto con successo!");
        } else
            JOptionPane.showMessageDialog(frameCustomer, "Errore !!! Tessera posseduta o non valida","Errore",JOptionPane.ERROR_MESSAGE);




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



    @Override
    public void actionPerformed(ActionEvent e) {


    }


    @Override
    public void update(Object event) {

    }
}
