package it.unipv.ingsfw.treninordovest.view.panels;

import javax.swing.*;
import java.awt.*;

public class TravelSearchPanel extends JPanel {
    private JLabel labelPartenza;
    private JTextField textPartenza;
    private JLabel labelArrivo;
    private JTextField textArrivo;
    private JLabel labelDataViaggio;
    private JTextField textDataViaggio;
    private JButton buttonCerca;

    public TravelSearchPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        labelPartenza = new JLabel("Partenza:");
        textPartenza = new JTextField(15);
        labelArrivo = new JLabel("Arrivo:");
        textArrivo = new JTextField(15);
        labelDataViaggio = new JLabel("Data Viaggio (yyyy-MM-dd):");
        textDataViaggio = new JTextField(10);
        buttonCerca = new JButton("Cerca Viaggio");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelPartenza, gbc);
        gbc.gridx = 1;
        add(textPartenza, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelArrivo, gbc);
        gbc.gridx = 1;
        add(textArrivo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelDataViaggio, gbc);
        gbc.gridx = 1;
        add(textDataViaggio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(buttonCerca, gbc);
    }

    // Getters per il Controller
    public JTextField getTextPartenza() {
        return textPartenza;
    }

    public JTextField getTextArrivo() {
        return textArrivo;
    }

    public JTextField getTextDataViaggio() {
        return textDataViaggio;
    }

    public JButton getButtonCerca() {
        return buttonCerca;
    }
}
