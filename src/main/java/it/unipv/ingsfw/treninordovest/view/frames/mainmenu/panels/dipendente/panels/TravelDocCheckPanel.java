package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.dipendente.panels;

import javax.swing.*;
import java.awt.*;

public class TravelDocCheckPanel extends JPanel {
    private final JTextField textFieldIdTitolo;
    private final JButton verificaButton;

    public TravelDocCheckPanel() {
        this.setBackground(Color.getHSBColor(205,(float) 0.33, (float)0.76));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel labelIDTitolo = new JLabel("ID Titolo:");
        textFieldIdTitolo = new JTextField(15);
        verificaButton = new JButton("Verifica titolo");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelIDTitolo, gbc);
        gbc.gridx = 1;
        add(textFieldIdTitolo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(verificaButton, gbc);
    }

    public JTextField getTextFieldIdTitolo() {
        return textFieldIdTitolo;
    }

    public JButton getVerificaButton() {
        return verificaButton;
    }
}
