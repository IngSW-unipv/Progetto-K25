package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels;

import com.toedter.calendar.JDateChooser;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.viaggitable.ViaggiTableModel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.viaggitable.ViaggiTablePanel;

import javax.swing.*;
import java.awt.*;

public class TicketPurchasePanel extends JPanel {
    //private JLabel labelDestinazione;
    //private JTextField textFieldDestinazione;
    private final JLabel labelIDTratta;
    private final JSpinner quantitaSpinner;
    private final JTextField textFieldTratta;
    private final JButton buttonAcquista;
    private final JButton buttonMostraViaggi;
    private final JCheckBox checkBoxRitorno;
    private final JLabel labelRitorno;
    private final JDateChooser dataRitorno;
    private JComboBox<String> comboTipoBiglietto;
    public static final String CMD_Acquista = "acquista";
    public static final String CMD_MostraViaggi = "mostraViaggi";
    //private ViaggiTablePanel tratteTablePanel;
    private CreditCardDialog creditCardDialog;

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
        buttonMostraViaggi = new JButton("Mostra Viaggi");
        quantitaSpinner = new JSpinner();
        String[] tipo = new String[]{"Andata", "AndataRitorno"};
        comboTipoBiglietto = new JComboBox<>(tipo);



        panelInput.add(buttonMostraViaggi);
        panelInput.add(labelIDTratta);
        panelInput.add(textFieldTratta);
        panelInput.add(buttonAcquista);
//        panelInput.add(checkBoxRitorno);
//        panelInput.add(labelRitorno);
//        panelInput.add(dataRitorno);
        panelInput.add(quantitaSpinner);
        panelInput.add(comboTipoBiglietto);


        buttonAcquista.setActionCommand(CMD_Acquista);
        buttonMostraViaggi.setActionCommand(CMD_MostraViaggi);


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

    public JButton getButtonMostraViaggi() {
        return buttonMostraViaggi;
    }

    public CreditCardDialog getCreditCardDialog() {
        return creditCardDialog;
    }
}