package it.unipv.ingsfw.treninordovest.view.panels.finance;

import javax.swing.*;
import java.awt.*;

public class TicketPurchasePanel extends JPanel {
    private JLabel labelDestinazione;
    private JTextField textFieldDestinazione;
    private JLabel labelPartenza;
    private JTextField textFieldPartenza;
    private JButton buttonAcquista;

    /*DA MODIFICARE*/

    public TicketPurchasePanel() {
        setLayout(new BorderLayout());

        // Pannello per i controlli
        JPanel panelInput = new JPanel(new FlowLayout());
        //Partenza
        labelPartenza = new JLabel("Inserisci partenza:");
        textFieldPartenza = new JTextField(20);
        //Destinazione
        labelDestinazione = new JLabel("Inserisci destinazione:");
        textFieldDestinazione = new JTextField(20);
        //Pulsante
        buttonAcquista = new JButton("Acquista Biglietto");

        panelInput.add(labelDestinazione);
        panelInput.add(textFieldDestinazione);
        panelInput.add(labelPartenza);
        panelInput.add(textFieldPartenza);
        panelInput.add(buttonAcquista);


        add(panelInput, BorderLayout.NORTH);

        // Qui potresti aggiungere ulteriori componenti, ad es. una tabella dei risultati o un'area di messaggi.
    }

    // Metodi getter per il controller
    public JTextField getTextFieldDestinazione() {
        return textFieldDestinazione;
    }

    public JButton getButtonAcquista() {
        return buttonAcquista;
    }
}