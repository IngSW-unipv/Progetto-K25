package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.model.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.CustomerMainPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.TicketPurchasePanel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;



public class AcquistoController  {


    private final CustomerMainPanel view;
    private final AcquistoFacade acquistoFacade;
    private final JTreniNordOvestFrame frame=null;

   public AcquistoController(CustomerMainPanel view) {
        this.view=view;
        this.acquistoFacade = new AcquistoFacade();
        this.addListeners();
    }

    ///  Acquisto dei biglietti
    public void acquistoBiglietto() {

        String idTratta= view.getTicketPurchasePanel().getTextFieldTratta().getText();
        boolean ritorno= view.getTicketPurchasePanel().getCheckBoxRitorno().isSelected();
        LocalDate dataRitorno= view.getTicketPurchasePanel().getDataRitorno().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String tipoBiglietto =view.getTicketPurchasePanel().getComboTipoBiglietto().getSelectedItem().toString();
        String tipoPagamento = "cartacredito"; //Provvisorio
        int quantita =  Integer.parseInt(view.getTicketPurchasePanel().getQuantitaSpinner().getValue().toString() ) ;

        if(acquistoFacade.acquistaBiglietto(tipoBiglietto,tipoPagamento,quantita,idTratta,ritorno,dataRitorno)) {
            JOptionPane.showMessageDialog(view, "Biglietti acquistati");
        } else
            JOptionPane.showMessageDialog(view, "Errore durante l'acquisto dei biglietti!","Errore",JOptionPane.ERROR_MESSAGE);



    }

    ///  Acquisto dell'abbonamento
    public void acquistoAbbonamento() {

       String tipoAbbonamento=view.getSubscriptionPanel().getComboTipo().getSelectedItem().toString();
       String tipoAcquisto=null; //DA DEFINIRE
       int quantita=1;

        if(acquistoFacade.acquistoAbbonamento(tipoAbbonamento,tipoAcquisto,quantita)){
            JOptionPane.showMessageDialog(view, "Acquisto con successo!");
        }
        else
            JOptionPane.showMessageDialog(view, "Abbonamento già posseduto o tessera non valida!","Errore",JOptionPane.ERROR_MESSAGE);

    }

    ///  Acquisto della tessera
    public void acquistoTessera() {

        if (acquistoFacade.acquistaTessera()) {
            JOptionPane.showMessageDialog(view, "Acquisto con successo!");
        } else
            JOptionPane.showMessageDialog(view, "Errore !!! Tessera posseduta o non valida","Errore",JOptionPane.ERROR_MESSAGE);




    }

    /// Aggiunta degli Action Listener per i vari pannelli

    private void addListeners() {
        // La logica è direttamente collegata al pulsante.
        view.getTicketPurchasePanel().getButtonAcquista().addActionListener(e -> {
            if (view.getTicketPurchasePanel().getButtonAcquista().getActionCommand().equals(TicketPurchasePanel.CMD_Acquista)){
                acquistoBiglietto();
            }

        });
        view.getSubscriptionPanel().getButtonAbbonati().addActionListener(e -> {
            if(view.getSubscriptionPanel().getButtonAbbonati().getActionCommand().equals(SubscriptionPanel.CMD_Abbonati)){
                acquistoAbbonamento();
            }
        });
        view.getCardPurchasePanel().getButtonAcquistaTessera().addActionListener(e -> acquistoTessera());
    }







}
