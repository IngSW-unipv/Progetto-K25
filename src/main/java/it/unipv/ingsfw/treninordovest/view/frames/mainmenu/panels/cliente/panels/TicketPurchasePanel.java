package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class TicketPurchasePanel extends JPanel {
    //private JLabel labelDestinazione;
    //private JTextField textFieldDestinazione;
    private final JLabel labelIDTratta;
    private JSpinner quantitaSpinner;
    private JTextField textFieldTratta;
    private JButton buttonAcquista;
    private JCheckBox checkBoxRitorno;
    private JLabel labelRitorno;
    private JDateChooser dataRitorno;
    private JComboBox<String> comboTipoBiglietto;
    public static final String CMD_Acquista = "acquista";
    //private TratteTablePanel tratteTablePanel;

    /*DA MODIFICARE*/


    public TicketPurchasePanel() {

        setLayout(new BorderLayout());

        // Pannello per i controlli
        JPanel panelInput = new JPanel(new FlowLayout());
        //Partenza
        labelIDTratta = new JLabel("Id Viaggio da acquistare:");
        textFieldTratta = new JTextField(20);
        labelRitorno = new JLabel("Data Ritorno:");
        checkBoxRitorno = new JCheckBox("Ritorno");
        dataRitorno = new JDateChooser();
        buttonAcquista = new JButton("Acquista Biglietto");
        quantitaSpinner = new JSpinner();
        String[] tipo = new String[]{"Andata", "AndataRitorno"};
        comboTipoBiglietto = new JComboBox<>(tipo);


        /*panelInput.add(labelDestinazione);
        panelInput.add(textFieldDestinazione);*/
        panelInput.add(labelIDTratta);
        panelInput.add(textFieldTratta);
        panelInput.add(buttonAcquista);
        panelInput.add(checkBoxRitorno);
        panelInput.add(labelRitorno);
        panelInput.add(dataRitorno);
        panelInput.add(quantitaSpinner);
        panelInput.add(comboTipoBiglietto);

        buttonAcquista.setActionCommand(CMD_Acquista);




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

    public JSpinner getQuantitaSpinner() {
        return quantitaSpinner;}

    public JComboBox<String> getComboTipoBiglietto() {
        return comboTipoBiglietto;
    }
}