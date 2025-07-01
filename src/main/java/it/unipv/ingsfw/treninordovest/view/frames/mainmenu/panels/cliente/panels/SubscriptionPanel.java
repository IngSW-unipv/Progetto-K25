package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class SubscriptionPanel extends JPanel {
    private JLabel labelTipo;
    private JComboBox<String> comboTipo;
    private JLabel labelDataInizio;
    private JDateChooser textDataInizio;
    private JButton buttonAbbonati;

    public SubscriptionPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        labelTipo = new JLabel("Tipo Abbonamento:");
        String[] tipi = {"Mensile", "Annuale", "Settimanale"};
        comboTipo = new JComboBox<>(tipi);

        labelDataInizio = new JLabel("Data Inizio (yyyy-MM-dd):");
        textDataInizio = new JDateChooser();

        buttonAbbonati = new JButton("Abbonati");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelTipo, gbc);
        gbc.gridx = 1;
        add(comboTipo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelDataInizio, gbc);
        gbc.gridx = 1;
        add(textDataInizio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(buttonAbbonati, gbc);
    }

    // Getters per il Controller
    public JComboBox<String> getComboTipo() {
        return comboTipo;
    }

    public JDateChooser getTextDataInizio() {
        return textDataInizio;
    }

    public JButton getButtonAbbonati() {
        return buttonAbbonati;
    }
}