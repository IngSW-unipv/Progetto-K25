package it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class TicketPurchasePanel extends JPanel {
    //private JLabel labelDestinazione;
    //private JTextField textFieldDestinazione;
    private JLabel labelIDTratta;
    private JTextField textFieldTratta;
    private JButton buttonAcquista;
    private JCheckBox checkBoxRitorno;
    private JLabel labelRitorno;
    private JDateChooser dataRitorno;
    //private TratteTablePanel tratteTablePanel;

    /*DA MODIFICARE*/

    public TicketPurchasePanel() {
        setLayout(new BorderLayout());

        // Pannello per i controlli
        JPanel panelInput = new JPanel(new FlowLayout());
        //Partenza
        labelIDTratta = new JLabel("Inserisci l'ID Tratta:");
        textFieldTratta = new JTextField(20);
        labelRitorno = new JLabel("Data Ritorno:");
        checkBoxRitorno = new JCheckBox("Ritorno");
        dataRitorno = new JDateChooser();
        buttonAcquista = new JButton("Acquista Biglietto");


        /*panelInput.add(labelDestinazione);
        panelInput.add(textFieldDestinazione);*/
        panelInput.add(labelIDTratta);
        panelInput.add(textFieldTratta);
        panelInput.add(buttonAcquista);
        panelInput.add(checkBoxRitorno);
        panelInput.add(labelRitorno);
        panelInput.add(dataRitorno);





        add(panelInput, BorderLayout.NORTH);

        // Qui potresti aggiungere ulteriori componenti, ad es. una tabella dei risultati o un'area di messaggi.
    }

    // Metodi getter per il controller

    public JButton getButtonAcquista() {
        return buttonAcquista;
    }

    public JDateChooser getDataRitorno() {
        return dataRitorno;
    }

    public JTextField getTextFieldTratta() {
        return textFieldTratta;
    }

    public JCheckBox getCheckBoxRitorno() {
        return checkBoxRitorno;
    }
}