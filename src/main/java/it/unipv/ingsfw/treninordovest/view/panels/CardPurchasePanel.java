package it.unipv.ingsfw.treninordovest.view.panels;

import javax.swing.*;
import java.awt.*;

public class CardPurchasePanel extends JPanel {
    private JLabel labelIDCliente;
    private JTextField textIDCliente;
    private JButton buttonAcquistaTessera;

    public CardPurchasePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        labelIDCliente = new JLabel("ID Cliente:");
        textIDCliente = new JTextField(15);
        buttonAcquistaTessera = new JButton("Acquista Tessera");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelIDCliente, gbc);
        gbc.gridx = 1;
        add(textIDCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(buttonAcquistaTessera, gbc);
    }

    // Getters per il Controller
    public JTextField getTextIDCliente() {
        return textIDCliente;
    }

    public JButton getButtonAcquistaTessera() {
        return buttonAcquistaTessera;
    }
}