package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.model.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.CustomerMainPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.CreditCardDialog;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.TicketPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.menu.MainMenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;



public class AcquistoController implements ActionListener {


    private final CustomerMainPanel view;
    private final JTreniNordOvestFrame frame;
    private final AcquistoFacade acquistoFacade;

    public AcquistoController(JTreniNordOvestFrame frame) {
        this.view = frame.getCustomerMainPanel();
        this.frame = frame;
        this.acquistoFacade = new AcquistoFacade();

        //Aggiunta dei listener
       addListeners();

    }

    ///  Acquisto dei biglietti
    public void acquistoBiglietto() {

        String idTratta = view.getTicketPurchasePanel().getTextFieldTratta().getText();
        boolean ritorno = view.getTicketPurchasePanel().getCheckBoxRitorno().isSelected();
        LocalDate dataRitorno = view.getTicketPurchasePanel().getDataRitorno().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String tipoBiglietto = view.getTicketPurchasePanel().getComboTipoBiglietto().getSelectedItem().toString();
        String tipoPagamento = "cartacredito"; //Provvisorio
        int quantita = Integer.parseInt(view.getTicketPurchasePanel().getQuantitaSpinner().getValue().toString());

        if (acquistoFacade.acquistaBiglietto(tipoBiglietto, tipoPagamento, quantita, idTratta, ritorno, dataRitorno)) {
            JOptionPane.showMessageDialog(view, "Biglietti acquistati");
        } else
            JOptionPane.showMessageDialog(view, "Errore durante l'acquisto dei biglietti!", "Errore", JOptionPane.ERROR_MESSAGE);


    }

    ///  Acquisto dell'abbonamento
    public void acquistoAbbonamento() {

        String tipoAbbonamento = view.getSubscriptionPanel().getComboTipo().getSelectedItem().toString();
        String tipoAcquisto = "cartacredito"; //DA DEFINIRE
        int quantita = 1;

        if (acquistoFacade.acquistoAbbonamento(tipoAbbonamento, tipoAcquisto, quantita)) {
            JOptionPane.showMessageDialog(view, "Acquisto con successo!");
        } else
            JOptionPane.showMessageDialog(view, "Abbonamento già posseduto o tessera non valida!", "Errore", JOptionPane.ERROR_MESSAGE);

    }

    ///  Acquisto della tessera
    public void acquistoTessera() {

        if (acquistoFacade.acquistaTessera()) {
            JOptionPane.showMessageDialog(view, "Acquisto con successo!");
        } else
            JOptionPane.showMessageDialog(view, "Errore !!! Tessera posseduta o non valida", "Errore", JOptionPane.ERROR_MESSAGE);


    }

    /// Aggiunta degli Action Listener per i vari pannelli

    private void addListeners() {
        view.getTicketPurchasePanel().getButtonAcquista().addActionListener(this);
        view.getSubscriptionPanel().getButtonAbbonati().addActionListener(this);
        view.getCardPurchasePanel().getButtonAcquistaTessera().addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        CreditCardDialog creditCardDialog = new CreditCardDialog(frame);
        creditCardDialog.getConfirmButton().addActionListener(this);
        creditCardDialog.getCancelButton().addActionListener(this);

        String command = e.getActionCommand();
        // Usa uno switch per eseguire l'azione corretta per ogni comando
        // CONTROLLA ATTENTAMENTE QUESTA PARTE NEL TUO CODICE!
        switch (command) {
            case SubscriptionPanel.CMD_Abbonati:
                creditCardDialog.showDialog();
                if (creditCardDialog.getConfirmButton().getActionCommand().equals(CreditCardDialog.CMD_Confirm)) {
                    acquistoAbbonamento();
                }
                break;

            case TicketPurchasePanel.CMD_Acquista:
                creditCardDialog.showDialog();
                if (creditCardDialog.getConfirmButton().getActionCommand().equals(CreditCardDialog.CMD_Confirm)) {
                    acquistoBiglietto();
                }
                break;

            case CardPurchasePanel.CMD_AcquistaTessera:
                acquistoTessera();
                break;

        }
    }
}