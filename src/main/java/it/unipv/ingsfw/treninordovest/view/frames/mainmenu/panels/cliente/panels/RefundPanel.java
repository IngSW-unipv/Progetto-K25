package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels;

import javax.swing.*;
import java.awt.*;

public class RefundPanel extends JPanel {
    private JLabel labelIDBiglietto;
    private JTextField textIDBiglietto;
    private JButton buttonRimborso;

    public static final String CMD_Rimborso = "rimborso";

    public RefundPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        labelIDBiglietto = new JLabel("ID Biglietto:");
        textIDBiglietto = new JTextField(15);
        buttonRimborso = new JButton("Richiedi Rimborso");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelIDBiglietto, gbc);
        gbc.gridx = 1;
        add(textIDBiglietto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(buttonRimborso, gbc);

        buttonRimborso.setActionCommand(CMD_Rimborso);
    }

    // Getters per il Controller
    public JTextField getTextIDBiglietto() {
        return textIDBiglietto;
    }

    public JButton getButtonRimborso() {
        return buttonRimborso;
    }
}
