package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.facade.TreniNordOvestFacade;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.service.viaggio.ViaggiModel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.CustomerMainPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class AcquistoController implements ActionListener {


    private final CustomerMainPanel view;
    private final JTreniNordOvestFrame frame;
    private final TreniNordOvestFacade facade;
    private final ViaggiModel viaggiModel;

    public AcquistoController(JTreniNordOvestFrame frame) {
        this.view = frame.getCustomerMainPanel();
        this.frame = frame;
        this.facade = TreniNordOvestFacade.getInstance();
        viaggiModel = new ViaggiModel();

        //Aggiunta dei listener
       addListeners();

    }

    ///  Acquisto dei biglietti
    private void acquistoBiglietto() {

        String idTratta = view.getTicketPurchasePanel().getTextFieldTratta().getText();
        String tipoBiglietto = view.getTicketPurchasePanel().getComboTipoBiglietto().getSelectedItem().toString();
        String tipoPagamento = frame.getPaymentDialog().getMetodoPagamento();
        int quantita = Integer.parseInt(view.getTicketPurchasePanel().getQuantitaSpinner().getValue().toString());

        try {

            if (!idTratta.isEmpty()) {
                TitoloDTO titoloDTO = new TitoloDTO(tipoBiglietto, tipoPagamento, quantita, idTratta);//, ritorno, dataRitorno);
                if (facade.getAcquistoFacade().acquistaBiglietto(titoloDTO)) {
                    JOptionPane.showMessageDialog(view, "Biglietti acquistati");
                } else
                    JOptionPane.showMessageDialog(view, "Errore durante l'acquisto dei biglietti!", "Errore", JOptionPane.ERROR_MESSAGE);

            }
        }catch (Exception e){
            System.out.println("DEBUG : " + e.getMessage());
            JOptionPane.showMessageDialog(view, "Errore di sistema durante l'acquisto!", "Errore", JOptionPane.ERROR_MESSAGE);
        }


    }

    ///  Acquisto dell'abbonamento
    private void acquistoAbbonamento() {

        String tipoAbbonamento = view.getSubscriptionPanel().getComboTipo().getSelectedItem().toString();
        String tipoAcquisto = frame.getPaymentDialog().getMetodoPagamento();
        int quantita = 1;

        TitoloDTO titoloDTO = new TitoloDTO(tipoAbbonamento, tipoAcquisto, quantita);

        try {
            if(frame.getPaymentDialog().getBtnConferma().getActionCommand().equals(PaymentDialog.CMD_Confacquisto)){
                if (facade.getAcquistoFacade().acquistoAbbonamento(titoloDTO)) {
                    JOptionPane.showMessageDialog(view, "Acquisto con successo!");
                } else
                    JOptionPane.showMessageDialog(view, "Abbonamento già posseduto!", "Errore", JOptionPane.ERROR_MESSAGE);

            }

                   } catch (Exception e){
            System.out.println("DEBUG CONTROLLER : " + e.getMessage());
            JOptionPane.showMessageDialog(view, "Errore di sistema durante l'acquisto!", "Errore", JOptionPane.ERROR_MESSAGE);
        }


    }

    ///  Acquisto della tessera
    private void acquistoTessera() {

        try {

            if (facade.getAcquistoFacade().acquistaTessera()) {

                JOptionPane.showMessageDialog(view, "Acquisto con successo!");
            } else
                JOptionPane.showMessageDialog(view, "Errore !!! Tessera posseduta o non valida", "Errore", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println("DEBUG CONTROLLER : " + e.getMessage());
            JOptionPane.showMessageDialog(view, "Errore di sistema durante l'acquisto!", "Errore", JOptionPane.ERROR_MESSAGE);
        }


    }

    private void mostraListaViaggi(){
        List<Viaggio> viaggioList = facade.getAcquistoFacade().mostraViaggiDisponibili();
        viaggiModel.setViaggi(viaggioList);
    }

    /// Aggiunta degli Action Listener per i vari pannelli

    private void addListeners() {
        view.getTicketPurchasePanel().getButtonAcquista().addActionListener(this);
        view.getSubscriptionPanel().getButtonAbbonati().addActionListener(this);
        view.getProfilePanel().getBtnAcquistaTessera().addActionListener(this);
        view.getTicketPurchasePanel().getButtonMostraViaggi().addActionListener(this);
        frame.getPaymentDialog().getBtnConferma().addActionListener(this);

        viaggiModel.addPropertyChangeListener(frame.getCustomerMainPanel().getViaggiTabelPanel());

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        // Usa uno switch per eseguire l'azione corretta per ogni comando
        // CONTROLLA ATTENTAMENTE QUESTA PARTE NEL TUO CODICE!
        switch (command) {
            case SubscriptionPanel.CMD_Abbonati:
                frame.getPaymentDialog().showDialog();
                    acquistoAbbonamento();
                break;

            case TicketPurchasePanel.CMD_Acquista:
                int qta = Integer.parseInt(view.getTicketPurchasePanel().getQuantitaSpinner().getValue().toString());
                if(qta > 0){
                    frame.getPaymentDialog().showDialog();
                    acquistoBiglietto();

                } else
                    JOptionPane.showMessageDialog(view, "Quantità biglietti non valida!", "Errore", JOptionPane.ERROR_MESSAGE);

                break;

            case CustomerProfilePanel.CMD_AcquistaTessera:
                acquistoTessera();
                break;

            case TicketPurchasePanel.CMD_MostraViaggi:
                mostraListaViaggi();
                break;



        }
    }
}